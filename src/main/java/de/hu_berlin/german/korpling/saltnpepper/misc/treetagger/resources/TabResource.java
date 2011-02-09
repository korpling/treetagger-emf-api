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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

public class TabResource extends ResourceImpl
{
	/**
	 * Seperator which spereates coloumns
	 */
	private String seperator= "\t";
	
	/**
	 * Encoding in which file has to be written
	 */
	private String encoding= "UTF-8";
	
	/**
	 * Stores a a treetagger-model into tab-seperated file.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		PrintStream fileWriter= new PrintStream(new FileOutputStream(this.getURI().toFileString()), true, this.encoding);
		
		
		try 
		{
			//write contents if some exists
			if (	(this.getContents()!= null) &&
					(this.getContents().size()!= 0))
			{
				//write all contents into file
				for (EObject content: this.getContents())
				{	
					if (!(content instanceof Document))
						throw new RuntimeException("Cannot store content. The given content is not of type treetagger::document: "+ content);
					for (Token token: ((Document)content).getTokens())
					{
						fileWriter.print(token.getText());
//						System.out.println("#"+token.getText()+"#");
						if (	(token.getAnnotations()!= null) &&
								(token.getAnnotations().size() > 0))
						{
							for (Annotation anno: token.getAnnotations())
							{
//								System.out.println("#"+this.seperator +anno.getValue()+"#");
								fileWriter.print(this.seperator +anno.getValue());
							}
						}	
//						System.out.println();
						fileWriter.println();
					}		
				}
			}
		} catch (RuntimeException e) {
			throw e;
		}
		finally
		{
			fileWriter.flush();
			fileWriter.close();
			fileWriter= null;
		}
	}
	
	
	/**
	 * Loads a resource into treetagger-model from tab-seperated file.
	 */
	public void load(java.util.Map<?,?> options) throws IOException
	{
		// extract names of columns
		EList<String> colNames= extractColNames(options);
		
		if (this.getURI()== null)
			throw new NullPointerException("Cannot load any resource, because no uri is given.");
		
		//read file
		this.readFile(this.getURI());
		
		//create document object and set it to contents
		Document document= TreetaggerFactory.eINSTANCE.createDocument();
		String documentName= this.getURI().lastSegment();
		String[] parts= documentName.split("[.]");
		documentName= parts[0];
		document.setName(documentName);
		this.getContents().add(document);
		
		EList<String> tuple= null;
		tuple= this.getTuple(); 
		while (tuple!= null)
		{
			if (tuple.size()> 0)
			{
				//add text to token
				Token token= TreetaggerFactory.eINSTANCE.createToken();
				token.setText(tuple.get(0));
				document.getTokens().add(token);
				//add annotations to token, if exists
				if (tuple.size() >1)
				{	
					for (int i=1; i< tuple.size(); i++)
					{
						//if current annotation has key POS
						if (colNames.get(i-1).equalsIgnoreCase("POS"))
						{
							POSAnnotation posAnno= TreetaggerFactory.eINSTANCE.createPOSAnnotation();
							posAnno.setValue(tuple.get(i));
							token.getAnnotations().add(posAnno);
						}	
						//if current annotation has key LEMMA
						else if (colNames.get(i-1).equalsIgnoreCase("LEMMA"))
						{
							LemmaAnnotation lemmaAnno= TreetaggerFactory.eINSTANCE.createLemmaAnnotation();
							lemmaAnno.setValue(tuple.get(i));
							token.getAnnotations().add(lemmaAnno);
						}
						//if current annotation is any other annotation
						else
						{
							Annotation anno= TreetaggerFactory.eINSTANCE.createAnnotation();
							anno.setName(colNames.get(i-1));
							anno.setValue(tuple.get(i));
							token.getAnnotations().add(anno);
						}	
					}	
				}
			}
			tuple= this.getTuple();
		}	
	}
	
	/**
	 * Extracts and returns the names of the columns in the tab file. 
	 */
	private EList<String> extractColNames(java.util.Map<?,?> options)
	{
		EList<String> colNames= new BasicEList<String>();
		
		//map contains entries
		if (	(options!= null) && 
				(options.containsKey("colNames")))
		{	
			String colNamesStr= (String)options.get("colNames");
			String[] colNamesArr= colNamesStr.split(",");
			for (String colName: colNamesArr)
			{
				colName= colName.trim();
				colNames.add(colName);
			}	
		}
		//map doesn�t contain entries, use default values
		else
		{
			colNames.add("POS");
			colNames.add("LEMMA");
		}
		return(colNames);
	}
	
	/**
	 * Stores tuples for reading. 
	 */
	private EList<EList<String>> tuples= null;
	
	public void readFile(URI uri) throws IOException
	{
//		BufferedReader inReader = new BufferedReader(new FileReader(this.getURI().toFileString()));
		BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.getURI().toFileString()), "UTF8"));
		EList<String> atts= null;
		String input = "";
		tuples= new BasicEList<EList<String>>();
		while((input = inReader.readLine()) != null) 
		{
			atts= new BasicEList<String>();
			String[] attStr= input.split(this.seperator);
			for (String att: attStr)
				atts.add(att);
			tuples.add(atts);
		}
		inReader.close();
	}

	private int tuplePtr= 0;
	public EList<String> getTuple() throws IOException
	{
		EList<String> tuple= null;
		if (	(this.tuples!= null) &&
				(this.tuplePtr < this.tuples.size()))
		{	
			tuple= this.tuples.get(tuplePtr);
			this.tuplePtr++;
		}
		return(tuple);
	}
}
