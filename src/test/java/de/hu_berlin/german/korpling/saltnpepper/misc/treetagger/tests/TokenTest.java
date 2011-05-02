/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation() <em>Pos Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation() <em>Lemma Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TokenTest extends AnnotatableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TokenTest.class);
	}

	/**
	 * Constructs a new Token test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TokenTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Token test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Token getFixture() {
		return (Token)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TreetaggerFactory.eINSTANCE.createToken());
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

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation() <em>Pos Annotation</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getPosAnnotation()
	 * 
	 */
	public void testGetPosAnnotation() 
	{
		assertNull(this.getFixture().getPosAnnotation());
		POSAnnotation anno= TreetaggerFactory.eINSTANCE.createPOSAnnotation();
		anno.setName("pos");
		anno.setValue("VVFIN");
		this.getFixture().setPosAnnotation(anno);
		assertEquals(anno, this.getFixture().getPosAnnotation()); 
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#setPosAnnotation(de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation) <em>Pos Annotation</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#setPosAnnotation(de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation)
	 */
	public void testSetPosAnnotation() {
		this.testGetPosAnnotation();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation() <em>Lemma Annotation</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#getLemmaAnnotation()
	 */
	public void testGetLemmaAnnotation() {
		assertNull(this.getFixture().getLemmaAnnotation());
		LemmaAnnotation anno= TreetaggerFactory.eINSTANCE.createLemmaAnnotation();
		anno.setName("lemma");
		anno.setValue("someLemma");
		this.getFixture().setLemmaAnnotation(anno);
		assertEquals(anno, this.getFixture().getLemmaAnnotation()); 
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#setLemmaAnnotation(de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation) <em>Lemma Annotation</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token#setLemmaAnnotation(de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation)
	 */
	public void testSetLemmaAnnotation() {
		this.testGetLemmaAnnotation();
	}

	/**
	 * Tests equals method for Tokens.
	 */
	public void testEquals() {
		Token token1 = null;
		Token token2 = null;
		assertEquals(token1,token2);
		
		token1 = TreetaggerFactory.eINSTANCE.createToken();
		assertNotSame(token1,token2);
		token2 = TreetaggerFactory.eINSTANCE.createToken();
		assertEquals(token1,token2);
		
		assertNull(token1.getText());
		assertNull(token2.getText());
		token1.setText("tokenText");
		assertNotSame(token1,token2);
		token2.setText("tokenText");
		assertEquals(token1,token2);
	}
	
} //TokenTest
