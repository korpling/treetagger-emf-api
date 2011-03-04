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

public class TabResource extends ResourceImpl
{
	/**
	 * Seperator which seperates columns
	 */
	private String separator= "\t";
	
	/**
	 * default input and output file encodings
	 */
	private String defaultOutputFileEncodingName = "UTF-8";
	//TODO: UTF8!
	private String defaultInputFileEncodingName  = "ISO-8859-2";
	
	//----------------------------------------------------------
	private LogService logService = null;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	private void log(int logLevel, String logText) {
		if (this.getLogService()!=null) {
			this.getLogService().log(logLevel, logText);
		}
	}
	
	private void logError  (String logText) { this.log(LogService.LOG_ERROR,   logText); }
	private void logWarning(String logText) { this.log(LogService.LOG_WARNING, logText); }
	@SuppressWarnings("unused")
	private void logInfo   (String logText) { this.log(LogService.LOG_INFO,    logText); }
	@SuppressWarnings("unused")
	private void logDebug  (String logText) { this.log(LogService.LOG_DEBUG,   logText); }
	//----------------------------------------------------------
	
	private Properties properties = new Properties();
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	//----------------------------------------------------------
	
	/**
	 * Stores a a treetagger-model into tab-separated file.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
		String metaTagName = properties.getProperty("treetaggerModule.metaTagName", "meta");
		String fileEncodingName = properties.getProperty("treetaggerModule.outputFileEncodingName",defaultOutputFileEncodingName);
		
		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.getURI().toFileString()), fileEncodingName));
		
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
					
					fileWriter.write(String.format("<%s",metaTagName));
					for (int i=0;i<document.getAnnotations().size();i++) {
						Annotation annotation = document.getAnnotations().get(i);
						fileWriter.write(String.format(" %s=\"%s\"",annotation.getName(),annotation.getValue()));
					}
					fileWriter.write(">\n");
					
					ArrayList<Span> spanList = new ArrayList<Span>();
					
					for (int tokenIndex=0;tokenIndex<document.getTokens().size();tokenIndex++)
					{
						Token token = document.getTokens().get(tokenIndex);

						//write closing tags
						for (int spanIndex=spanList.size()-1;spanIndex>=0;spanIndex--) {
							Span span = spanList.get(spanIndex);
							if (!token.getSpans().contains(span)) {
								fileWriter.write("</" + span.getName() + ">\n");
								spanList.remove(span);
							}
						}
						
						//write opening tags
						for (int spanIndex=0;spanIndex<token.getSpans().size();spanIndex++) {
							Span span = token.getSpans().get(spanIndex);
							if (!spanList.contains(span)) {
								spanList.add(span);
								fileWriter.write("<"+span.getName());
								for (Annotation anno: span.getAnnotations()) {
									fileWriter.write(" " + anno.getName() + "\"=\"" + anno.getValue());
								}
								fileWriter.write(">\n");
							}
						}

						//write token data
						fileWriter.write(token.getText());
						
						if (	(token.getAnnotations()!= null) &&
								(token.getAnnotations().size() > 0))
						{
							for (Annotation anno: token.getAnnotations())
							{
								fileWriter.write(this.separator + anno.getValue());
							}
						}	
						fileWriter.write("\n");
					}

					//write final closing tags
					for (int spanIndex=spanList.size()-1;spanIndex>=0;spanIndex--) {
						Span span = spanList.get(spanIndex);
						fileWriter.write("</" + span.getName() + ">\n");
						spanList.remove(span);
					}
					
					//write end of document
					fileWriter.write(String.format("</%s>\n", metaTagName));
					
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
	 * auxilliary method to annotate an annotatableElement with attributes from an XML opening tag 
	 * @param XMLOpeningTag
	 * @param annotatableElement
	 */
	private void addAttributesAsAnnotations(String XMLOpeningTag, AnnotatableElement annotatableElement) {
		ArrayList<SimpleEntry<String,String>> attributeValueList = XMLUtils.getAttributeValueList(XMLOpeningTag);
		for (int i=0; i<attributeValueList.size();i++) {
			SimpleEntry<String,String> entry = attributeValueList.get(i); 
			Annotation annotation = TreetaggerFactory.eINSTANCE.createAnnotation();
			annotation.setName(entry.getKey());
			annotation.setValue(entry.getValue());
			annotatableElement.getAnnotations().add(annotation);
		}
	}
	
