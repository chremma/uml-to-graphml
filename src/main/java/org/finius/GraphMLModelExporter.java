package org.finius;

import org.finius.graphml.*;

import java.util.HashMap;

public class GraphMLModelExporter {

    private static final int SPACES_PER_INDENT = 4;
    private final GraphML    graph;
    private StringBuilder graphXML;
    private StringBuilder dataKeysXML;
    private HashMap<String, String> dataKeys;

    public GraphMLModelExporter( GraphML graph ) {
        this.graph = graph;
    }


    public String buildGraphXML() {
        StringBuilder graphXMLBeginning = new StringBuilder();
        graphXML    = new StringBuilder();
        dataKeysXML = new StringBuilder();
        dataKeys    = new HashMap<>();

        graphXMLBeginning.append( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" );

        graphXMLBeginning.append( """
                <graphml xmlns="http://graphml.graphdrawing.org/xmlns"\r
                    xmlns:java="http://www.yworks.com/xml/yfiles-common/1.0/java"\r
                    xmlns:sys="http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0"\r
                    xmlns:x="http://www.yworks.com/xml/yfiles-common/markup/2.0"\r
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\r
                    xmlns:y="http://www.yworks.com/xml/graphml"\r
                    xmlns:yed="http://www.yworks.com/xml/yed/3"\r
                    xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd">\r
                    \r
                    <key attr.name="Description" attr.type="string" for="graph" id="d0"/>\r
                    <key for="port" id="d1" yfiles.type="portgraphics"/>\r
                    <key for="port" id="d2" yfiles.type="portgeometry"/>\r
                    <key for="port" id="d3" yfiles.type="portuserdata"/>\r
                    <key attr.name="url" attr.type="string" for="node" id="d4"/>\r
                    <key attr.name="description" attr.type="string" for="node" id="d5"/>\r
                    <key for="node" id="d6" yfiles.type="nodegraphics"/>\r
                    <key for="graphml" id="d7" yfiles.type="resources"/>\r
                    <key attr.name="url" attr.type="string" for="edge" id="d8"/>\r
                    <key attr.name="description" attr.type="string" for="edge" id="d9"/>\r
                    <key for="edge" id="d10" yfiles.type="edgegraphics"/>\r
                """ );

        for( Graph g : graph.getGraphs() )
            addGraph( g, 1 );

        graphXMLBeginning.append( dataKeysXML );
        graphXMLBeginning.append( graphXML );
        graphXMLBeginning.append( """
                </graphml> \r
                """ );
        return graphXMLBeginning.toString();
    }

    private void addGraph( Graph g, int i ) {
        String ws = getIndent( i * SPACES_PER_INDENT );
        graphXML.append( ws ).append( "<graph id=\"" + g.getId() + "\" edgedefault=\"directed\">\r\n" );

        for( Node n : g.getNodes() ) addNode( n, i+1 );
        for( Edge e : g.getEdges() ) addEdge( e, i+1 );

        graphXML.append( ws ).append( "</graph>\r\n" );
    }

    private void addNode( Node n, int i ) {
        String ws = getIndent( i * SPACES_PER_INDENT );
        graphXML.append( ws ).append( "<node id=\"" + n.getId() + "\">\r\n" );

        // check if node has subgraph
        if( n.getGraph() != null )            addGraph( n.getGraph(), i+1 );
        for( Data d : n.getDataAttributes() ) addDataKeyOfNode( d, i+1 );

        graphXML.append( ws ).append( "</node>\r\n" );
    }

    private void addEdge( Edge e, int i ) {
        if( e.getSource() != null && e.getTarget() != null /*&&
            ! e.getSource().getId().isEmpty() &&
            ! e.getTarget().getId().isEmpty()*/ ) {
            String ws = getIndent( i * SPACES_PER_INDENT );

            graphXML.append( ws ).append( "<edge source=\"" + e.getSource().getId() + "\" target=\"" + e.getTarget().getId() + "\">\r\n" );
            for( Data d : e.getDataAttributes() ) addDataKeyOfEdge( d, i+1 );
            graphXML.append( ws ).append( "</edge>\r\n" );
        }
    }

    private void addDataAttribute( String key, Data d, int i ) {
        String ws = getIndent( i * SPACES_PER_INDENT );

        if( key.equals( "Label" ) ) {
            graphXML.append( ws ).append( "<data key=\"" + key + "\">" + d.getValue() + "</data>\r\n" );

            graphXML.append( ws ).append( "<data key=\"d6\">\r\n" );
            graphXML.append( ws ).append( "    <y:ShapeNode>\r\n" );
            graphXML.append( ws ).append( "        <y:Geometry height=\"30.0\" width=\"30.0\" x=\"746.6867968000003\" y=\"-12.487705599997412\"/>\r\n" );
            graphXML.append( ws ).append( "        <y:Fill color=\"#FFCC00\" transparent=\"false\"/>\r\n" );
            graphXML.append( ws ).append( "        <y:BorderStyle color=\"#000000\" raised=\"false\" type=\"line\" width=\"1.0\"/>\r\n" );
            graphXML.append( ws ).append( "        <y:NodeLabel alignment=\"center\" autoSizePolicy=\"content\" fontFamily=\"Dialog\" fontSize=\"12\" fontStyle=\"plain\" hasBackgroundColor=\"false\" hasLineColor=\"false\" height=\"18.701171875\" horizontalTextPosition=\"center\" iconTextGap=\"4\" modelName=\"custom\" textColor=\"#000000\" verticalTextPosition=\"bottom\" visible=\"true\" width=\"40.703125\" x=\"-5.3515625\" y=\"5.6494140625\">" );
            graphXML.append( d.getValue() ).append( "\r\n" );
            graphXML.append( ws ).append( "            <y:LabelModel>\r\n" );
            graphXML.append( ws ).append( "                <y:SmartNodeLabelModel distance=\"4.0\"/>\r\n" );
            graphXML.append( ws ).append( "            </y:LabelModel>\r\n" );
            graphXML.append( ws ).append( "            <y:ModelParameter>\r\n" );
            graphXML.append( ws ).append( "            <y:SmartNodeLabelModelParameter labelRatioX=\"0.0\" labelRatioY=\"0.0\" nodeRatioX=\"0.0\" nodeRatioY=\"0.0\" offsetX=\"0.0\" offsetY=\"0.0\" upX=\"0.0\" upY=\"-1.0\"/>\r\n" );
            graphXML.append( ws ).append( "            </y:ModelParameter>\r\n" );
            graphXML.append( ws ).append( "        </y:NodeLabel>\r\n" );
            graphXML.append( ws ).append( "        <y:Shape type=\"rectangle\"/>\r\n" );
            graphXML.append( ws ).append( "    </y:ShapeNode>\r\n" );
            graphXML.append( ws ).append( "</data>\r\n" );
        } else {
            graphXML.append( ws ).append( "<data key=\"" + key + "\">" + d.getValue() + "</data>\r\n" );
        }

    }

    private void addDataKeyOfEdge( Data d, int i ) {
        String keyName = d.getKey().replace( ".", "_" ).replace( ":", "_" );

        if( d.getKey().equals( "ClassName" ) || d.getKey().equals( "Label" ) )
            keyName = d.getKey();

        if( dataKeys.get( keyName ) == null ) {
            dataKeys.put( keyName, keyName );

            String ws = getIndent( SPACES_PER_INDENT );
            dataKeysXML.append( ws ).append( "<key id=\"" + keyName + "\" for=\"edge\" attr.name=\"" + keyName + "\" attr.type=\"string\"/>\r\n" );
        }

        addDataAttribute( keyName, d, i );
    }

    private void addDataKeyOfNode( Data d, int i ) {
        String keyName = d.getKey().replace( ".", "_" ).replace( ":", "_" );

        if( d.getKey().equals( "ClassName" ) || d.getKey().equals( "Label" ) )
            keyName = d.getKey();

        if( dataKeys.get( keyName ) == null ) {
            dataKeys.put( keyName, keyName );

            String ws = getIndent( SPACES_PER_INDENT );
            dataKeysXML.append( ws ).append( "<key id=\"" + keyName + "\" for=\"node\" attr.name=\"" + keyName + "\" attr.type=\"string\"/>\r\n" );
        }

        addDataAttribute( keyName, d, i );
    }

    private static final HashMap<Integer, String> indents = new HashMap<>();

    private String getIndent( int spaces ) {
        String ws = indents.get( spaces );
        if( ws == null ) {
            ws = " ".repeat( spaces );
            indents.put( spaces, ws );
        }
        return ws;
    }
}
