package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.TabResource;
import junit.framework.TestCase;

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

	public final void testSaveMapOfQQ() {
		this.testLoadMapOfQQ();
	}

	public final void testLoadMapOfQQ() {
		TabResource tab = new TabResource();
		tab.setURI(URI.createFileURI("c:/mvb-idiome/idioms-0001.txt"));
		try {
			tab.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tab.setURI(URI.createFileURI("c:/idioms-0001.txt"));
		try {
			tab.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
