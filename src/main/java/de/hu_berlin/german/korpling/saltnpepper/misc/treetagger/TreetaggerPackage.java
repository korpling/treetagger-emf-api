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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory
 * @model kind="package"
 * @generated
 */
public interface TreetaggerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "treetagger";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "treetagger";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "treetagger";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TreetaggerPackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotatableElementImpl <em>Annotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotatableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnnotatableElement()
	 * @generated
	 */
	int ANNOTATABLE_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATABLE_ELEMENT__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.DocumentImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__ANNOTATIONS = ANNOTATABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__NAME = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__TOKENS = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__ANNOTATIONS = ANNOTATABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__TEXT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pos Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__POS_ANNOTATION = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lemma Annotation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__LEMMA_ANNOTATION = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Document</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__DOCUMENT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Spans</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN__SPANS = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATABLE_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.POSAnnotationImpl <em>POS Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.POSAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getPOSAnnotation()
	 * @generated
	 */
	int POS_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_ANNOTATION__NAME = ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_ANNOTATION__VALUE = ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_ANNOTATION__ANNOTATABLE_ELEMENT = ANNOTATION__ANNOTATABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>POS Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POS_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.LemmaAnnotationImpl <em>Lemma Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.LemmaAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getLemmaAnnotation()
	 * @generated
	 */
	int LEMMA_ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMMA_ANNOTATION__NAME = ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMMA_ANNOTATION__VALUE = ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMMA_ANNOTATION__ANNOTATABLE_ELEMENT = ANNOTATION__ANNOTATABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Lemma Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEMMA_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnyAnnotationImpl <em>Any Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnyAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnyAnnotation()
	 * @generated
	 */
	int ANY_ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ANNOTATION__NAME = ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ANNOTATION__VALUE = ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ANNOTATION__ANNOTATABLE_ELEMENT = ANNOTATION__ANNOTATABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Any Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.SpanImpl <em>Span</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.SpanImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getSpan()
	 * @generated
	 */
	int SPAN = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN__ANNOTATIONS = ANNOTATABLE_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN__NAME = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN__TOKENS = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Span</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPAN_FEATURE_COUNT = ANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getName()
	 * @see #getDocument()
	 * @generated
	 */
	EAttribute getDocument_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document#getTokens()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Tokens();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getText()
	 * @see #getToken()
	 * @generated
	 */
	EAttribute getToken_Text();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation <em>Pos Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pos Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_PosAnnotation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation <em>Lemma Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lemma Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_LemmaAnnotation();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Document</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getDocument()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_Document();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getSpans <em>Spans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Spans</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getSpans()
	 * @see #getToken()
	 * @generated
	 */
	EReference getToken_Spans();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getName()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getValue()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Value();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getAnnotatableElement <em>Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation#getAnnotatableElement()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_AnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation <em>POS Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>POS Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation
	 * @generated
	 */
	EClass getPOSAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation <em>Lemma Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lemma Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation
	 * @generated
	 */
	EClass getLemmaAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnyAnnotation <em>Any Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnyAnnotation
	 * @generated
	 */
	EClass getAnyAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span <em>Span</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Span</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span
	 * @generated
	 */
	EClass getSpan();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getName()
	 * @see #getSpan()
	 * @generated
	 */
	EAttribute getSpan_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tokens</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span#getTokens()
	 * @see #getSpan()
	 * @generated
	 */
	EReference getSpan_Tokens();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement <em>Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement
	 * @generated
	 */
	EClass getAnnotatableElement();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement#getAnnotations()
	 * @see #getAnnotatableElement()
	 * @generated
	 */
	EReference getAnnotatableElement_Annotations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TreetaggerFactory getTreetaggerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.DocumentImpl <em>Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.DocumentImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT__NAME = eINSTANCE.getDocument_Name();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT__TOKENS = eINSTANCE.getDocument_Tokens();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TokenImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN__TEXT = eINSTANCE.getToken_Text();

		/**
		 * The meta object literal for the '<em><b>Pos Annotation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__POS_ANNOTATION = eINSTANCE.getToken_PosAnnotation();

		/**
		 * The meta object literal for the '<em><b>Lemma Annotation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__LEMMA_ANNOTATION = eINSTANCE.getToken_LemmaAnnotation();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__DOCUMENT = eINSTANCE.getToken_Document();

		/**
		 * The meta object literal for the '<em><b>Spans</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN__SPANS = eINSTANCE.getToken_Spans();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__VALUE = eINSTANCE.getAnnotation_Value();

		/**
		 * The meta object literal for the '<em><b>Annotatable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__ANNOTATABLE_ELEMENT = eINSTANCE.getAnnotation_AnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.POSAnnotationImpl <em>POS Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.POSAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getPOSAnnotation()
		 * @generated
		 */
		EClass POS_ANNOTATION = eINSTANCE.getPOSAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.LemmaAnnotationImpl <em>Lemma Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.LemmaAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getLemmaAnnotation()
		 * @generated
		 */
		EClass LEMMA_ANNOTATION = eINSTANCE.getLemmaAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnyAnnotationImpl <em>Any Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnyAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnyAnnotation()
		 * @generated
		 */
		EClass ANY_ANNOTATION = eINSTANCE.getAnyAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.SpanImpl <em>Span</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.SpanImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getSpan()
		 * @generated
		 */
		EClass SPAN = eINSTANCE.getSpan();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPAN__NAME = eINSTANCE.getSpan_Name();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPAN__TOKENS = eINSTANCE.getSpan_Tokens();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotatableElementImpl <em>Annotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.AnnotatableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl.TreetaggerPackageImpl#getAnnotatableElement()
		 * @generated
		 */
		EClass ANNOTATABLE_ELEMENT = eINSTANCE.getAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATABLE_ELEMENT__ANNOTATIONS = eINSTANCE.getAnnotatableElement_Annotations();

	}

} //TreetaggerPackage
