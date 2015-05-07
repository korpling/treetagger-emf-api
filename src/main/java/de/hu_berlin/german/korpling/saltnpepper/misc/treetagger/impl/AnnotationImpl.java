/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl#getAnnotatableElement <em>Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends EObjectImpl implements Annotation {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotatableElement() <em>Annotatable Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatableElement()
	 * @generated
	 * @ordered
	 */
	protected AnnotatableElement annotatableElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreetaggerPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreetaggerPackage.ANNOTATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreetaggerPackage.ANNOTATION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatableElement getAnnotatableElement() {
		if (annotatableElement != null && annotatableElement.eIsProxy()) {
			InternalEObject oldAnnotatableElement = (InternalEObject)annotatableElement;
			annotatableElement = (AnnotatableElement)eResolveProxy(oldAnnotatableElement);
			if (annotatableElement != oldAnnotatableElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT, oldAnnotatableElement, annotatableElement));
			}
		}
		return annotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatableElement basicGetAnnotatableElement() {
		return annotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotatableElement(AnnotatableElement newAnnotatableElement, NotificationChain msgs) {
		AnnotatableElement oldAnnotatableElement = annotatableElement;
		annotatableElement = newAnnotatableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT, oldAnnotatableElement, newAnnotatableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatableElement(AnnotatableElement newAnnotatableElement) {
		if (newAnnotatableElement != annotatableElement) {
			NotificationChain msgs = null;
			if (annotatableElement != null)
				msgs = ((InternalEObject)annotatableElement).eInverseRemove(this, TreetaggerPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
			if (newAnnotatableElement != null)
				msgs = ((InternalEObject)newAnnotatableElement).eInverseAdd(this, TreetaggerPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
			msgs = basicSetAnnotatableElement(newAnnotatableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT, newAnnotatableElement, newAnnotatableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				if (annotatableElement != null)
					msgs = ((InternalEObject)annotatableElement).eInverseRemove(this, TreetaggerPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS, AnnotatableElement.class, msgs);
				return basicSetAnnotatableElement((AnnotatableElement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				return basicSetAnnotatableElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__NAME:
				return getName();
			case TreetaggerPackage.ANNOTATION__VALUE:
				return getValue();
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				if (resolve) return getAnnotatableElement();
				return basicGetAnnotatableElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__NAME:
				setName((String)newValue);
				return;
			case TreetaggerPackage.ANNOTATION__VALUE:
				setValue((String)newValue);
				return;
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				setAnnotatableElement((AnnotatableElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TreetaggerPackage.ANNOTATION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				setAnnotatableElement((AnnotatableElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TreetaggerPackage.ANNOTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TreetaggerPackage.ANNOTATION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case TreetaggerPackage.ANNOTATION__ANNOTATABLE_ELEMENT:
				return annotatableElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * TODO: describe
	 */
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (!(obj instanceof Annotation)) {
			return false;
		}
		Annotation anno = (Annotation)obj;
		
		//##### compare name #####
		if (((this.getName()!=null)&&(!(this.getName().equals(anno.getName())))) 
			||((anno.getName()!=null)&&(!(anno.getName().equals(this.getName()))))) {
			return false;
		}
		
		//##### compare value #####
		if (((this.getValue()!=null)&&(!(this.getValue().equals(anno.getValue())))) 
			||((anno.getValue()!=null)&&(!(anno.getValue().equals(this.getValue()))))) {
			return false;
		}

//		this would cause a circle
//		//##### compare annotatable element #####
//		if (((this.getAnnotatableElement()!=null)&&(!(this.getAnnotatableElement().equals(anno.getAnnotatableElement())))) 
//			||((anno.getAnnotatableElement()!=null)&&(!(anno.getAnnotatableElement().equals(this.getAnnotatableElement()))))) {
//			return false;
//		}
		
		//okay fine
		return true;
	}

} //AnnotationImpl
