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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Annotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.AnyAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Document;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.LemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.POSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Span;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.Token;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.TreetaggerFactory;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions.TreetaggerModelPropertyFileInputColumnsException;

/**
 * Resource for loading and saving of treetagger data
 * 
 * @author hildebax
 * 
 */
public class TabResource extends ResourceImpl {
	private static final Logger logger = LoggerFactory.getLogger(TabResource.class);
	// column seperator
	private String separator = "\t";

	private String POSName = "pos";
	private String LemmaName = "lemma";

	/**
	 * property key for the meta tag of input
	 */
	public static final String propertyInputMetaTag = "treetagger.input.metaTag";

	/**
	 * property key for the encoding of input file
	 */
	public static final String propertyInputFileEncoding = "treetagger.input.fileEncoding";

	/**
	 * property key for the meta tag of output
	 */
	public static final String propertyOutputMetaTag = "treetagger.output.metaTag";

	/**
	 * property key for the encoding of output file
	 */
	public static final String propertyOutputFileEncoding = "treetagger.output.fileEncoding";

	/**
	 * property key for the option to export any annotation
	 */
	public static final String propertyExportAnyAnnotation = "treetagger.output.exportAnyAnnotation";

	private static final Pattern inputColumnPattern = Pattern.compile("treetagger\\.input\\.column");

	// property default values
	private static final String defaultOutputFileEncoding = "UTF-8";
	private static final String defaultInputFileEncoding = "UTF-8";
	private static final String defaultMetaTag = "meta";
	private static final String defaultExportAnyAnnotation = "true";

	// BOM character
	private static final Character utf8BOM = new Character((char) 0xFEFF);

	String currentFileName = "";

	private Properties properties = null;

	/**
	 * Getter for the Properties
	 * 
	 * @return properties
	 */
	public Properties getProperties() {
		if (properties== null){
			properties= new Properties();
		}
		return properties;
	}

