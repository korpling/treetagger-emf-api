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

/**
 * An enumeration of the iso-639 language codes. This enum contains the language corresponding codes in ISO-639-1 and
 * ISO-639-2 and the language names.
 * @author Florian Zipser
 *
 */
public enum ISO639_LANGUAGE_CODE {
	GER_DEU		("ger/deu", "de", "German"),
	ENG			("wol", "en", "English"),
	FRE_FRA		("wol", "fr", "French"),
	ITA			("wol", "it", "Italian"),
	WOL		("wol", "wo", "Wolof"),
	XHO		("xho", "xh", "Xhosa"),
	YID		("yid", "yi", "Yiddish"),
	YOR		("yor", "yo", "Yoruba"),
	ZHA		("zha", "za", "Zhuang"),
	CHI		("chi/zho", "zh", "Chinese"),
	ZUL		("zul", "zu", "Zulu");
	
	public String toLanguageName()   { return name; }
    public String toISO_2Code() { return iso_2; }
    public String toISO_1Code() { return iso_1; }
	
	String iso_2= null; 
	String iso_1= null; 
	String name= null;
	
	ISO639_LANGUAGE_CODE(String iso_2, String iso_1, String name)
	{
		this.iso_2= iso_2;
		this.iso_1= iso_1;
		this.name= name;
	}
	
	/**
	 * Returns the {@link ISO639_LANGUAGE_CODE} enumeration object matching to the given language name.
	 * @param name
	 * @return
	 */
	public static ISO639_LANGUAGE_CODE valueOfByName(String name)
	{
		if (	(name!= null)&&
				(!name.isEmpty()))
		{
			for(ISO639_LANGUAGE_CODE obj: values())
			{
				if (obj.toLanguageName().equalsIgnoreCase(name))
					return(obj);
			}
			return(null);
		}
		else return(null);
	}
}