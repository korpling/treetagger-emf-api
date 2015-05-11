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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;

public class TreetaggerMain {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("************************************ TreetaggerMain ************************************");
		System.out.println("TreetaggerMain converts files into different treetagger-formats. Therefore it loads data ");
		System.out.println("from input format into the treetagger model and exports them into output format.");
		System.out.println("supported formats:");
		System.out.println("\t * a tab-separted file with ending .tab");
		System.out.println("\t * the xmi file created by ecore with ending .treetagger");
		System.out.println("The kind of file will be discovered automatically.");
		System.out.println();
		System.out.println("Synopsis: TreetaggerMain -i INPUT_FILE -o OUTPUT_FILE");
		System.out.println();

		String inputFile = null;
		String outputFile = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-i"))
				inputFile = args[i + 1];

			if (args[i].equalsIgnoreCase("-o"))
				outputFile = args[i + 1];
		}

		System.out.println("reading from: " + inputFile + " writing to: " + outputFile);

		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML resource factory
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("treetagger", new XMIResourceFactoryImpl());
		TabResourceFactory tabResourceFactory = new TabResourceFactory();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tab", tabResourceFactory);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tt", tabResourceFactory);

		// load resource
		Resource resource = resourceSet.createResource(URI.createFileURI(inputFile));

		if (resource == null)
			throw new NullPointerException("The resource is null.");
		resource.load(null);

		Document document = (Document) resource.getContents().get(0);

		Resource resourceOut = resourceSet.createResource(URI.createFileURI(outputFile));
		resourceOut.getContents().add(document);
		resourceOut.save(null);
		System.out.println("****************************************************************************************");
	}
}