	/**
	 * Stores a treetagger model into tab separated file
	 * 
	 * @param options
	 *            a map that may contain an instance of LogService and an
	 *            instance of Properties, with {@link #logServiceKey} and
	 *            {@link #propertiesKey} respectively as keys
	 */
	public void save(java.util.Map<?, ?> options) throws java.io.IOException {
		if (options!= null){
			getProperties().putAll(options);
		}
		this.currentFileName = this.getURI().toFileString();
		
		String metaTag = getProperties().getProperty(propertyOutputMetaTag, defaultMetaTag);
		logger.info(String.format("using meta tag '%s'", metaTag));

		String fileEncoding = getProperties().getProperty(propertyOutputFileEncoding, defaultOutputFileEncoding);
		logger.info(String.format("using output file encoding '%s'", fileEncoding));

		boolean exportAnyAnnotation = getProperties().getProperty(propertyExportAnyAnnotation, defaultExportAnyAnnotation).equalsIgnoreCase("true");
		logger.info("exporting any annotation = " + exportAnyAnnotation);

		BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.currentFileName), fileEncoding));
		try {
			// write contents if some exists
			if ((this.getContents() != null) && (this.getContents().size() != 0)) {
				// write all contents into file
				for (EObject content : this.getContents()) {
					if (!(content instanceof Document)) {
						String errorMessage = "Cannot store content. The given content is not of type treetagger::document: " + content;
						logger.error(errorMessage);
						throw new RuntimeException(errorMessage);
					}

					Document document = (Document) content;

					// this list and this hashmap are used if any annotation is
					// to be exported
					// the list will contain the sorted names of all annotation
					// names occuring on all tokens in the document
					// the map will map from token index to another map, which
					// maps from annotation name to AnyAnotation
					ArrayList<String> columnNamesList = null;
					HashMap<Integer, HashMap<String, AnyAnnotation>> tokenMap = null;

					if (exportAnyAnnotation) {
						// calculate number of columns and collect their names
						HashSet<String> annoNamesSet = new HashSet<String>();
						tokenMap = new HashMap<Integer, HashMap<String, AnyAnnotation>>();
						for (Integer tokenIndex = 0; tokenIndex < document.getTokens().size(); tokenIndex++) {
							Token token = document.getTokens().get(tokenIndex);
							EList<Annotation> annotationList = token.getAnnotations();
							if ((token.getPosAnnotation() != null) && (token.getLemmaAnnotation() != null) && (annotationList.size() > 2)) {
								tokenMap.put(tokenIndex, new HashMap<String, AnyAnnotation>());
								HashMap<String, AnyAnnotation> annoMap = tokenMap.get(tokenIndex);
								for (int annotationIndex = 0; annotationIndex < annotationList.size(); annotationIndex++) {
									Annotation annotation = annotationList.get(annotationIndex);
									if (annotation instanceof AnyAnnotation) {
										String annotationName = annotation.getName();
										annoNamesSet.add(annotationName);
										annoMap.put(annotationName, (AnyAnnotation) annotation);
									}
								}
							}
						}
						// sort columns
						columnNamesList = new ArrayList<String>(annoNamesSet);
						Collections.sort(columnNamesList);
						logger.info("The following columns appear in the output file additionally to word form, part-of-speech and lemma: " + columnNamesList.toString());
					}

					fileWriter.write(String.format("<%s", metaTag));
					for (int i = 0; i < document.getAnnotations().size(); i++) {
						Annotation annotation = document.getAnnotations().get(i);
						fileWriter.write(String.format(" %s=\"%s\"", annotation.getName(), annotation.getValue()));
					}
					fileWriter.write(">\n");

					ArrayList<Span> spanList = new ArrayList<Span>();
					HashMap<String, Integer> spanNamesCounts = new HashMap<String, Integer>();

					for (Integer tokenIndex = 0; tokenIndex < document.getTokens().size(); tokenIndex++) {
						Token token = document.getTokens().get(tokenIndex);

						// write end tags
						for (int spanIndex = spanList.size() - 1; spanIndex >= 0; spanIndex--) {
							Span span = spanList.get(spanIndex);
							if (!token.getSpans().contains(span)) {
								String spanName = span.getName();
								fileWriter.write("</" + spanName + ">\n");
								spanList.remove(span);
								Integer spanNameCount = spanNamesCounts.get(spanName);
								if (spanNameCount == 1) {
									spanNamesCounts.remove(spanName);
								} else {
									spanNamesCounts.put(spanName, spanNameCount - 1);
								}
							}
						}

						// calculate order for new opening tags by number of
						// tokens contained in spans ("size" of span)
						// if new opening spans have different sizes, the bigger
						// ones must open before the smaller

						// for each occuring span size, a key is put into this
						// map, mapping to a list of spans with this size
						HashMap<Integer, ArrayList<Span>> size2SpanlistMap = new HashMap<Integer, ArrayList<Span>>();
						// this list is used to have all occuring sizes sortable
						// without much converting of the maps keySet
						ArrayList<Integer> sizeList = new ArrayList<Integer>();
						for (int spanIndex = token.getSpans().size() - 1; spanIndex >= 0; spanIndex--) {
							Span span = token.getSpans().get(spanIndex);
							Integer spanSize = span.getTokens().size();
							if (!spanList.contains(span)) {
								if (!size2SpanlistMap.containsKey(spanSize)) {
									size2SpanlistMap.put(spanSize, new ArrayList<Span>());
									sizeList.add(spanSize);
								}
								size2SpanlistMap.get(spanSize).add(span);
							}
						}
						Collections.sort(sizeList);
						Collections.reverse(sizeList);
						// write opening tags in xml conform order
						for (int sizeIndex = 0; sizeIndex < sizeList.size(); sizeIndex++) {
							int size = sizeList.get(sizeIndex);

							ArrayList<String> currentSpannames = new ArrayList<String>();
							HashMap<String, ArrayList<Span>> currentSpanMap = new HashMap<String, ArrayList<Span>>();
							{
								ArrayList<Span> currentSpanlist = size2SpanlistMap.get(size);
								for (int spanIndex = 0; spanIndex < currentSpanlist.size(); spanIndex++) {
									Span span = currentSpanlist.get(spanIndex);
									String spanName = span.getName();
									if (!currentSpanMap.containsKey(spanName)) {
										currentSpannames.add(spanName);
										currentSpanMap.put(spanName, new ArrayList<Span>());
									}
									currentSpanMap.get(spanName).add(span);
								}
							}
							Collections.sort(currentSpannames);

							for (int spanNameIndex = 0; spanNameIndex < currentSpannames.size(); spanNameIndex++) {
								String spansName = currentSpannames.get(spanNameIndex);
								ArrayList<Span> currentSpanlist = currentSpanMap.get(spansName);

								if (!spanNamesCounts.containsKey(spansName)) {
									spanNamesCounts.put(spansName, currentSpanlist.size());
								} else {
									spanNamesCounts.put(spansName, spanNamesCounts.get(spansName) + currentSpanlist.size());
								}
								if (spanNamesCounts.get(spansName) > 1) {
									logger.warn("There are " + spanNamesCounts.get(spansName) + " spans named " + spansName + " open at the same time!");
								}
								for (int spanIndex = 0; spanIndex < currentSpanlist.size(); spanIndex++) {
									Span span = currentSpanlist.get(spanIndex);
									spanList.add(span);
									fileWriter.write("<" + span.getName());
									for (Annotation anno : span.getAnnotations()) {
										fileWriter.write(" " + anno.getName() + "=\"" + anno.getValue() + "\"");
									}
									fileWriter.write(">\n");
								}
							}
						}

						// write token data
						fileWriter.write(token.getText());

						fileWriter.write(this.separator);

						Annotation anno = token.getPosAnnotation();
						if (anno != null) {
							fileWriter.write(anno.getValue());
						}

						fileWriter.write(this.separator);

						anno = token.getLemmaAnnotation();
						if ((anno != null) && (anno.getValue() != null)) {
							fileWriter.write(anno.getValue());
						}

						if (exportAnyAnnotation) {
							for (int colIndex = 0; colIndex < columnNamesList.size(); colIndex++) {
								fileWriter.write(this.separator);
								String columnName = columnNamesList.get(colIndex);
								HashMap<String, AnyAnnotation> annoMap = tokenMap.get(tokenIndex);
								if (annoMap != null) {
									anno = annoMap.get(columnName);
									if (anno != null) {
										fileWriter.write(anno.getValue());
									}
								}
							}
						}

						fileWriter.write("\n");
					}

					// write final end tags
					for (int spanIndex = spanList.size() - 1; spanIndex >= 0; spanIndex--) {
						Span span = spanList.get(spanIndex);
						fileWriter.write("</" + span.getName() + ">\n");
						spanList.remove(span);
					}

					// write end of document
					fileWriter.write(String.format("</%s>\n", metaTag));

				}
			}
		} catch (RuntimeException e) {
			throw e;
		} finally {
			fileWriter.flush();
			fileWriter.close();
			fileWriter = null;
		}
	}

	/*
	 * auxilliary method for processing input file
	 */
	private void addAttributesAsAnnotations(String tag, AnnotatableElement annotatableElement) {
		ArrayList<SimpleEntry<String, String>> attributeValueList = XMLUtils.getAttributeValueList(tag);
		for (int i = 0; i < attributeValueList.size(); i++) {
			SimpleEntry<String, String> entry = attributeValueList.get(i);
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
	private HashMap<Integer, String> columnMap = null;
	private ArrayList<Integer> dataRowsWithTooMuchColumns = new ArrayList<Integer>();
	private ArrayList<Integer> dataRowsWithTooLessColumns = new ArrayList<Integer>();

	/*
	 * auxilliary method for processing input file
	 */
	private void beginDocument(String startTag) {
		if (this.currentDocument != null) {
			this.endDocument();
		}
		this.currentDocument = TreetaggerFactory.eINSTANCE.createDocument();
		this.xmlDocumentOpen = (startTag != null);
		if (this.xmlDocumentOpen) {
			addAttributesAsAnnotations(startTag, this.currentDocument);
		}
	}

	/*
	 * auxilliary method for processing input file
	 */
	private void endDocument() {
		if (this.currentDocument != null) {
			if (!this.openSpans.isEmpty()) {
				String openSpanNames = "";
				for (int spanIndex = 0; spanIndex < this.openSpans.size(); spanIndex++) {
					Span span = this.openSpans.get(spanIndex);
					openSpanNames += ",</" + span.getName() + ">";
					for (int tokenIndex = span.getTokens().size() - 1; tokenIndex >= 0; tokenIndex--) {
						Token token = span.getTokens().get(tokenIndex);
						if (token.getSpans().contains(span)) {
							token.getSpans().remove(span);
						} else {
							break;
						}
					}
				}
				logger.warn(String.format("input file '%s' (line %d): missing end tag(s) '%s'. tag(s) will be ignored!", this.getURI().lastSegment(), this.fileLineCount, openSpanNames.substring(1)));
			}
			if (this.xmlDocumentOpen) {
				logger.warn(String.format("input file '%s' (line %d): missing document end tag. document will be ignored!", this.getURI().lastSegment(), this.fileLineCount));
			} else {
				this.getContents().add(this.currentDocument);
			}

			this.currentDocument = null;
			this.xmlDocumentOpen = false;
		}
		this.openSpans.clear();
	}

	/*
	 * auxilliary method for processing input file
	 */
	private void beginSpan(String spanName, String startTag) {
		if (this.currentDocument == null) {
			this.beginDocument(null);
		}
		Span span = TreetaggerFactory.eINSTANCE.createSpan();
		this.openSpans.add(0, span);
		span.setName(spanName);
		addAttributesAsAnnotations(startTag, span);
	}

	/*
	 * auxilliary method for processing input file
	 */
	private void endSpan(String spanName) {
		if (this.currentDocument == null) {
			logger.warn(String.format("input file '%s' (line '%d'): end tag '</%s>' out of nowhere. tag will be ignored!", this.getURI().lastSegment(), this.fileLineCount, spanName));
		} else {
			boolean matchingStartTagExists = false;
			for (int i = 0; i < this.openSpans.size(); i++) {
				Span openSpan = this.openSpans.get(i);
				if (openSpan.getName().equalsIgnoreCase(spanName)) {
					matchingStartTagExists = true;
					if (openSpan.getTokens().isEmpty()) {
						logger.warn(String.format("input file '%s' (line %d): no tokens contained in span '<%s>'. span will be ignored!", this.getURI().lastSegment(), this.fileLineCount, openSpan.getName()));
					}
					this.openSpans.remove(i);
					break;
				}
			}
			if (!matchingStartTagExists) {
				logger.warn(String.format("input file '%s' (line %d): no corresponding opening tag found for end tag '</%s>'. tag will be ignored!", this.getURI().lastSegment(), this.fileLineCount, spanName));
			}
		}
	}

	/*
	 * auxilliary method for processing input file
	 */
	private void addDataRow(String row) {
		if (this.currentDocument == null) {
			this.beginDocument(null);
		}
		String[] tuple = row.split(separator);
		Token token = TreetaggerFactory.eINSTANCE.createToken();
		this.currentDocument.getTokens().add(token);
		token.setText(tuple[0]);
		for (int i = 0; i < this.openSpans.size(); i++) {
			Span span = openSpans.get(i);
			token.getSpans().add(span);
			span.getTokens().add(token);
		}

		if (tuple.length > this.columnMap.size() + 1) {
			this.dataRowsWithTooMuchColumns.add(this.fileLineCount);
		} else if (tuple.length <= this.columnMap.size()) {
			this.dataRowsWithTooLessColumns.add(this.fileLineCount);
		}

		for (int index = 1; index < Math.min(this.columnMap.size() + 1, tuple.length); index++) {
			Annotation anno = null;
			String columnName = this.columnMap.get(index);
			if (columnName.equalsIgnoreCase(this.POSName)) {
				anno = TreetaggerFactory.eINSTANCE.createPOSAnnotation();
				token.setPosAnnotation((POSAnnotation) anno);
			} else if (columnName.equalsIgnoreCase(this.LemmaName)) {
				anno = TreetaggerFactory.eINSTANCE.createLemmaAnnotation();
				token.setLemmaAnnotation((LemmaAnnotation) anno);
			} else {
				anno = TreetaggerFactory.eINSTANCE.createAnyAnnotation();
				anno.setName(columnName);
				token.getAnnotations().add(anno);
			}
			anno.setValue(tuple[index]);
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
			logger.warn(String.format("no valid document data contained in file '%s'", this.getURI().toFileString()));
			break;
		case 1:
			// set simple document name
			((Document) this.getContents().get(0)).setName(documentBaseName);
			break;
		default:
			// set document names with leading zeros for number extensions
			int documentCountDigits = String.valueOf(documentCount).length();
			for (int docIndex = 0; docIndex < documentCount; docIndex++) {
				String docNumber = Integer.toString(docIndex);
				while (docNumber.length() < documentCountDigits) {
					docNumber = "0" + docNumber;
				}
				((Document) this.getContents().get(docIndex)).setName(documentBaseName + "_" + docNumber);
			}
			break;
		}
	}

	/**
	 * validates and return the input columns definition from the properties
	 * file
	 */
	protected HashMap<Integer, String> getColumns() {
		HashMap<Integer, String> retVal = new HashMap<Integer, String>();
		Object[] keyArray = this.getProperties().keySet().toArray();
		int numOfKeys = this.getProperties().size();
		String errorMessage = null;

		for (int keyIndex = 0; keyIndex < numOfKeys; keyIndex++) {

			String key = (String) keyArray[keyIndex];
			if (inputColumnPattern.matcher(key).find()) {

				// try to extract the number at the end of the key
				String indexStr = key.substring("treetagger.input.column".length());
				String name = this.getProperties().getProperty(key);
				Integer index = null;

				try {
					index = Integer.valueOf(indexStr);
				} catch (NumberFormatException e) {
					errorMessage = "Invalid property name '" + key + "': " + indexStr + " is not a valid number!";
					logger.error(errorMessage);
					throw new TreetaggerModelPropertyFileInputColumnsException(errorMessage);
				}

				// minimal index is 1
				if (index <= 0) {
					errorMessage = "Invalid settings in properties file: no column index less than 1 allowed!";
					logger.error(errorMessage);
					throw new TreetaggerModelPropertyFileInputColumnsException(errorMessage);
				}

				// with the standard Properties class, this can never happen...
				if (retVal.containsKey(index)) {
					errorMessage = "Invalid settings in properties file:  More than one column is defined for index '" + index + "'";
					logger.error(errorMessage);
					throw new TreetaggerModelPropertyFileInputColumnsException(errorMessage);
				}

				if (retVal.containsValue(name)) {
					errorMessage = "Invalid settings in properties file:  More than one column is defined for name '" + name + "'";
					logger.error(errorMessage);
					throw new TreetaggerModelPropertyFileInputColumnsException(errorMessage);
				}

				retVal.put(index, name);
			}
		}

		// return defaults if nothing is set in the properties file
		if (retVal.size() == 0) {
			retVal.put(1, this.POSName);
			retVal.put(2, this.LemmaName);
			return retVal;
		}

		// check consecutivity of indexes
		for (int index = 1; index <= retVal.size(); index++) {
			if (!retVal.containsKey(index)) {
				errorMessage = "Invalid settings in properties file: column indexes are not consecutive, column" + index + " missing!";
				logger.error(errorMessage);
				throw new TreetaggerModelPropertyFileInputColumnsException(errorMessage);
			}
		}
		return retVal;
	}

	/**
	 * Loads a resource into treetagger model from tab separated file.
	 * 
	 * @param options
	 *            a map that may contain an instance of LogService and an
	 *            instance of Properties, with {@link #logServiceKey} and
	 *            {@link #propertiesKey} respectively as keys
	 */
	public void load(java.util.Map<?, ?> options) throws IOException {
		this.getContents().clear();
		this.openSpans.clear();
		this.currentDocument = null;
		this.fileLineCount = 0;
		this.xmlDocumentOpen = false;
		
		if (options!= null){
			getProperties().putAll(options);
		}
		
		if (this.getURI() == null) {
			String errorMessage = "Cannot load any resource, because no uri is given.";
			logger.error(errorMessage);
			throw new NullPointerException(errorMessage);
		}
		this.currentFileName = this.getURI().toFileString();
		
		String metaTag = getProperties().getProperty(propertyInputMetaTag, defaultMetaTag);
		logger.info("using meta tag '{}'", metaTag);

		String fileEncoding = getProperties().getProperty(propertyInputFileEncoding, defaultInputFileEncoding);
		logger.info("using input file encoding '{}'", fileEncoding);

		this.columnMap = getColumns();

		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.currentFileName), fileEncoding));
		String line = null;
		this.fileLineCount = 0;
		while ((line = fileReader.readLine()) != null) {
			if (line.trim().length() > 0) {
				// delete BOM if exists
				if ((this.fileLineCount == 0) && (line.startsWith(utf8BOM.toString()))) {
					line = line.substring(utf8BOM.toString().length());
					logger.info("BOM recognised and ignored");
				}
				this.fileLineCount++;
				if (XMLUtils.isProcessingInstructionTag(line)) {
					// do nothing; ignore processing instructions
				} else if (XMLUtils.isStartTag(line)) {
					String startTagName = XMLUtils.getName(line);
					if (startTagName.equalsIgnoreCase(metaTag)) {
						this.beginDocument(line);
					} else {
						this.beginSpan(startTagName, line);
					}
				} else if (XMLUtils.isEndTag(line)) {
					String endTagName = XMLUtils.getName(line);
					if (endTagName.equalsIgnoreCase(metaTag)) {
						this.xmlDocumentOpen = false;
						this.endDocument();
					} else {
						this.endSpan(endTagName);
					}
				} else {
					this.addDataRow(line);
				}
			}
		}
		this.endDocument();
		fileReader.close();

		this.setDocumentNames();

		if (this.dataRowsWithTooLessColumns.size() > 0) {
			logger.warn(String.format("%s rows in input file had less data columns than expected! (Rows %s)", this.dataRowsWithTooLessColumns.size(), this.dataRowsWithTooLessColumns.toString()));
		}
		if (this.dataRowsWithTooMuchColumns.size() > 0) {
			logger.warn(String.format("%s rows in input file had more data columns than expected! Additional data was ignored! (Rows %s)", this.dataRowsWithTooMuchColumns.size(), this.dataRowsWithTooMuchColumns.toString()));
		}
	}
}
