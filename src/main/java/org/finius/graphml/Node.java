/**
 */
package org.finius.graphml;

/**
 * A representation of the model object '<em><b>Node</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Node#getGraph <em>Graph</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getNode()
 */
public interface Node extends ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see GraphmlPackage#getNode_Graph()
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link Node#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 */
	void setGraph(Graph value);

}
