package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.finius.graphml.Graph;
import org.finius.graphml.GraphML;
import org.finius.graphml.GraphmlPackage;

import java.util.Collection;

/**
 * An implementation of the model object '<em><b>Graph ML</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link GraphMLImpl#getGraphs <em>Graphs</em>}</li>
 * </ul>
 */
public class GraphMLImpl extends MinimalEObjectImpl.Container implements GraphML {
    /**
     * The cached value of the '{@link #getGraphs() <em>Graphs</em>}' containment reference list.
     *
     * @see #getGraphs()
     */
    protected EList<Graph> graphs;

    protected GraphMLImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return GraphmlPackage.Literals.GRAPH_ML;
    }

    public EList<Graph> getGraphs() {
        if( graphs == null ) {
            graphs = new EObjectContainmentEList<>( Graph.class, this, GraphmlPackage.GRAPH_ML__GRAPHS );
        }
        return graphs;
    }

    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH_ML__GRAPHS:
                return ((InternalEList<?>) getGraphs()).basicRemove( otherEnd, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH_ML__GRAPHS:
                return getGraphs();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH_ML__GRAPHS:
                getGraphs().clear();
                getGraphs().addAll( (Collection<? extends Graph>) newValue );
                return;
        }
        super.eSet( featureID, newValue );
    }

    @Override
    public void eUnset( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH_ML__GRAPHS:
                getGraphs().clear();
                return;
        }
        super.eUnset( featureID );
    }

    @Override
    public boolean eIsSet( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.GRAPH_ML__GRAPHS:
                return graphs != null && !graphs.isEmpty();
        }
        return super.eIsSet( featureID );
    }

}
