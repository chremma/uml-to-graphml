/**
 */
package org.finius.graphml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.finius.graphml.impl.*;

/**
 * The <b>Package</b> for the model.
 * It contains accessors for the metaobjects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * @see GraphmlFactory
 */
public interface GraphmlPackage extends EPackage {
	/**
	 * The package name.
	 */
	String eNAME = "graphml";

	/**
	 * The package namespace URI.
	 */
	String eNS_URI = "http://www.example.org/graphml";

	/**
	 * The package namespace name.
	 */
	String eNS_PREFIX = "graphml";

	/**
	 * The singleton instance of the package.
	 */
	GraphmlPackage eINSTANCE = GraphmlPackageImpl.init();

	/**
	 * The metaobject id for the '{@link GraphMLImpl <em>Graph ML</em>}' class.
	 * @see GraphMLImpl
	 * @see GraphmlPackageImpl#getGraphML()
	 */
	int GRAPH_ML = 0;

	/**
	 * The feature id for the '<em><b>Graphs</b></em>' containment reference list.
	 */
	int GRAPH_ML__GRAPHS = 0;

	/**
	 * The number of structural features of the '<em>Graph ML</em>' class.
	 */
	int GRAPH_ML_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Graph ML</em>' class.
	 */
	int GRAPH_ML_OPERATION_COUNT = 0;

	/**
	 * The metaobject id for the '{@link ElementImpl <em>Element</em>}' class.
	 * @see ElementImpl
	 * @see GraphmlPackageImpl#getElement()
	 */
	int ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 */
	int ELEMENT__DATA_ATTRIBUTES = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 */
	int ELEMENT__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 */
	int ELEMENT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The metaobject id for the '{@link ConnectableElementImpl <em>Connectable Element</em>}' class.
	 * @see ConnectableElementImpl
	 * @see GraphmlPackageImpl#getConnectableElement()
	 */
	int CONNECTABLE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 */
	int CONNECTABLE_ELEMENT__DATA_ATTRIBUTES = ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 */
	int CONNECTABLE_ELEMENT__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 */
	int CONNECTABLE_ELEMENT__NAME = ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Connectable Element</em>' class.
	 */
	int CONNECTABLE_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Connectable Element</em>' class.
	 */
	int CONNECTABLE_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The metaobject id for the '{@link GraphImpl <em>Graph</em>}' class.
	 * @see GraphImpl
	 * @see GraphmlPackageImpl#getGraph()
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 */
	int GRAPH__DATA_ATTRIBUTES = CONNECTABLE_ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 */
	int GRAPH__ID = CONNECTABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 */
	int GRAPH__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 */
	int GRAPH__NODES = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 */
	int GRAPH__EDGES = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 */
	int GRAPH_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 */
	int GRAPH_OPERATION_COUNT = CONNECTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The metaobject id for the '{@link NodeImpl <em>Node</em>}' class.
	 * @see NodeImpl
	 * @see GraphmlPackageImpl#getNode()
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 */
	int NODE__DATA_ATTRIBUTES = CONNECTABLE_ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 */
	int NODE__ID = CONNECTABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 */
	int NODE__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 */
	int NODE__GRAPH = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 */
	int NODE_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 */
	int NODE_OPERATION_COUNT = CONNECTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The metaobject id for the '{@link EdgeImpl <em>Edge</em>}' class.
	 * @see EdgeImpl
	 * @see GraphmlPackageImpl#getEdge()
	 */
	int EDGE = 4;

