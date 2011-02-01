/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.impl;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TreetaggerFactoryImpl extends EFactoryImpl implements TreetaggerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreetaggerFactory init() {
		try {
			TreetaggerFactory theTreetaggerFactory = (TreetaggerFactory)EPackage.Registry.INSTANCE.getEFactory("treetagger"); 
			if (theTreetaggerFactory != null) {
				return theTreetaggerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TreetaggerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreetaggerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TreetaggerPackage.DOCUMENT: return createDocument();
			case TreetaggerPackage.TOKEN: return createToken();
			case TreetaggerPackage.ANNOTATION: return createAnnotation();
			case TreetaggerPackage.POS_ANNOTATION: return createPOSAnnotation();
			case TreetaggerPackage.LEMMA_ANNOTATION: return createLemmaAnnotation();
			case TreetaggerPackage.ANY_ANNOTATION: return createAnyAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Document createDocument() {
		DocumentImpl document = new DocumentImpl();
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token createToken() {
		TokenImpl token = new TokenImpl();
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public POSAnnotation createPOSAnnotation() {
		POSAnnotationImpl posAnnotation = new POSAnnotationImpl();
		return posAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LemmaAnnotation createLemmaAnnotation() {
		LemmaAnnotationImpl lemmaAnnotation = new LemmaAnnotationImpl();
		return lemmaAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyAnnotation createAnyAnnotation() {
		AnyAnnotationImpl anyAnnotation = new AnyAnnotationImpl();
		return anyAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreetaggerPackage getTreetaggerPackage() {
		return (TreetaggerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TreetaggerPackage getPackage() {
		return TreetaggerPackage.eINSTANCE;
	}

} //TreetaggerFactoryImpl
