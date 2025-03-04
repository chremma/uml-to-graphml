package org.finius.graphml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.finius.graphml.Data;
import org.finius.graphml.GraphmlPackage;

/**
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DataImpl#getValue <em>Value</em>}</li>
 *   <li>{@link DataImpl#getKey <em>Key</em>}</li>
 * </ul>
 */
public class DataImpl extends MinimalEObjectImpl.Container implements Data {
    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     *
     * @see #getValue()
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     *
     * @see #getValue()
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     *
     * @see #getKey()
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     *
     * @see #getKey()
     */
    protected String key = KEY_EDEFAULT;

    protected DataImpl() {
        super();
    }

    @Override
    protected EClass eStaticClass() {
        return GraphmlPackage.Literals.DATA;
    }

    public String getValue() {
        return value;
    }

    public void setValue( String newValue ) {
        String oldValue = value;
        value = newValue;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.DATA__VALUE, oldValue, value ) );
    }

    public String getKey() {
        return key;
    }

    public void setKey( String newKey ) {
        String oldKey = key;
        key = newKey;
        if( eNotificationRequired() )
            eNotify( new ENotificationImpl( this, Notification.SET, GraphmlPackage.DATA__KEY, oldKey, key ) );
    }

    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch( featureID ) {
            case GraphmlPackage.DATA__VALUE:
                return getValue();
            case GraphmlPackage.DATA__KEY:
                return getKey();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    @Override
    public void eSet( int featureID, Object newValue ) {
        switch( featureID ) {
            case GraphmlPackage.DATA__VALUE:
                setValue( (String) newValue );
                return;
            case GraphmlPackage.DATA__KEY:
                setKey( (String) newValue );
                return;
        }
        super.eSet( featureID, newValue );
    }

    @Override
    public void eUnset( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.DATA__VALUE:
                setValue( VALUE_EDEFAULT );
                return;
            case GraphmlPackage.DATA__KEY:
                setKey( KEY_EDEFAULT );
                return;
        }
        super.eUnset( featureID );
    }

    @Override
    public boolean eIsSet( int featureID ) {
        switch( featureID ) {
            case GraphmlPackage.DATA__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals( value );
            case GraphmlPackage.DATA__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals( key );
        }
        return super.eIsSet( featureID );
    }

    @Override
    public String toString() {
        if( eIsProxy() )
            return super.toString();

        StringBuilder result = new StringBuilder( super.toString() );
        result.append( " (value: " );
        result.append( value );
        result.append( ", key: " );
        result.append( key );
        result.append( ')' );
        return result.toString();
    }

}
