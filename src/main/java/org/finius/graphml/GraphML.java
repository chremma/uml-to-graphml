/**
 */
package org.finius.graphml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * A representation of the model object '<em><b>Graph ML</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link GraphML#getGraphs <em>Graphs</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getGraphML()
 */
public interface GraphML extends EObject {
	/**
	 * Returns the value of the '<em><b>Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link Graph}.
	 * @return the value of the '<em>Graphs</em>' containment reference list.
	 * @see GraphmlPackage#getGraphML_Graphs()
	 */
	EList<Graph> getGraphs();

}
