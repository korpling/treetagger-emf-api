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
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.osgi.service.log.LogService;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;

/**
 * Resource for loading and saving of treetagger data
 * @author hildebax
 *
 */
public class TabResource extends ResourceImpl
{
	//column seperator
	private String separator= "\t";
	
	/**
	 * Key for the LogService in the options map of load and save methods
	 */
	public static final String logServiceKey = "LOGSERVICE";
	/**
	 * Key for the Properties in the options map of load and save method
	 */
	public static final String propertiesKey = "PROPERTIES"; 
	
	/**
	 * property key for the meta tag of input
	 */
	public static final String propertyInputMetaTag       = "treetagger.input.metaTag";

	/**
	 * property key for the encoding of input file
	 */
	public static final String propertyInputFileEncoding  = "treetagger.input.fileEncoding";

	/**
	 * property key for the meta tag of output
	 */
	public static final String propertyOutputMetaTag      = "treetagger.output.metaTag";	
	
	/**
	 * property key for the encoding of output file
	 */
	public static final String propertyOutputFileEncoding = "treetagger.output.fileEncoding";	

	//property default values
	private static final String defaultOutputFileEncoding = "UTF-8";
	private static final String defaultInputFileEncoding  = "UTF-8";
	private static final String defaultMetaTag = "meta";
	
	//BOM character
	private static final Character utf8BOM = new Character((char)0xFEFF);

	//----------------------------------------------------------
	private LogService logService = null;
	
	/**
	 * Getter for the LogService
	 * @return the LogService
	 */
	public LogService getLogService() {
		return logService;
	}

	/**
	 * Setter for the LogService
	 * @param logService the LogService
	 */
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	private void log(int logLevel, String logText) {
		if (this.getLogService()!=null) {
			this.getLogService().log(logLevel, "<TabResource>: " + logText);
		}
	}
	
	private void logError  (String logText) { this.log(LogService.LOG_ERROR,   logText); }
	private void logWarning(String logText) { this.log(LogService.LOG_WARNING, logText); }
	private void logInfo   (String logText) { this.log(LogService.LOG_INFO,    logText); }
//	private void logDebug  (String logText) { this.log(LogService.LOG_DEBUG,   logText); }
	
	//----------------------------------------------------------
	
	private Properties properties = null;
	
	/**
	 * Getter for the Properties
	 * @return properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Setter for the Properties
	 * @param properties the properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	//----------------------------------------------------------

	
	
/*==============================================================================================================
/* S A V I N G . . . 
/*==============================================================================================================*/
		
	/**
	 * Stores a treetagger model into tab separated file
	 * @param options a map that may contain an instance of LogService and an instance of Properties, with {@link #logServiceKey} and {@link #propertiesKey} respectively as keys   
	 */
 	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (options!=null) {
			if (options.containsKey(logServiceKey)) {
				this.setLogService((LogService)options.get(logServiceKey));		
			}
			if (options.containsKey(propertiesKey)) {
				this.setProperties((Properties)options.get(propertiesKey));		
			}
		}
		
		if (this.getProperties()==null) {
			logWarning("no properties given for loading of resource. using defaults.");
			this.setProperties(new Properties());
		}
		
		String metaTag = properties.getProperty(propertyOutputMetaTag, defaultMetaTag);
		logInfo(String.format("using meta tag '%s'",metaTag));
		
