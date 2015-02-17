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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.tests;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.TabResource;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.TabResourceFactory;

/**
 * Testcase for TabResource
 * @author hildebax
 *
 */
public class TabResourceTest extends TestCase {

	public TabResourceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * calls {@link #testLoadMapOfQQ}
	 */
	public final void testSaveMapOfQQ() {
		this.testLoadMapOfQQ();
	}

	/**
	 * This method loads a test document from file, saves it back to another file, loads it and checks them for equality. 
	 */
	public final void testLoadMapOfQQ() {
		TabResourceFactory factory = new TabResourceFactory();
		
		TabResource tab1 = (TabResource)factory.createResource(URI.createFileURI("./src/test/resources/testTabResource.tab"));
		
		try {
			tab1.load(null);
		} catch (IOException e) {
			fail("could not load file 'testTabResource.tab'");
		}
		
		try {
			tab1.setURI(URI.createFileURI("./src/test/resources/testTabResource_output.tab"));
			
			tab1.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		TabResource tab2 = (TabResource)factory.createResource(URI.createFileURI("./src/test/resources/testTabResource_output.tab"));
		
		try {
			tab2.load(null);
		} catch (IOException e) {
			fail("could not load file 'testTabResource_output.tab'");
		}

		
		if (tab1.getContents().size()!=tab2.getContents().size()) {
			fail("size of contents in 'testTabResource.tab' and 'testTabResource_output.tab' differ");
		}
		
		for (int contentIndex=0; contentIndex<tab1.getContents().size(); contentIndex++) {
			Document doc1 = (Document)tab1.getContents().get(contentIndex);
			Document doc2 = (Document)tab2.getContents().get(contentIndex);
			assertEquals(doc1,doc2);
		}
	}
	
}
