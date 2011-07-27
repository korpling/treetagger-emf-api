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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Span</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpanTest extends AnnotatableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpanTest.class);
	}

	/**
	 * Constructs a new Span test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpanTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Span test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Span getFixture() {
		return (Span)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TreetaggerFactory.eINSTANCE.createSpan());
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
	 * Tests equals method for Span.
	 */
	public void testEquals() {
		Span span1 = null;
		Span span2 = null;
		assertEquals(span1,span2);
		
		span1 = TreetaggerFactory.eINSTANCE.createSpan();
		assertNotSame(span1,span2);
		span2 = TreetaggerFactory.eINSTANCE.createSpan();
		assertEquals(span1,span2);
		
		assertNull(span1.getName());
		assertNull(span2.getName());
		span1.setName("spanName");
		assertNotSame(span1,span2);
		span2.setName("spanName");
		assertEquals(span1,span2);
	}
	
} //SpanTest
