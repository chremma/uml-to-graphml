package org.finius.transformations;

import lombok.Getter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.finius.graphml.*;
import org.finius.graphml.GraphML;
import org.finius.graphml.impl.GraphmlFactoryImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class PapyrusUML2GraphML {
    private static final GraphmlFactory graphFactory = new GraphmlFactoryImpl();
    @Getter
    private final GraphML graphml;

    public PapyrusUML2GraphML( String modelFileName ) {
        graphml = graphFactory.createGraphML();

        try {
            createGraphmlFromEcore( modelFileName );
        } catch( SAXException | IOException | ParserConfigurationException e ) {
            e.printStackTrace();
        }
    }


    private void createGraphmlFromEcore( String inputFileName ) throws SAXException, IOException, ParserConfigurationException {
        Graph graph = graphFactory.createGraph();
        graph.setId( "123" );

        // ---------------------------Initial load--------------------------
        // Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Build Document
        Document document = builder.parse( new File( inputFileName ) );

        // Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        // Here comes the root node
        org.w3c.dom.Element root = document.getDocumentElement();
        // System.out.println( root.getNodeName() );

        // ---------------------------Initial load--------------------------

        // iterate all instances
        org.w3c.dom.NodeList instances = document.getElementsByTagName( "packagedElement" );
        // System.out.println( "============================" );

        for( int i=0; i<instances.getLength(); i++ ) {
            org.w3c.dom.Node node = instances.item( i );
            // System.out.println(); // Just a separator

            if( node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE ) {
                org.w3c.dom.Element eElement    = (org.w3c.dom.Element) node;
                String              attrXmiType = eElement.getAttribute( "xmi:type" );
                String              attrXsiType = eElement.getAttribute( "xsi:type" );

                if( attrXmiType.equals( "uml:Class" ) ||
                    attrXmiType.equals( "uml:AssociationClass" ) ||
                    attrXmiType.equals( "uml:Package" ) ||
                    attrXmiType.equals( "uml:Component" ) ||
                    attrXmiType.equals( "uml:DataType" ) ||

                    attrXsiType.equals( "uml:Class" ) ||
                    attrXsiType.equals( "uml:AssociationClass" ) ||
                    attrXsiType.equals( "uml:Package" ) ||
                    attrXsiType.equals( "uml:Component" ) ||
                    attrXsiType.equals( "uml:DataType" ) ) {

                    addNode( eElement, graph );
                }
            }
        }

        // before edges so the nodes can be found
        graphml.getGraphs().add( graph );

        // iterate all connectors
        for( int i=0; i<instances.getLength(); i++ ) {
            org.w3c.dom.Node node = instances.item( i );
            // System.out.println(); // Just a separator

            if( node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE ) {
                org.w3c.dom.Element  eElement   = (org.w3c.dom.Element) node;
                org.w3c.dom.NodeList interNodes = eElement.getChildNodes();

                for( int j=0; j<interNodes.getLength(); j++ ) {
                    org.w3c.dom.Node interNode = interNodes.item( j );
                    if( interNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE ) {
                        org.w3c.dom.Element interElement = (org.w3c.dom.Element) interNode;

                        addEdge( eElement, interElement, graph );
                    }
                }

                String attrXmiType = eElement.getAttribute( "xmi:type" );
                String attrXsiType = eElement.getAttribute( "xsi:type" );

                if( attrXmiType.equals( "uml:Abstraction" ) ||
                    attrXmiType.equals( "uml:Dependency" ) ||
                    attrXmiType.equals( "uml:Realization" ) ||

                    attrXsiType.equals( "uml:Abstraction" ) ||
                    attrXsiType.equals( "uml:Dependency" ) ||
                    attrXsiType.equals( "uml:Realization" )) {

                    addEdge( eElement, graph );
                }
            }
        }
    }

    private void addNode( org.w3c.dom.Element eElement, Graph graph ) {
        // iterate inner node elements
        org.w3c.dom.NodeList instances = eElement.getElementsByTagName( "packagedElement" );
        // System.out.println( "============================" );

        for( int i=0; i<instances.getLength(); i++ ) {
            org.w3c.dom.Node node = instances.item( i );
            // System.out.println(); // Just a separator

            if( node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE ) {
                org.w3c.dom.Element eElementInner = (org.w3c.dom.Element) node;
                String              attrXmiType   = eElementInner.getAttribute( "xmi:type" );
                String              attrXsiType   = eElementInner.getAttribute( "xsi:type" );

                if( attrXmiType.equals( "uml:Class" ) ||
                    attrXmiType.equals( "uml:AssociationClass" ) ||
                    attrXmiType.equals( "uml:Package" ) ||
                    attrXmiType.equals( "uml:Component" ) ||
                    attrXmiType.equals( "uml:DataType" ) ||

                    attrXsiType.equals( "uml:Class" ) ||
                    attrXsiType.equals( "uml:AssociationClass" ) ||
                    attrXsiType.equals( "uml:Package" ) ||
                    attrXsiType.equals( "uml:Component" ) ||
                    attrXsiType.equals( "uml:DataType" ) ){

                    addNode( eElementInner, graph );
                }
            }
        }

        Node n = graphFactory.createNode();
        n.setId( eElement.getAttribute( "xmi:id" ) );
        n.setName( eElement.getAttribute( "name" ) );

        Data dataClassName = graphFactory.createData();
        dataClassName.setKey( "ClassName" );
        dataClassName.setValue( eElement.getAttribute( "name" ) );
        n.getDataAttributes().add( dataClassName );

        Data dataClassLabel = graphFactory.createData();
        dataClassLabel.setKey( "Label" );
        dataClassLabel.setValue( eElement.getAttribute( "name" ) );
        n.getDataAttributes().add( dataClassLabel );

        // get attributes
        NamedNodeMap attrs = eElement.getAttributes();
        for( int i = 0; i < attrs.getLength(); i++ ) {
            // System.out.print("
            // "+((Attr)attrs.item(i)).getName()+"=\""+((Attr)attrs.item(i)).getValue()+"\"");

            Data additionalAttribute = graphFactory.createData();
            additionalAttribute.setKey( ((Attr) attrs.item( i )).getName() );
            additionalAttribute.setValue( ((Attr) attrs.item( i )).getValue() );
            n.getDataAttributes().add( additionalAttribute );
        }

        /*
         * NodeList attributes = eElement.getElementsByTagName("ATTRIBUTE"); for (int i
         * = 0; i < attributes.getLength(); i++) { org.w3c.dom.Node atr =
         * attributes.item(i); System.out.println("attributes"); // Just a separator if
         * (atr.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) { org.w3c.dom.Element
         * atrElement = (org.w3c.dom.Element) atr;
         *
         * Data additionalAttribute = graphFactory.createData();
         * additionalAttribute.setKey(atrElement.getAttribute("name"));
         * additionalAttribute.setValue(atrElement.getTextContent());
         * n.getDataAttributes().add(additionalAttribute); } }
         */

        graph.getNodes().add( n );
    }

    private void addEdge( org.w3c.dom.Element eElement, org.w3c.dom.Element interElement, Graph graph ) {
        Edge edge = graphFactory.createEdge();
        edge.setId( interElement.getAttribute( "id" ) );
        // edge.setName(interElement.getAttribute("xmi:type"));
        edge.setName( interElement.getTagName() );

        Data dataReferenceName = graphFactory.createData();
        dataReferenceName.setKey( "ReferenceName" );
        dataReferenceName.setValue( interElement.getTagName() );
        edge.getDataAttributes().add( dataReferenceName );

        Data dataReferenceLabel = graphFactory.createData();
        dataReferenceLabel.setKey( "Label" );
        dataReferenceLabel.setValue( interElement.getTagName() );
        edge.getDataAttributes().add( dataReferenceLabel );

//        try {
        edge.setSource( (ConnectableElement) getObjectById( eElement.getAttribute( "xmi:id" ) ) );

        String attrXmiType = interElement.getAttribute( "xmi:type" );
        String attrXsiType = interElement.getAttribute( "xsi:type" );
        String tagName     = interElement.getTagName();

            if( attrXmiType.equals( "uml:Generalization" ) ||
                attrXsiType.equals( "uml:Generalization" ) ||
                tagName.    equals( "generalization" ) )
                edge.setTarget( (ConnectableElement) getObjectById( interElement.getAttribute( "general" ) ) );

            else if( attrXmiType.equals( "uml:Class" ) ||
                     attrXsiType.equals( "uml:Class" ) ||
                     tagName.    equals( "nestedClassifier" ) )
                edge.setTarget( (ConnectableElement) getObjectByName( interElement.getAttribute( "name" ) ) );

            else if( attrXmiType.equals( "uml:ElementImport" ) ||
                     attrXsiType.equals( "uml:ElementImport" ) ||
                     tagName.    equals( "elementImport" ) )
                edge.setTarget( (ConnectableElement) getObjectById( interElement.getAttribute( "importedElement" ) ) );

            else
                edge.setTarget( (ConnectableElement) getObjectById( interElement.getAttribute( "type" ) ) );

            graph.getEdges().add( edge );
//        } catch( Exception e ) {
//            String a;
//        }
    }


    /// for uml:Abstraction, uml:Dependency
    private void addEdge( org.w3c.dom.Element eElement, Graph graph ) {
        Edge edge = graphFactory.createEdge();
        edge.setId( eElement.getAttribute( "id" ) );
        edge.setName( eElement.getTagName() );

        Data dataReferenceName = graphFactory.createData();
        dataReferenceName.setKey( "ReferenceName" );
        dataReferenceName.setValue( eElement.getTagName() );
        edge.getDataAttributes().add( dataReferenceName );

        Data dataReferenceLabel = graphFactory.createData();
        dataReferenceLabel.setKey( "Label" );
        dataReferenceLabel.setValue( eElement.getTagName() );
        edge.getDataAttributes().add( dataReferenceLabel );

//        try {
        String attrXmiType = eElement.getAttribute( "xmi:type" );
        String attrXsiType = eElement.getAttribute( "xsi:type" );

        if( attrXmiType.equals( "uml:InformationFlow" ) ||
            attrXsiType.equals( "uml:InformationFlow" ) ) {
            edge.setSource( (ConnectableElement) getObjectById( eElement.getAttribute( "informationSource" ) ) );
            edge.setTarget( (ConnectableElement) getObjectById( eElement.getAttribute( "informationTarget" ) ) );
        } else {
            edge.setSource( (ConnectableElement) getObjectById( eElement.getAttribute( "client" ) ) );
            edge.setTarget( (ConnectableElement) getObjectById( eElement.getAttribute( "supplier" ) ) );
        }

        graph.getEdges().add( edge );
//        } catch( Exception e ) {
//            String a;
//        }
    }

    private Element getObjectById( String id ) {
        TreeIterator<EObject> it = graphml.eAllContents();
        while( it.hasNext() ) {
            EObject eObject = it.next();
            if( eObject instanceof Element element ) {
                if( element.getId().equals( id ) )
                    return element;
            }
        }
        return null;
    }

    private Element getObjectByName( String name ) {
        TreeIterator<EObject> it = graphml.eAllContents();
        while( it.hasNext() ) {
            EObject eObject = it.next();
            if( eObject instanceof Element element ) {
                if( name.equals( element.getName() ) )
                    return element;
            }
        }
        return null;
    }

}
