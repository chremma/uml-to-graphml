package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.finius.graphml.ConnectableElement;
import org.finius.graphml.Edge;
import org.finius.graphml.GraphmlPackage;

/**
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link EdgeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 */
public class EdgeImpl extends ConnectableElementImpl implements Edge {
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     *
     * @see #getSource()
     */
    protected ConnectableElement source;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     *
     * @see #getTarget()
     */
    protected ConnectableElement target;

    protected EdgeImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return GraphmlPackage.Literals.EDGE;
    }

    public ConnectableElement getSource() {
        if( source != null && source.eIsProxy() ) {
            InternalEObject oldSource = (InternalEObject) source;
            source = (ConnectableElement) eResolveProxy( oldSource );
            if( source != oldSource ) {
                if( eNotificationRequired() )
                    eNotify( new ENotificationImpl( this, Notification.RESOLVE, GraphmlPackage.EDGE__SOURCE, oldSource,
                            source ) );
            }
        }
        return source;
    }

    public ConnectableElement basicGetSource() {
        return source;
    }

    public void setSource( ConnectableElement newSource ) {
        ConnectableElement oldSource = source;
        source = newSource;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.EDGE__SOURCE, oldSource, source ) );
    }

    public ConnectableElement getTarget() {
        if( target != null && target.eIsProxy() ) {
            InternalEObject oldTarget = (InternalEObject) target;
            target = (ConnectableElement) eResolveProxy( oldTarget );
            if( target != oldTarget ) {
                if( eNotificationRequired() )
                    eNotify( new ENotificationImpl( this, Notification.RESOLVE, GraphmlPackage.EDGE__TARGET, oldTarget,
                            target ) );
            }
        }
        return target;
    }

    public ConnectableElement basicGetTarget() {
        return target;
    }

    public void setTarget( ConnectableElement newTarget ) {
        ConnectableElement oldTarget = target;
        target = newTarget;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.EDGE__TARGET, oldTarget, target ) );
    }

    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch( featureID ) {
            case GraphmlPackage.EDGE__SOURCE:
                if( resolve )
                    return getSource();
                return basicGetSource();
            case GraphmlPackage.EDGE__TARGET:
                if( resolve )
                    return getTarget();
                return basicGetTarget();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    @Override
    public void eSet( int featureID, Object newValue ) {
        switch( featureID ) {
            case GraphmlPackage.EDGE__SOURCE:
                setSource( (ConnectableElement) newValue );
                return;
            case GraphmlPackage.EDGE__TARGET:
                setTarget( (ConnectableElement) newValue );
                return;
        }
        super.eSet( featureID, newValue );
    }

    @Override
    public void eUnset( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.EDGE__SOURCE:
                setSource( (ConnectableElement) null );
                return;
            case GraphmlPackage.EDGE__TARGET:
                setTarget( (ConnectableElement) null );
                return;
        }
        super.eUnset( featureID );
    }

    @Override
    public boolean eIsSet( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.EDGE__SOURCE:
                return source != null;
            case GraphmlPackage.EDGE__TARGET:
                return target != null;
        }
        return super.eIsSet( featureID );
    }

}
