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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl#getText <em>Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl#getPosAnnotation <em>Pos Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl#getLemmaAnnotation <em>Lemma Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl#getDocument <em>Document</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl#getSpans <em>Spans</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenImpl extends AnnotatableElementImpl implements Token {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpans() <em>Spans</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpans()
	 * @generated
	 * @ordered
	 */
	protected EList<Span> spans;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TokenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreetaggerPackage.Literals.TOKEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreetaggerPackage.TOKEN__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POSAnnotation getPosAnnotation() {
		POSAnnotation posAnnotation = basicGetPosAnnotation();
		return posAnnotation != null && posAnnotation.eIsProxy() ? (POSAnnotation)eResolveProxy((InternalEObject)posAnnotation) : posAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public POSAnnotation basicGetPosAnnotation() 
	{
		POSAnnotation posAnno= null;
		for (Annotation anno: this.getAnnotations())
		{
			if (anno instanceof POSAnnotation)
				posAnno= (POSAnnotation) anno;
		}
		return(posAnno);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPosAnnotation(POSAnnotation newPosAnnotation) 
	{
		this.getAnnotations().add(newPosAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LemmaAnnotation getLemmaAnnotation() {
		LemmaAnnotation lemmaAnnotation = basicGetLemmaAnnotation();
		return lemmaAnnotation != null && lemmaAnnotation.eIsProxy() ? (LemmaAnnotation)eResolveProxy((InternalEObject)lemmaAnnotation) : lemmaAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public LemmaAnnotation basicGetLemmaAnnotation() 
	{
		LemmaAnnotation lemmaAnno= null;
		for (Annotation anno: this.getAnnotations())
		{
			if (anno instanceof LemmaAnnotation)
				lemmaAnno= (LemmaAnnotation) anno;
		}
		return(lemmaAnno);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setLemmaAnnotation(LemmaAnnotation newLemmaAnnotation) 
	{
		this.getAnnotations().add(newLemmaAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document getDocument() {
		if (eContainerFeatureID() != TreetaggerPackage.TOKEN__DOCUMENT) return null;
		return (Document)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocument(Document newDocument, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDocument, TreetaggerPackage.TOKEN__DOCUMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocument(Document newDocument) {
		if (newDocument != eInternalContainer() || (eContainerFeatureID() != TreetaggerPackage.TOKEN__DOCUMENT && newDocument != null)) {
			if (EcoreUtil.isAncestor(this, newDocument))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDocument != null)
				msgs = ((InternalEObject)newDocument).eInverseAdd(this, TreetaggerPackage.DOCUMENT__TOKENS, Document.class, msgs);
			msgs = basicSetDocument(newDocument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreetaggerPackage.TOKEN__DOCUMENT, newDocument, newDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Span> getSpans() {
		if (spans == null) {
			spans = new EObjectWithInverseResolvingEList.ManyInverse<Span>(Span.class, this, TreetaggerPackage.TOKEN__SPANS, TreetaggerPackage.SPAN__TOKENS);
		}
		return spans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreetaggerPackage.TOKEN__DOCUMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDocument((Document)otherEnd, msgs);
			case TreetaggerPackage.TOKEN__SPANS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpans()).basicAdd(otherEnd, msgs);
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
			case TreetaggerPackage.TOKEN__DOCUMENT:
				return basicSetDocument(null, msgs);
			case TreetaggerPackage.TOKEN__SPANS:
				return ((InternalEList<?>)getSpans()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TreetaggerPackage.TOKEN__DOCUMENT:
				return eInternalContainer().eInverseRemove(this, TreetaggerPackage.DOCUMENT__TOKENS, Document.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TreetaggerPackage.TOKEN__TEXT:
				return getText();
			case TreetaggerPackage.TOKEN__POS_ANNOTATION:
				if (resolve) return getPosAnnotation();
				return basicGetPosAnnotation();
			case TreetaggerPackage.TOKEN__LEMMA_ANNOTATION:
				if (resolve) return getLemmaAnnotation();
				return basicGetLemmaAnnotation();
			case TreetaggerPackage.TOKEN__DOCUMENT:
				return getDocument();
			case TreetaggerPackage.TOKEN__SPANS:
				return getSpans();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TreetaggerPackage.TOKEN__TEXT:
				setText((String)newValue);
				return;
			case TreetaggerPackage.TOKEN__POS_ANNOTATION:
				setPosAnnotation((POSAnnotation)newValue);
				return;
			case TreetaggerPackage.TOKEN__LEMMA_ANNOTATION:
				setLemmaAnnotation((LemmaAnnotation)newValue);
				return;
			case TreetaggerPackage.TOKEN__DOCUMENT:
				setDocument((Document)newValue);
				return;
			case TreetaggerPackage.TOKEN__SPANS:
				getSpans().clear();
				getSpans().addAll((Collection<? extends Span>)newValue);
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
			case TreetaggerPackage.TOKEN__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case TreetaggerPackage.TOKEN__POS_ANNOTATION:
				setPosAnnotation((POSAnnotation)null);
				return;
			case TreetaggerPackage.TOKEN__LEMMA_ANNOTATION:
				setLemmaAnnotation((LemmaAnnotation)null);
				return;
			case TreetaggerPackage.TOKEN__DOCUMENT:
				setDocument((Document)null);
				return;
			case TreetaggerPackage.TOKEN__SPANS:
				getSpans().clear();
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
			case TreetaggerPackage.TOKEN__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case TreetaggerPackage.TOKEN__POS_ANNOTATION:
				return basicGetPosAnnotation() != null;
			case TreetaggerPackage.TOKEN__LEMMA_ANNOTATION:
				return basicGetLemmaAnnotation() != null;
			case TreetaggerPackage.TOKEN__DOCUMENT:
				return getDocument() != null;
			case TreetaggerPackage.TOKEN__SPANS:
				return spans != null && !spans.isEmpty();
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
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

	/**
	 * Checks this and given object for equality. Conditions for equality: Object must be instance of Span, have the same name as this, getSpans().size() must be equal, all Spans must correspond and annotations must be equal. 
	 * @param obj An object
	 * @return true or false
	 */
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token tok = (Token)obj;
		
		//##### compare text #####
		if (((this.getText()!=null)&&(!(this.getText().equals(tok.getText())))) 
			||((tok.getText()!=null)&&(!(tok.getText().equals(this.getText()))))) {
			return false;
		}

      	//##### compare span count #####
		if (this.getSpans().size()!=tok.getSpans().size()) {
			return false;
		}
		
		//##### compare spans #####
		for (int i=0;i<this.getSpans().size();i++) {
			if (!(this.getSpans().get(i).equals(tok.getSpans().get(i)))) {
				return false; 
			}
		}
			
		//okay fine, check super to compare Annotations
		return super.equals(obj);
	}
	
} //TokenImpl
