package org.finius.graphml.impl;

import org.eclipse.emf.ecore.EClass;
import org.finius.graphml.ConnectableElement;
import org.finius.graphml.GraphmlPackage;

/**
 * An implementation of the model object '<em><b>Connectable Element</b></em>'.
 */
public abstract class ConnectableElementImpl extends ElementImpl implements ConnectableElement {
	protected ConnectableElementImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return GraphmlPackage.Literals.CONNECTABLE_ELEMENT;
	}

}