	/**
	 * The feature id for the '<em><b>Data Attributes</b></em>' containment reference list.
	 */
	int EDGE__DATA_ATTRIBUTES = ELEMENT__DATA_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 */
	int EDGE__ID = ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 */
	int EDGE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 */
	int EDGE__SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 */
	int EDGE__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 */
	int EDGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 */
	int EDGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The metaobject id for the '{@link DataImpl <em>Data</em>}' class.
	 * @see DataImpl
	 * @see GraphmlPackageImpl#getData()
	 */
	int DATA = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 */
	int DATA__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 */
	int DATA__KEY = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 */
	int DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * Returns the metaobject for class '{@link GraphML <em>Graph ML</em>}'.
	 * @return the metaobject for class '<em>Graph ML</em>'.
	 * @see GraphML
	 */
	EClass getGraphML();

	/**
	 * Returns the metaobject for the containment reference list '{@link GraphML#getGraphs <em>Graphs</em>}'.
	 * @return the metaobject for the containment reference list '<em>Graphs</em>'.
	 * @see GraphML#getGraphs()
	 * @see #getGraphML()
	 */
	EReference getGraphML_Graphs();

	/**
	 * Returns the metaobject for class '{@link Graph <em>Graph</em>}'.
	 * @return the metaobject for class '<em>Graph</em>'.
	 * @see Graph
	 */
	EClass getGraph();

	/**
	 * Returns the metaobject for the containment reference list '{@link Graph#getNodes <em>Nodes</em>}'.
	 * @return the metaobject for the containment reference list '<em>Nodes</em>'.
	 * @see Graph#getNodes()
	 * @see #getGraph()
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the metaobject for the containment reference list '{@link Graph#getEdges <em>Edges</em>}'.
	 * @return the metaobject for the containment reference list '<em>Edges</em>'.
	 * @see Graph#getEdges()
	 * @see #getGraph()
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the metaobject for class '{@link Node <em>Node</em>}'.
	 * @return the metaobject for class '<em>Node</em>'.
	 * @see Node
	 */
	EClass getNode();

	/**
	 * Returns the metaobject for the containment reference '{@link Node#getGraph <em>Graph</em>}'.
	 * @return the metaobject for the containment reference '<em>Graph</em>'.
	 * @see Node#getGraph()
	 * @see #getNode()
	 */
	EReference getNode_Graph();

	/**
	 * Returns the metaobject for class '{@link ConnectableElement <em>Connectable Element</em>}'.
	 * @return the metaobject for class '<em>Connectable Element</em>'.
	 * @see ConnectableElement
	 */
	EClass getConnectableElement();

	/**
	 * Returns the metaobject for class '{@link Edge <em>Edge</em>}'.
	 * @return the metaobject for class '<em>Edge</em>'.
	 * @see Edge
	 */
	EClass getEdge();

	/**
	 * Returns the metaobject for the reference '{@link Edge#getSource <em>Source</em>}'.
	 * @return the metaobject for the reference '<em>Source</em>'.
	 * @see Edge#getSource()
	 * @see #getEdge()
	 */
	EReference getEdge_Source();

	/**
	 * Returns the metaobject for the reference '{@link Edge#getTarget <em>Target</em>}'.
	 * @return the metaobject for the reference '<em>Target</em>'.
	 * @see Edge#getTarget()
	 * @see #getEdge()
	 */
	EReference getEdge_Target();

	/**
	 * Returns the metaobject for class '{@link Element <em>Element</em>}'.
	 * @return the metaobject for class '<em>Element</em>'.
	 * @see Element
	 */
	EClass getElement();

	/**
	 * Returns the metaobject for the containment reference list '{@link Element#getDataAttributes <em>Data Attributes</em>}'.
	 * @return the metaobject for the containment reference list '<em>Data Attributes</em>'.
	 * @see Element#getDataAttributes()
	 * @see #getElement()
	 */
	EReference getElement_DataAttributes();

	/**
	 * Returns the metaobject for the attribute '{@link Element#getId <em>Id</em>}'.
	 * @return the metaobject for the attribute '<em>Id</em>'.
	 * @see Element#getId()
	 * @see #getElement()
	 */
	EAttribute getElement_Id();

