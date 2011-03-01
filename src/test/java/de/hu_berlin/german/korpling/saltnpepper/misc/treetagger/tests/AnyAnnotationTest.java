/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tests;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnyAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Any Annotation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnyAnnotationTest extends AnnotationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnyAnnotationTest.class);
	}

	/**
	 * Constructs a new Any Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Any Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AnyAnnotation getFixture() {
		return (AnyAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TreetaggerFactory.eINSTANCE.createAnyAnnotation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	//TODO: remove when there are real tests
	public void testDummy() {
	}

} //AnyAnnotationTest
