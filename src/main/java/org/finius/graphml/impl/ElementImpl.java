package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.finius.graphml.Data;
import org.finius.graphml.Element;
import org.finius.graphml.GraphmlPackage;

import java.util.Collection;

/**
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ElementImpl#getDataAttributes <em>Data Attributes</em>}</li>
 *   <li>{@link ElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link ElementImpl#getName <em>Name</em>}</li>
 * </ul>
 */
public abstract class ElementImpl extends MinimalEObjectImpl.Container implements Element {
    /**
     * The cached value of the '{@link #getDataAttributes() <em>Data Attributes</em>}' containment reference list.
     *
     * @see #getDataAttributes()
     */
    protected EList<Data> dataAttributes;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     *
     * @see #getId()
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     *
     * @see #getId()
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     *
     * @see #getName()
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * @see #getName()
     */
    protected String name = NAME_EDEFAULT;

    protected ElementImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return GraphmlPackage.Literals.ELEMENT;
    }

    public EList<Data> getDataAttributes() {
        if( dataAttributes == null ) {
            dataAttributes = new EObjectContainmentEList<>( Data.class, this,
                    GraphmlPackage.ELEMENT__DATA_ATTRIBUTES );
        }
        return dataAttributes;
    }

    public String getId() {
        return id;
    }

    public void setId( String newId ) {
        String oldId = id;
        id = newId;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.ELEMENT__ID, oldId, id ) );
    }

    public String getName() {
        return name;
    }

    public void setName( String newName ) {
        String oldName = name;
        name = newName;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.ELEMENT__NAME, oldName, name ) );
    }

    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch( featureID ) {
            case GraphmlPackage.ELEMENT__DATA_ATTRIBUTES:
                return ((InternalEList<?>) getDataAttributes()).basicRemove( otherEnd, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch( featureID ) {
            case GraphmlPackage.ELEMENT__DATA_ATTRIBUTES:
                return getDataAttributes();
            case GraphmlPackage.ELEMENT__ID:
                return getId();
            case GraphmlPackage.ELEMENT__NAME:
                return getName();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch( featureID ) {
            case GraphmlPackage.ELEMENT__DATA_ATTRIBUTES:
                getDataAttributes().clear();
                getDataAttributes().addAll( (Collection<? extends Data>) newValue );
                return;
            case GraphmlPackage.ELEMENT__ID:
                setId( (String) newValue );
                return;
            case GraphmlPackage.ELEMENT__NAME:
                setName( (String) newValue );
                return;
        }
        super.eSet( featureID, newValue );
    }

    @Override
    public void eUnset( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.ELEMENT__DATA_ATTRIBUTES:
                getDataAttributes().clear();
                return;
            case GraphmlPackage.ELEMENT__ID:
                setId( ID_EDEFAULT );
                return;
            case GraphmlPackage.ELEMENT__NAME:
                setName( NAME_EDEFAULT );
                return;
        }
        super.eUnset( featureID );
    }

    @Override
    public boolean eIsSet( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.ELEMENT__DATA_ATTRIBUTES:
                return dataAttributes != null && !dataAttributes.isEmpty();
            case GraphmlPackage.ELEMENT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals( id );
            case GraphmlPackage.ELEMENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals( name );
        }
        return super.eIsSet( featureID );
    }

    @Override
    public String toString() {
        if( eIsProxy() )
            return super.toString();

        StringBuilder result = new StringBuilder( super.toString() );
        result.append( " (id: " );
        result.append( id );
        result.append( ", name: " );
        result.append( name );
        result.append( ')' );
        return result.toString();
    }

}
