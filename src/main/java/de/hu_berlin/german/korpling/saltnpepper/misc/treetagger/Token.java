/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getText <em>Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getPosAnnotation <em>Pos Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getLemmaAnnotation <em>Lemma Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getDocument <em>Document</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Annotation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Annotation#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken_Annotations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Annotation#getToken
	 * @model opposite="token" containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

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
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getText <em>Text</em>}' attribute.
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
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken_PosAnnotation()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	POSAnnotation getPosAnnotation();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getPosAnnotation <em>Pos Annotation</em>}' reference.
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
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken_LemmaAnnotation()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	LemmaAnnotation getLemmaAnnotation();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getLemmaAnnotation <em>Lemma Annotation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lemma Annotation</em>' reference.
	 * @see #getLemmaAnnotation()
	 * @generated
	 */
	void setLemmaAnnotation(LemmaAnnotation value);

	/**
	 * Returns the value of the '<em><b>Document</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Document#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Document</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document</em>' container reference.
	 * @see #setDocument(Document)
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.TreetaggerPackage#getToken_Document()
	 * @see de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Document#getTokens
	 * @model opposite="tokens" transient="false"
	 * @generated
	 */
	Document getDocument();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.pepperModules.treetagger.Token#getDocument <em>Document</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Document</em>' container reference.
	 * @see #getDocument()
	 * @generated
	 */
	void setDocument(Document value);

} // Token
