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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language;

import org.knallgrau.utils.textcat.TextCategorizer;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions.TreetaggerException;
 
/**
 * This class detects the language of a given text fragment and returns the ISO-639-1 language of the detected 
 * language.
 *  
 * @author Florian Zipser
 *
 */
public class LanguageDetector 
{
	/**
	 * Detects a language out of the given text and returns the ISO-639-1 language code  
	 * @param text
	 * @return
	 */
	public static ISO639_LANGUAGE_CODE detectLanguage(String text)
	{
		if (	(text== null)||
				(text.isEmpty()))
			throw new TreetaggerException("Cannot detect language for an empty text.");
		TextCategorizer textcategorizer= new TextCategorizer();
		String languageDesc= textcategorizer.categorize(text);
		return(ISO639_LANGUAGE_CODE.valueOfByName(languageDesc));
	}
}
