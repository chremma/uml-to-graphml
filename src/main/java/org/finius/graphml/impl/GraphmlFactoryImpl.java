/**
 *
 */
package org.finius.graphml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.finius.graphml.*;

/**
 * An implementation of the model <b>Factory</b>.
 */
public class GraphmlFactoryImpl extends EFactoryImpl implements GraphmlFactory {
    /**
     * Creates the default factory implementation.
     */
    public static GraphmlFactory init() {
        try {
            GraphmlFactory theGraphmlFactory = (GraphmlFactory) EPackage.Registry.INSTANCE
                    .getEFactory( GraphmlPackage.eNS_URI );
            if( theGraphmlFactory != null ) {
                return theGraphmlFactory;
            }
        } catch( Exception exception ) {
            EcorePlugin.INSTANCE.log( exception );
        }
        return new GraphmlFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     */
    public GraphmlFactoryImpl() {
        super();
    }

    @Override
    public EObject create( EClass eClass ) {
		return switch( eClass.getClassifierID() ) {
			case GraphmlPackage.GRAPH_ML -> createGraphML();
			case GraphmlPackage.GRAPH -> 	createGraph();
			case GraphmlPackage.NODE -> 	createNode();
			case GraphmlPackage.EDGE -> 	createEdge();
			case GraphmlPackage.DATA ->		createData();
			default ->
					throw new IllegalArgumentException( "Class '" + eClass.getName() + "' is not a valid classifier" );
		};
    }

    public GraphML createGraphML() {
        return new GraphMLImpl();
    }

    public Graph createGraph() {
        return new GraphImpl();
    }

    public Node createNode() {
        return new NodeImpl();
    }

    public Edge createEdge() {
        return new EdgeImpl();
    }

    public Data createData() {
        return new DataImpl();
    }

    public GraphmlPackage getGraphmlPackage() {
        return (GraphmlPackage) getEPackage();
    }

    @Deprecated
    public static GraphmlPackage getPackage() {
        return GraphmlPackage.eINSTANCE;
    }

}
