package org.finius;

import org.apache.commons.cli.*;
import org.finius.graphml.GraphML;
import org.finius.transformations.PapyrusUML2GraphML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    private static final Option INPUT_OPTION = Option.builder( "input" ).
            argName( "INPUT-FILE" ).
            desc( "Input file to convert. Possible extensions (.uml|.graphml)" ).
            hasArg().
            required().
            build();
    private static final Option OUTPUT_OPTION = Option.builder( "output" ).
            argName( "OUTPUT-FILE" ).
            desc( "Output file. Optional extensions (.uml|.graphml)" ).
            hasArg().
            required().
            build();
    private static final Option HELP_OPTION = Option.builder( "help" ).
            desc( "Display this help information" ).
            build();

    private static final Options OPTIONS = new Options().
            addOption( INPUT_OPTION ).
            addOption( OUTPUT_OPTION ).
            addOption( HELP_OPTION );

    private static final String EXTENSION_UML = "uml";
    private static final String EXTENSION_GRAPHML = "graphml";
    private static final String[] EXTENSIONS = { EXTENSION_UML, EXTENSION_GRAPHML };


    public static void main( String[] args ) {
        if( Arrays.stream( args ).
                anyMatch( s ->
                        s.substring( 1 ).equals( HELP_OPTION.getOpt() ) ||
                        s.substring( 1 ).equals( HELP_OPTION.getLongOpt() ) ) ) {
            new HelpFormatter().printHelp( String.format( "uml-to-graphml -%s inputfile -%s outputfile", INPUT_OPTION.getOpt(), OUTPUT_OPTION.getOpt() ), OPTIONS );
        } else {
            try {
                CommandLine cmdLine = new DefaultParser().parse( OPTIONS, args );

                String inFileName  = cmdLine.getOptionValue( INPUT_OPTION ).toLowerCase();
                String outFileName = cmdLine.getOptionValue( OUTPUT_OPTION ).toLowerCase();
                String inFileExt   = getFileExtension( inFileName );
                String outFileExt  = getFileExtension( outFileName );
                String csList      = Arrays.stream( EXTENSIONS ).collect( Collectors.joining( " | " ) );

                System.out.printf( "-%s: %s%n", INPUT_OPTION.getOpt(),  inFileName );
                System.out.printf( "-%s: %s%n", OUTPUT_OPTION.getOpt(), outFileName );

                if( inFileExt.isEmpty() )
                    throw new ParseException( String.format( "Missing file-extension (%s) for option: -%s%n", csList, INPUT_OPTION.getOpt() ) );
                else if( isInvalidExtension( inFileExt ) )
                    throw new ParseException( String.format( "Bad extension (%s) for option: -%s. Expected extensions: (%s)%n", inFileExt, INPUT_OPTION.getOpt(), csList ) );

                else if( outFileExt.isEmpty() ) {
                    outFileExt = inFileExt.equals( EXTENSION_UML ) ? EXTENSION_GRAPHML : EXTENSION_UML;
                    outFileName = outFileName + (outFileName.lastIndexOf( '.' ) == -1 ? "." : "") + outFileExt;
                    System.out.printf( "Implied extension '%s' for option: -%s%n", outFileExt, OUTPUT_OPTION.getOpt() );
                } else if( isInvalidExtension( outFileExt ) )
                    throw new ParseException( String.format( "Bad extension (%s) for option: -%s. Expected extensions: (%s)%n", outFileExt, OUTPUT_OPTION.getOpt(), csList ) );

                if( inFileExt.equals( outFileExt ) )         copyFiles( inFileName, outFileName );
                else if( inFileExt.equals( EXTENSION_UML ) ) transformUMLToGraphML( inFileName, outFileName );
                else                                         transformGraphMLToUML( inFileName, outFileName );

            } catch( ParseException e ) {
                System.out.println( e.getMessage() );
            }
        }
    }

    private static String getFileExtension( String fileName ) {
        int lastIndexOfDot = fileName.lastIndexOf( '.' );
        if( lastIndexOfDot == -1 || lastIndexOfDot == fileName.length() - 1 ) return "";
        return fileName.substring( lastIndexOfDot + 1 );
    }

    private static boolean isInvalidExtension( String extension ) {
        return Arrays.stream( EXTENSIONS ).noneMatch( s -> s.equals( extension ) );
    }

    private static void transformUMLToGraphML( String source, String destin ) {
        System.out.println( "Transforming UML to GraphML..." );
        GraphML graphml = new PapyrusUML2GraphML( source ).getGraphml();
        System.out.println( "Finished with transformation" );

        GraphMLModelExporter modelExporter = new GraphMLModelExporter( graphml );
        String               graphXML      = modelExporter.buildGraphXML();

        saveFile( destin, graphXML );
    }

    private static void transformGraphMLToUML( String source, String destin ) {
        System.out.println( "Transformation GraphML to UML is currently not implemented" );
    }


    private static void copyFiles( String source, String destin ) {
        System.out.println( "Copying files..." );
        try {
            Files.copy( Path.of( source ), Path.of( destin ), StandardCopyOption.REPLACE_EXISTING );
            System.out.println( "Done" );
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void saveFile( String filename, String content ) {
        System.out.println( "Saving file: " + filename );

        File file = new File( filename );

        try( BufferedWriter writer = new BufferedWriter( new FileWriter( file ) ) ) {
            writer.write( content );
            System.out.println( "Done" );
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

}