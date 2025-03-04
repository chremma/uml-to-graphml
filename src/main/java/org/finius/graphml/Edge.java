/**
 */
package org.finius.graphml;

/**
 * A representation of the model object '<em><b>Edge</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Edge#getSource <em>Source</em>}</li>
 *   <li>{@link Edge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getEdge()
 */
public interface Edge extends Element {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ConnectableElement)
	 * @see GraphmlPackage#getEdge_Source()
	 */
	ConnectableElement getSource();

	/**
	 * Sets the value of the '{@link Edge#getSource <em>Source</em>}' reference.
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 */
	void setSource(ConnectableElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ConnectableElement)
	 * @see GraphmlPackage#getEdge_Target()
	 */
	ConnectableElement getTarget();

	/**
	 * Sets the value of the '{@link Edge#getTarget <em>Target</em>}' reference.
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 */
	void setTarget(ConnectableElement value);

} // Edge
