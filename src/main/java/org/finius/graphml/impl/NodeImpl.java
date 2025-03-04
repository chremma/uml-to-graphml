package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.finius.graphml.Graph;
import org.finius.graphml.GraphmlPackage;
import org.finius.graphml.Node;

/**
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link NodeImpl#getGraph <em>Graph</em>}</li>
 * </ul>
 */
public class NodeImpl extends ConnectableElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
	 * @see #getGraph()
	 */
	protected Graph graph;

	protected NodeImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return GraphmlPackage.Literals.NODE;
	}

	public Graph getGraph() {
		return graph;
	}

	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphmlPackage.NODE__GRAPH,
					oldGraph, newGraph);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setGraph(Graph newGraph) {
		if (newGraph != graph) {
			NotificationChain msgs = null;
			if (graph != null)
				msgs = ((InternalEObject) graph).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - GraphmlPackage.NODE__GRAPH, null, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject) newGraph).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphmlPackage.NODE__GRAPH, null, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphmlPackage.NODE__GRAPH, newGraph, newGraph));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GraphmlPackage.NODE__GRAPH:
			return basicSetGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GraphmlPackage.NODE__GRAPH:
			return getGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GraphmlPackage.NODE__GRAPH:
			setGraph((Graph) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case GraphmlPackage.NODE__GRAPH:
			setGraph((Graph) null);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case GraphmlPackage.NODE__GRAPH:
			return graph != null;
		}
		return super.eIsSet(featureID);
	}

}
