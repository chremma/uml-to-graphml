package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.finius.graphml.Edge;
import org.finius.graphml.Graph;
import org.finius.graphml.GraphmlPackage;
import org.finius.graphml.Node;

import java.util.Collection;

/**
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link GraphImpl#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphImpl extends ConnectableElementImpl implements Graph {
    /**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     *
     * @see #getNodes()
     */
    protected EList<Node> nodes;

    /**
     * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
     *
     * @see #getEdges()
     */
    protected EList<Edge> edges;

    protected GraphImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return GraphmlPackage.Literals.GRAPH;
    }

    public EList<Node> getNodes() {
        if( nodes == null ) {
            nodes = new EObjectContainmentEList<Node>( Node.class, this, GraphmlPackage.GRAPH__NODES );
        }
        return nodes;
    }

    public EList<Edge> getEdges() {
        if( edges == null ) {
            edges = new EObjectContainmentEList<Edge>( Edge.class, this, GraphmlPackage.GRAPH__EDGES );
        }
        return edges;
    }

    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH__NODES:
                return ((InternalEList<?>) getNodes()).basicRemove( otherEnd, msgs );
            case GraphmlPackage.GRAPH__EDGES:
                return ((InternalEList<?>) getEdges()).basicRemove( otherEnd, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH__NODES:
                return getNodes();
            case GraphmlPackage.GRAPH__EDGES:
                return getEdges();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH__NODES:
                getNodes().clear();
                getNodes().addAll( (Collection<? extends Node>) newValue );
                return;
            case GraphmlPackage.GRAPH__EDGES:
                getEdges().clear();
                getEdges().addAll( (Collection<? extends Edge>) newValue );
                return;
        }
        super.eSet( featureID, newValue );
    }

    @Override
    public void eUnset( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH__NODES:
                getNodes().clear();
                return;
            case GraphmlPackage.GRAPH__EDGES:
                getEdges().clear();
                return;
        }
        super.eUnset( featureID );
    }

    @Override
    public boolean eIsSet( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH__NODES:
                return nodes != null && !nodes.isEmpty();
            case GraphmlPackage.GRAPH__EDGES:
                return edges != null && !edges.isEmpty();
        }
        return super.eIsSet( featureID );
    }

}
