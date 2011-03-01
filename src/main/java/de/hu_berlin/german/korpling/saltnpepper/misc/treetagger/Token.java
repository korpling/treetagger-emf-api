/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getText <em>Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation <em>Pos Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation <em>Lemma Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getDocument <em>Document</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getSpans <em>Spans</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends AnnotatableElement {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Pos Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Annotation</em>' reference.
	 * @see #setPosAnnotation(POSAnnotation)
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken_PosAnnotation()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	POSAnnotation getPosAnnotation();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation <em>Pos Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos Annotation</em>' reference.
	 * @see #getPosAnnotation()
	 * @generated
	 */
	void setPosAnnotation(POSAnnotation value);

	/**
	 * Returns the value of the '<em><b>Lemma Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lemma Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lemma Annotation</em>' reference.
	 * @see #setLemmaAnnotation(LemmaAnnotation)
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken_LemmaAnnotation()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	LemmaAnnotation getLemmaAnnotation();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation <em>Lemma Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lemma Annotation</em>' reference.
	 * @see #getLemmaAnnotation()
	 * @generated
	 */
	void setLemmaAnnotation(LemmaAnnotation value);

	/**
	 * Returns the value of the '<em><b>Document</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document</em>' container reference.
	 * @see #setDocument(Document)
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken_Document()
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getTokens
	 * @model opposite="tokens" transient="false"
	 * @generated
	 */
	Document getDocument();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getDocument <em>Document</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document</em>' container reference.
	 * @see #getDocument()
	 * @generated
	 */
	void setDocument(Document value);

	/**
	 * Returns the value of the '<em><b>Spans</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spans</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spans</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerPackage#getToken_Spans()
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getTokens
	 * @model opposite="tokens"
	 * @generated
	 */
	EList<Span> getSpans();

} // Token