	/**
	 * Loads a resource into treetagger-model from tab-seperated file.
	 */
	public void load(java.util.Map<?,?> options) throws IOException
	{
		String metaTagName = properties.getProperty("treetaggermodel.metaTagName", "meta");
		//TODO: default: utf8
		String fileEncodingName = properties.getProperty("treetaggerModule.inputFileEncodingName",defaultInputFileEncodingName);
		
		if (this.getURI()== null) {
			String errorMessage = "Cannot load any resource, because no uri is given.";
			logError(errorMessage);
			throw new NullPointerException(errorMessage);
		}

		Document document = null;
		int documentCount = 0;
		String documentBaseName = null;
		ArrayList<Span> openSpans = new ArrayList<Span>();
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.getURI().toFileString()),fileEncodingName));
		
		String line = null;
		int lineCount = 0;
		boolean betweenDocuments = true; //this is to mark whether the current input line belongs to a document or is just in the space between, before or after a document
		while((line = fileReader.readLine()) != null) {
			lineCount++;
			
			// opening tag ------------------------------------------------------------------------
			
			if (XMLUtils.isOpeningTag(line)) {
				String openingTagName = XMLUtils.getName(line);
				if (openingTagName.equalsIgnoreCase(metaTagName)) {
					betweenDocuments = false;
					//create document object
					document = TreetaggerFactory.eINSTANCE.createDocument();
					documentCount++;
					documentBaseName = this.getURI().lastSegment().split("[.]")[0];
					document.setName(documentBaseName + "_#" + documentCount);
					addAttributesAsAnnotations(line, document);
				}
				else {
					Span span = TreetaggerFactory.eINSTANCE.createSpan();
					openSpans.add(span);
					span.setName(openingTagName);
					addAttributesAsAnnotations(line, span);
				}
			} 

			// closing tag  ------------------------------------------------------------------------
			
			else if (XMLUtils.isClosingTag(line)) {
				String closingTagName = XMLUtils.getName(line);
				if (closingTagName.equalsIgnoreCase(metaTagName)) {
					//warn if there are missing closing tags
					if (openSpans.size()>0) {
						String openSpanNames = "";
						for (int i=0;i<openSpans.size();i++) {
							Span span = openSpans.get(i);
							openSpanNames += ",</" + span.getName() + ">";
						}
						logWarning(String.format("input file '%s' (line %d): missing closing tag(s) '%s'. tag(s) will be IGNORED!",this.getURI().lastSegment(),lineCount,openSpanNames.substring(1)));
					}
					//add document to contents
					this.getContents().add(document);
					betweenDocuments = true;
				}
				else {
					boolean closingTagFound = (openSpans.size()==0);
					for (int i=openSpans.size()-1;i>=0||!closingTagFound;i--) {

						//TODO: this is only temporary because i cant concentrate any more - problem is sometimes trying to .get(-1) 
						if (i<0) {
							closingTagFound=true;
							break;
						}
						
						if (openSpans.get(i).getName().equalsIgnoreCase(closingTagName)) {
							closingTagFound = true;
							Span openSpan = openSpans.get(i);
							if (openSpan.getTokens().isEmpty()) {
								logWarning(String.format("input file '%s' (line %d): no tokens contained in <%s>. tag will be IGNORED!",this.getURI().lastSegment(),lineCount,openSpan.getName()));
							}
							openSpans.remove(i);
						}
					}
					if (!closingTagFound) {
						logWarning(String.format("input file '%s' (line %d): no corresponding opening tag found for closing tag '</%s>'. tag will be IGNORED!",this.getURI().lastSegment(),lineCount,closingTagName));
					}
				}
			}

			// data line  ------------------------------------------------------------------------
			
			else {
				if (!betweenDocuments) {
					String[] tuple = line.split(separator);
					Token token= TreetaggerFactory.eINSTANCE.createToken();
					document.getTokens().add(token);
					token.setText(tuple[0]);
					for (int i=0;i<openSpans.size();i++) {
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
								logWarning(String.format("input file '%s' (line %d): %d data columns found, but only 3 expected. additional columns will be IGNORED! ",this.getURI().lastSegment(),lineCount,tuple.length));
							}
						}
					}
				}
			}
            //------------------------------------------------------------------------
		}
		if (documentCount==1) {
			document.setName(documentBaseName);
		}
		fileReader.close();
}
	
}
