/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DocumentTest extends AnnotatableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DocumentTest.class);
	}

	/**
	 * Constructs a new Document test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Document test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Document getFixture() {
		return (Document)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TreetaggerFactory.eINSTANCE.createDocument());
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
	 * Tests equals method for Documents. The name field is not subject to equality.
	 */
	public void testEquals() {
		Document document1 = TreetaggerFactory.eINSTANCE.createDocument();
		Document document2 = TreetaggerFactory.eINSTANCE.createDocument();
		assertEquals(document1,document2);		
		
		Document[] docArray = {document1,document2};
		
		for (int docIndex=0;docIndex<2;docIndex++) {
			//add some tokens to document and some annotations to tokens
			for (int i=0; i<10; i++) {
				Token token = TreetaggerFactory.eINSTANCE.createToken();
				token.setText(String.format("token#%d.Text",i));
				token.setDocument(docArray[docIndex]);
				for (int j=0; j<2; j++) {
					Annotation annotation = TreetaggerFactory.eINSTANCE.createAnnotation();
					annotation.setValue(String.format("token#%d.Annotation#%d",i,j));
					annotation.setAnnotatableElement(token);
				}
			}
		}
		
		assertEquals(document1,document2);
	}
	
} //DocumentTest
