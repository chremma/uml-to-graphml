/**
 */
package org.finius.graphml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * A representation of the model object '<em><b>Element</b></em>'.
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Element#getDataAttributes <em>Data Attributes</em>}</li>
 *   <li>{@link Element#getId <em>Id</em>}</li>
 *   <li>{@link Element#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see GraphmlPackage#getElement()
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link Data}.
	 * @return the value of the '<em>Data Attributes</em>' containment reference list.
	 * @see GraphmlPackage#getElement_DataAttributes()
	 */
	EList<Data> getDataAttributes();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see GraphmlPackage#getElement_Id()
	 */
	String getId();

	/**
	 * Sets the value of the '{@link Element#getId <em>Id</em>}' attribute.
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see GraphmlPackage#getElement_Name()
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Element#getName <em>Name</em>}' attribute.
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 */
	void setName(String value);

}
