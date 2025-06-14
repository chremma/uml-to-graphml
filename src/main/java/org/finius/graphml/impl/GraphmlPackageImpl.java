package org.finius.graphml.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.finius.graphml.*;

/**
 * An implementation of the model <b>Package</b>.
 */
public class GraphmlPackageImpl extends EPackageImpl implements GraphmlPackage {
    private EClass graphMLEClass = null;

    private EClass graphEClass = null;

    private EClass nodeEClass = null;

    private EClass connectableElementEClass = null;

    private EClass edgeEClass = null;

    private EClass elementEClass = null;

    private EClass dataEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     *
     * @see Registry
     * @see GraphmlPackage#eNS_URI
     * @see #init()
     */
    private GraphmlPackageImpl() {
        super( eNS_URI, GraphmlFactory.eINSTANCE );
    }

    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link GraphmlPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     */
    public static GraphmlPackage init() {
        if( isInited )
            return (GraphmlPackage) Registry.INSTANCE.getEPackage( GraphmlPackage.eNS_URI );

        // Obtain or create and register package
        Object registeredGraphmlPackage = Registry.INSTANCE.get( eNS_URI );
        GraphmlPackageImpl theGraphmlPackage = registeredGraphmlPackage instanceof GraphmlPackageImpl
                ? (GraphmlPackageImpl) registeredGraphmlPackage
                : new GraphmlPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theGraphmlPackage.createPackageContents();

        // Initialize created meta-data
        theGraphmlPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theGraphmlPackage.freeze();

        // Update the registry and return the package
        Registry.INSTANCE.put( GraphmlPackage.eNS_URI, theGraphmlPackage );
        return theGraphmlPackage;
    }

    public EClass getGraphML() {
        return graphMLEClass;
    }

    public EReference getGraphML_Graphs() {
        return (EReference) graphMLEClass.getEStructuralFeatures().get( 0 );
    }

    public EClass getGraph() {
        return graphEClass;
    }

    public EReference getGraph_Nodes() {
        return (EReference) graphEClass.getEStructuralFeatures().get( 0 );
    }

    public EReference getGraph_Edges() {
        return (EReference) graphEClass.getEStructuralFeatures().get( 1 );
    }

    public EClass getNode() {
        return nodeEClass;
    }

    public EReference getNode_Graph() {
        return (EReference) nodeEClass.getEStructuralFeatures().get( 0 );
    }

    public EClass getConnectableElement() {
        return connectableElementEClass;
    }

    public EClass getEdge() {
        return edgeEClass;
    }

     public EReference getEdge_Source() {
        return (EReference) edgeEClass.getEStructuralFeatures().get( 0 );
    }

    public EReference getEdge_Target() {
        return (EReference) edgeEClass.getEStructuralFeatures().get( 1 );
    }

    public EClass getElement() {
        return elementEClass;
    }

    public EReference getElement_DataAttributes() {
        return (EReference) elementEClass.getEStructuralFeatures().get( 0 );
    }

    public EAttribute getElement_Id() {
        return (EAttribute) elementEClass.getEStructuralFeatures().get( 1 );
    }

    public EAttribute getElement_Name() {
        return (EAttribute) elementEClass.getEStructuralFeatures().get( 2 );
    }

    public EClass getData() {
        return dataEClass;
    }

    public EAttribute getData_Value() {
        return (EAttribute) dataEClass.getEStructuralFeatures().get( 0 );
    }

    public EAttribute getData_Key() {
        return (EAttribute) dataEClass.getEStructuralFeatures().get( 1 );
    }

    public GraphmlFactory getGraphmlFactory() {
        return (GraphmlFactory) getEFactoryInstance();
    }

    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     */
    public void createPackageContents() {
        if( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        graphMLEClass = createEClass( GRAPH_ML );
        createEReference( graphMLEClass, GRAPH_ML__GRAPHS );

        graphEClass = createEClass( GRAPH );
        createEReference( graphEClass, GRAPH__NODES );
        createEReference( graphEClass, GRAPH__EDGES );

        nodeEClass = createEClass( NODE );
        createEReference( nodeEClass, NODE__GRAPH );

        connectableElementEClass = createEClass( CONNECTABLE_ELEMENT );

        edgeEClass = createEClass( EDGE );
        createEReference( edgeEClass, EDGE__SOURCE );
        createEReference( edgeEClass, EDGE__TARGET );

        elementEClass = createEClass( ELEMENT );
        createEReference( elementEClass, ELEMENT__DATA_ATTRIBUTES );
        createEAttribute( elementEClass, ELEMENT__ID );
        createEAttribute( elementEClass, ELEMENT__NAME );

        dataEClass = createEClass( DATA );
        createEAttribute( dataEClass, DATA__VALUE );
        createEAttribute( dataEClass, DATA__KEY );
    }

    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     */
    public void initializePackageContents() {
        if( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName( eNAME );
        setNsPrefix( eNS_PREFIX );
        setNsURI( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        graphEClass.getESuperTypes().add( this.getConnectableElement() );
        nodeEClass.getESuperTypes().add( this.getConnectableElement() );
        connectableElementEClass.getESuperTypes().add( this.getElement() );
        edgeEClass.getESuperTypes().add( this.getElement() );

        // Initialize classes, features, and operations; add parameters
        initEClass( graphMLEClass, GraphML.class, "GraphML", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getGraphML_Graphs(), this.getGraph(), null, "graphs", null, 0, -1, GraphML.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED );

        initEClass( graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Graph.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED );
        initEReference( getGraph_Edges(), this.getEdge(), null, "edges", null, 0, -1, Graph.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED );

        initEClass( nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getNode_Graph(), this.getGraph(), null, "graph", null, 0, 1, Node.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED );

        initEClass( connectableElementEClass, ConnectableElement.class, "ConnectableElement", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS );

        initEClass( edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getEdge_Source(), this.getConnectableElement(), null, "source", null, 0, 1, Edge.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference( getEdge_Target(), this.getConnectableElement(), null, "target", null, 0, 1, Edge.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass( elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getElement_DataAttributes(), this.getData(), null, "dataAttributes", null, 0, -1, Element.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute( getElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, Element.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute( getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass( dataEClass, Data.class, "Data", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getData_Value(), ecorePackage.getEString(), "value", null, 0, 1, Data.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute( getData_Key(), ecorePackage.getEString(), "key", null, 0, 1, Data.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        // Create resource
        createResource( eNS_URI );
    }

}
