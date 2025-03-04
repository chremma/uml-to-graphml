/**
 */
package org.finius.graphml;

import org.eclipse.emf.ecore.EFactory;
import org.finius.graphml.impl.GraphmlFactoryImpl;

/**
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @see GraphmlPackage
 */
public interface GraphmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 */
	GraphmlFactory eINSTANCE = GraphmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph ML</em>'.
	 * @return a new object of class '<em>Graph ML</em>'.
	 */
	GraphML createGraphML();

	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * @return a new object of class '<em>Graph</em>'.
	 */
	Graph createGraph();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * @return a new object of class '<em>Node</em>'.
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Edge</em>'.
	 * @return a new object of class '<em>Edge</em>'.
	 */
	Edge createEdge();

	/**
	 * Returns a new object of class '<em>Data</em>'.
	 * @return a new object of class '<em>Data</em>'.
	 */
	Data createData();

	/**
	 * Returns the package supported by this factory.
	 * @return the package supported by this factory.
	 */
	GraphmlPackage getGraphmlPackage();

}
