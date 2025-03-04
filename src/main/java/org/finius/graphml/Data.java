/**
 */
package org.finius.graphml;

import org.eclipse.emf.ecore.EObject;

/**
 * A representation of the model object '<em><b>Data</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Data#getValue <em>Value</em>}</li>
 *   <li>{@link Data#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getData()
 */
public interface Data extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see GraphmlPackage#getData_Value()
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link Data#getValue <em>Value</em>}' attribute.
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see GraphmlPackage#getData_Key()
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link Data#getKey <em>Key</em>}' attribute.
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 */
	void setKey(String value);

}