		String fileEncoding = properties.getProperty(propertyOutputFileEncoding, defaultOutputFileEncoding);
		logInfo(String.format("using output file encoding '%s'",fileEncoding));
		
		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.getURI().toFileString()), fileEncoding));
		try 
		{
			//write contents if some exists
			if (	(this.getContents()!= null) &&
					(this.getContents().size()!= 0))
			{
				//write all contents into file
				for (EObject content: this.getContents())
				{	
					if (!(content instanceof Document)) {
						String errorMessage = "Cannot store content. The given content is not of type treetagger::document: "+ content;
						logError(errorMessage);
						throw new RuntimeException(errorMessage);
					}

					Document document = (Document)content;
					
					fileWriter.write(String.format("<%s",metaTag));
					for (int i=0;i<document.getAnnotations().size();i++) {
						Annotation annotation = document.getAnnotations().get(i);
						fileWriter.write(String.format(" %s=\"%s\"",annotation.getName(),annotation.getValue()));
					}
					fileWriter.write(">\n");
					
					ArrayList<Span> spanList = new ArrayList<Span>();
					
					for (int tokenIndex=0;tokenIndex<document.getTokens().size();tokenIndex++)
					{
						Token token = document.getTokens().get(tokenIndex);

						//write end tags
						for (int spanIndex=spanList.size()-1;spanIndex>=0;spanIndex--) {
							Span span = spanList.get(spanIndex);
							if (!token.getSpans().contains(span)) {
								fileWriter.write("</" + span.getName() + ">\n");
								spanList.remove(span);
							}
						}
						
						//write opening tags
						for (int spanIndex=token.getSpans().size()-1;spanIndex>=0;spanIndex--) {
							Span span = token.getSpans().get(spanIndex);
							if (!spanList.contains(span)) {
								spanList.add(span);
								fileWriter.write("<"+span.getName());
								for (Annotation anno: span.getAnnotations()) {
									fileWriter.write(" " + anno.getName() + "=\"" + anno.getValue() + "\"");
								}
								fileWriter.write(">\n");
							}
						}

						//write token data
						fileWriter.write(token.getText());

						fileWriter.write(this.separator);
						
						Annotation anno = token.getPosAnnotation();
						if (anno!=null) {
							fileWriter.write(anno.getValue());
						}
						
						fileWriter.write(this.separator);						

						anno = token.getLemmaAnnotation();
						if (anno!=null) {
							fileWriter.write(anno.getValue());
						}

						fileWriter.write("\n");
					}

					//write final end tags
					for (int spanIndex=spanList.size()-1;spanIndex>=0;spanIndex--) {
						Span span = spanList.get(spanIndex);
						fileWriter.write("</" + span.getName() + ">\n");
						spanList.remove(span);
					}
					
					//write end of document
					fileWriter.write(String.format("</%s>\n", metaTag));
					
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

	
		
/*==============================================================================================================
/* L O A D I N G . . .
/*==============================================================================================================*/
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void addAttributesAsAnnotations(String tag, AnnotatableElement annotatableElement) {
		ArrayList<SimpleEntry<String,String>> attributeValueList = XMLUtils.getAttributeValueList(tag);
		for (int i=0; i<attributeValueList.size();i++) {
			SimpleEntry<String,String> entry = attributeValueList.get(i); 
			Annotation annotation = TreetaggerFactory.eINSTANCE.createAnnotation();
			annotation.setName(entry.getKey());
			annotation.setValue(entry.getValue());
			annotatableElement.getAnnotations().add(annotation);
		}
	}
	
	private Document currentDocument = null; 
	private ArrayList<Span> openSpans = new ArrayList<Span>();
	private int fileLineCount = 0;
	private boolean xmlDocumentOpen = false;
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void beginDocument(String startTag) {
		if (this.currentDocument!=null) {
			this.endDocument();
		}
		this.currentDocument = TreetaggerFactory.eINSTANCE.createDocument();
		this.xmlDocumentOpen = (startTag!=null);  
		if (this.xmlDocumentOpen) {
			addAttributesAsAnnotations(startTag, this.currentDocument);
		}
	}
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void endDocument() {
		if (this.currentDocument!=null) {
			if (!this.openSpans.isEmpty()) {
				String openSpanNames = "";
				for (int spanIndex=0;spanIndex<this.openSpans.size();spanIndex++) {
					Span span = this.openSpans.get(spanIndex);
					openSpanNames += ",</" + span.getName() + ">";
					for (int tokenIndex=span.getTokens().size()-1;tokenIndex>=0;tokenIndex--) {
						Token token = span.getTokens().get(tokenIndex);
						if (token.getSpans().contains(span)) {
							token.getSpans().remove(span);
						}
						else {
							break;
						}
					}
				}
				logWarning(String.format("input file '%s' (line %d): missing end tag(s) '%s'. tag(s) will be ignored!",this.getURI().lastSegment(),this.fileLineCount,openSpanNames.substring(1)));
			}
			if (this.xmlDocumentOpen) {
				logWarning(String.format("input file '%s' (line %d): missing document end tag. document will be ignored!",this.getURI().lastSegment(),this.fileLineCount));
			} 
			else {
				this.getContents().add(this.currentDocument);
			}
			
			this.currentDocument=null;
			this.xmlDocumentOpen=false;
		}
		this.openSpans.clear();
	}
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void beginSpan(String spanName, String startTag) {
		if (this.currentDocument==null) {
			this.beginDocument(null);
		}
		Span span = TreetaggerFactory.eINSTANCE.createSpan();
		this.openSpans.add(0,span);
		span.setName(spanName);
		addAttributesAsAnnotations(startTag, span);
	}

	/*
	 * auxilliary method for processing input file 
	 */
	private void endSpan(String spanName) {
		if (this.currentDocument==null) {
			logWarning(String.format("input file '%s' (line '%d'): end tag '</%s>' out of nowhere. tag will be ignored!",this.getURI().lastSegment(),this.fileLineCount,spanName));
		} 
		else {
			boolean matchingStartTagExists = false;
			for (int i=0; i<this.openSpans.size(); i++) {
				Span openSpan = this.openSpans.get(i);
				if (openSpan.getName().equalsIgnoreCase(spanName)) {
					matchingStartTagExists = true;
					if (openSpan.getTokens().isEmpty()) {
						logWarning(String.format("input file '%s' (line %d): no tokens contained in span '<%s>'. span will be ignored!",this.getURI().lastSegment(),this.fileLineCount,openSpan.getName()));	
					}
					this.openSpans.remove(i);
					break;
				}
			}
			if (!matchingStartTagExists) {
				logWarning(String.format("input file '%s' (line %d): no corresponding opening tag found for end tag '</%s>'. tag will be ignored!",this.getURI().lastSegment(),this.fileLineCount,spanName));
			}
		}
	}
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void addDataRow(String row) {
		if (row!="") {
			if (this.currentDocument==null) {
				this.beginDocument(null);
			}
			String[] tuple = row.split(separator);
			Token token= TreetaggerFactory.eINSTANCE.createToken();
			this.currentDocument.getTokens().add(token);
			token.setText(tuple[0]);
			for (int i=0;i<this.openSpans.size();i++) {
				Span span = openSpans.get(i);
				token.getSpans().add(span);
				span.getTokens().add(token);
			}
			if (tuple.length>1) {
				POSAnnotation posAnno= TreetaggerFactory.eINSTANCE.createPOSAnnotation();
				posAnno.setValue(tuple[1]);
				token.getAnnotations().add(posAnno);
				if (tuple.length>2) { 
					LemmaAnnotation lemmaAnno= TreetaggerFactory.eINSTANCE.createLemmaAnnotation();
					lemmaAnno.setValue(tuple[2]);
					token.getAnnotations().add(lemmaAnno);
					if (tuple.length>3) {
						logWarning(String.format("input file '%s' (line %d): %d data columns found, but only 3 expected. additional columns will be ignored! ",this.getURI().lastSegment(),this.fileLineCount,tuple.length));
					}
				}
			}
		}
	}
	
	/*
	 * auxilliary method for processing input file 
	 */
	private void setDocumentNames() {
		String documentBaseName = this.getURI().lastSegment().split("[.]")[0];
		int documentCount = this.getContents().size();
		switch (documentCount) {
			case 0: 
				logWarning(String.format("no valid document data contained in file '%s'",this.getURI().toFileString())); 
				break;
			case 1:
				//set simple document name
				((Document)this.getContents().get(0)).setName(documentBaseName);
				break;
			default:
				//set document names with leading zeros for number extensions
				int documentCountDigits = String.valueOf(documentCount).length();
				for (int docIndex=0;docIndex<documentCount;docIndex++) {
					String docNumber = Integer.toString(docIndex);
					while (docNumber.length()<documentCountDigits) {
						docNumber = "0" + docNumber;
					}
					((Document)this.getContents().get(docIndex)).setName(documentBaseName + "_" + docNumber);
				}
				break;
		}
	}
	
	/**
	 * Loads a resource into treetagger model from tab separated file.
	 * @param options a map that may contain an instance of LogService and an instance of Properties, with {@link #logServiceKey} and {@link #propertiesKey} respectively as keys 
	 */
	public void load(java.util.Map<?,?> options) throws IOException
	{
		this.getContents().clear();
		this.openSpans.clear();
		this.currentDocument = null; 
		this.fileLineCount = 0;
		this.xmlDocumentOpen = false;
		
		if (options!=null) {
			if (options.containsKey(logServiceKey)) {
				this.setLogService((LogService)options.get(logServiceKey));		
			}
			if (options.containsKey(propertiesKey)) {
				this.setProperties((Properties)options.get(propertiesKey));		
			}
		}
		
		if (this.getProperties()==null) {
			logWarning("no properties given for loading of resource. using defaults.");
			this.setProperties(new Properties());
		}
		
		String metaTag = properties.getProperty(propertyInputMetaTag, defaultMetaTag);
		logInfo(String.format("using meta tag '%s'",metaTag));
		
		String fileEncoding = properties.getProperty(propertyInputFileEncoding, defaultInputFileEncoding);
		logInfo(String.format("using input file encoding '%s'",fileEncoding));
		
		if (this.getURI()== null) {
			String errorMessage = "Cannot load any resource, because no uri is given.";
			logError(errorMessage);
			throw new NullPointerException(errorMessage);
		}

		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.getURI().toFileString()),fileEncoding));
		String line = null;
		this.fileLineCount = 0;
		while((line = fileReader.readLine()) != null) {

			//delete BOM if exists
			if ((this.fileLineCount==0)&&(line.startsWith(utf8BOM.toString()))) {
				line = line.substring(utf8BOM.toString().length());
				logInfo("BOM recognised and ignored");
			}

			this.fileLineCount++;
			if (XMLUtils.isProcessingInstructionTag(line)) {
				//do nothing; ignore processing instructions
			}
			else if (XMLUtils.isStartTag(line)) {
				String startTagName = XMLUtils.getName(line);
				if (startTagName.equalsIgnoreCase(metaTag)) {
					this.beginDocument(line);
				}
				else {
					this.beginSpan(startTagName, line);
				}
			} 
			else if (XMLUtils.isEndTag(line)) {
				String endTagName = XMLUtils.getName(line);
				if (endTagName.equalsIgnoreCase(metaTag)) {
					this.xmlDocumentOpen = false;
					this.endDocument();
				}
				else {
					this.endSpan(endTagName);
				}
			}
			else {
				this.addDataRow(line);
			}
		}
		this.endDocument();
		fileReader.close();

		this.setDocumentNames();
	}
}
