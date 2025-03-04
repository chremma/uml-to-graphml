/**
 */
package org.finius.graphml;

import org.eclipse.emf.common.util.EList;

/**
 * A representation of the model object '<em><b>Graph</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link Graph#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getGraph()
 */
public interface Graph extends ConnectableElement {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link Node}.
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see GraphmlPackage#getGraph_Nodes()
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link Edge}.
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see GraphmlPackage#getGraph_Edges()
	 */
	EList<Edge> getEdges();

}