	/**
	 * Returns the metaobject for the attribute '{@link Element#getName <em>Name</em>}'.
	 * @return the metaobject for the attribute '<em>Name</em>'.
	 * @see Element#getName()
	 * @see #getElement()
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the metaobject for class '{@link Data <em>Data</em>}'.
	 * @return the metaobject for class '<em>Data</em>'.
	 * @see Data
	 */
	EClass getData();

	/**
	 * Returns the metaobject for the attribute '{@link Data#getValue <em>Value</em>}'.
	 * @return the metaobject for the attribute '<em>Value</em>'.
	 * @see Data#getValue()
	 * @see #getData()
	 */
	EAttribute getData_Value();

	/**
	 * Returns the metaobject for the attribute '{@link Data#getKey <em>Key</em>}'.
	 * @return the metaobject for the attribute '<em>Key</em>'.
	 * @see Data#getKey()
	 * @see #getData()
	 */
	EAttribute getData_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * @return the factory that creates the instances of the model.
	 */
	GraphmlFactory getGraphmlFactory();

	/**
	 * Defines literals for the metaobjects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 */
	interface Literals {
		/**
		 * The metaobject literal for the '{@link GraphMLImpl <em>Graph ML</em>}' class.
		 * @see GraphMLImpl
		 * @see GraphmlPackageImpl#getGraphML()
		 */
		EClass GRAPH_ML = eINSTANCE.getGraphML();

		/**
		 * The metaobject literal for the '<em><b>Graphs</b></em>' containment reference list feature.
		 */
		EReference GRAPH_ML__GRAPHS = eINSTANCE.getGraphML_Graphs();

		/**
		 * The metaobject literal for the '{@link GraphImpl <em>Graph</em>}' class.
		 * @see GraphImpl
		 * @see GraphmlPackageImpl#getGraph()
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The metaobject literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The metaobject literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The metaobject literal for the '{@link NodeImpl <em>Node</em>}' class.
		 * @see NodeImpl
		 * @see GraphmlPackageImpl#getNode()
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The metaobject literal for the '<em><b>Graph</b></em>' containment reference feature.
		 */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

		/**
		 * The metaobject literal for the '{@link ConnectableElementImpl <em>Connectable Element</em>}' class.
		 * @see ConnectableElementImpl
		 * @see GraphmlPackageImpl#getConnectableElement()
		 */
		EClass CONNECTABLE_ELEMENT = eINSTANCE.getConnectableElement();

		/**
		 * The metaobject literal for the '{@link EdgeImpl <em>Edge</em>}' class.
		 * @see EdgeImpl
		 * @see GraphmlPackageImpl#getEdge()
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The metaobject literal for the '<em><b>Source</b></em>' reference feature.
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The metaobject literal for the '<em><b>Target</b></em>' reference feature.
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The metaobject literal for the '{@link ElementImpl <em>Element</em>}' class.
		 * @see ElementImpl
		 * @see GraphmlPackageImpl#getElement()
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The metaobject literal for the '<em><b>Data Attributes</b></em>' containment reference list feature.
		 */
		EReference ELEMENT__DATA_ATTRIBUTES = eINSTANCE.getElement_DataAttributes();

		/**
		 * The metaobject literal for the '<em><b>Id</b></em>' attribute feature.
		 */
		EAttribute ELEMENT__ID = eINSTANCE.getElement_Id();

		/**
		 * The metaobject literal for the '<em><b>Name</b></em>' attribute feature.
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The metaobject literal for the '{@link DataImpl <em>Data</em>}' class.
		 * @see DataImpl
		 * @see GraphmlPackageImpl#getData()
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The metaobject literal for the '<em><b>Value</b></em>' attribute feature.
		 */
		EAttribute DATA__VALUE = eINSTANCE.getData_Value();

		/**
		 * The metaobject literal for the '<em><b>Key</b></em>' attribute feature.
		 */
		EAttribute DATA__KEY = eINSTANCE.getData_Key();

	}

}
