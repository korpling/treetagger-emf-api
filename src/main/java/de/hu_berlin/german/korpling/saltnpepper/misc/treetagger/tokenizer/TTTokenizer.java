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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions.TTTokenizerException;
import java.util.ArrayList;


/**
 * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
 * A list of tokenized text is returned with the text anchor (start and end position) in original text.
 * Reimplemented in Java with permission from the original TreeTagger tokenizer in Perl by Helmut Schmid 
 * (see http://www.ims.uni-stuttgart.de/projekte/corplex/TreeTagger/).
 *  
 * @author Amir Zeldes
 * 
 *
 */
public class TTTokenizer 
{
    public enum TTLanguages {de,en,fr,it};
   
   

	/**
     * Initializes a new TTokenizer object.
     */
    public TTTokenizer()  
    {
    }
    
    /**
     * Initializes a new TTokenizer object.
     * @param flAbbreviations
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public TTTokenizer(File flAbbreviations) 
    {
        readAbbreviations(flAbbreviations);
    }

    /**
     * Initializes a new TTokenizer object.
     * @param flAbbreviations
     * @param lngLang
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public TTTokenizer(File flAbbreviations, TTLanguages lngLang) 
    {
        this.setLngLang(lngLang);
    	setClitics(lngLang);
        readAbbreviations(flAbbreviations);
    }
    
//=============================== start: language    
    /**
     * the language of the text to be tokenized
     */
    private TTLanguages lngLang = TTLanguages.de;
    
    /**
     * Sets the language of the text which shall be tokenized.
	 * @param lngLang the lngLang to set
	 */
	public void setLngLang(TTLanguages lngLang) {
		this.lngLang = lngLang;
	}

	/**
	 * returns the set language of the text which shall be tokenized.
	 * @return the lngLang
	 */
	public TTLanguages getLngLang() {
		return lngLang;
	}
//=============================== end: language
//=============================== start: abbreviation folder
	/**
	 * Folder where the abbreviation files can be found.
	 */
	private File abbriviationFolder= null;
	
	/**
	 * Sets the folder where the abbreviation files can be found.
	 * @param abbriviationFolder the abbriviationFolder to set
	 */
	public void setAbbriviationFolder(File abbriviationFolder) {
		this.abbriviationFolder = abbriviationFolder;
	}

	/**
	 * Returns the set folder where the abbreviation files can be found.
	 * @return the abbriviationFolder
	 */
	public File getAbbriviationFolder() {
		return abbriviationFolder;
	}
//=============================== end: abbreviation folder	
//=============================== start: abbreviation
	private Hashtable<String, Boolean> hashAbbreviations = null;
	    
	public Hashtable<String, Boolean> getHashAbbreviations() {
		return hashAbbreviations;
	}

	public void setHashAbbreviations(Hashtable<String, Boolean> hashAbbreviations) {
		this.hashAbbreviations = hashAbbreviations;
	}
//=============================== end: abbreviation
		
    /**
     * Reads the abbreviation from given file. 
     * @param flAbbreviations
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readAbbreviations(File flAbbreviations)
    {
    	try 
    	{
    		this.setHashAbbreviations(new Hashtable<String, Boolean>());
            
    		BufferedReader inReader;
		
			inReader = new BufferedReader(new InputStreamReader(new FileInputStream(flAbbreviations), "UTF8"));
		
			String input = "";
			
			while((input = inReader.readLine()) != null)
			{
	           //putting
	           hashAbbreviations.put(input, true);
			}
			inReader.close();
			
        } catch (FileNotFoundException e) 
        {
			throw new TTTokenizerException("Cannot tokenize the given text, because the file for abbreviation '"+flAbbreviations.getAbsolutePath()+"' was not found.");
		} catch (IOException e) 
		{
			throw new TTTokenizerException("Cannot tokenize the given text, because can not read file '"+flAbbreviations.getAbsolutePath()+"'.");
		}
		
    }
    
    private static Hashtable<TTLanguages, File> languageAbbreviationFileTable= null;
    {
    	languageAbbreviationFileTable= new Hashtable<TTTokenizer.TTLanguages, File>();
    	languageAbbreviationFileTable.put(TTLanguages.it, new File("italian-abbreviations"));
    	languageAbbreviationFileTable.put(TTLanguages.de, new File("german-abbreviations"));
    	languageAbbreviationFileTable.put(TTLanguages.fr, new File("french-abbreviations"));
    	languageAbbreviationFileTable.put(TTLanguages.en, new File("english-abbreviations"));
    }
    
    /**
     * Returns an abbreviation file generated out of the given abbreviation folder and the given language.
     * @param abbreviationFolder
     * @param language
     * @return file of matching abbreviation
     */
    private File getAbbreviationFile(File abbreviationFolder, TTLanguages language)
    {
    	File abbreviationFile= null;
    	if (language== null)
    		throw new TTTokenizerException("Cannot start tokenization, no language is set so far.");
    	
    	if (abbreviationFolder== null)
    		throw new TTTokenizerException("Cannot start tokenization, no folder containing the abbreviation is set so far.");
    	
    	abbreviationFile= new File(this.getAbbriviationFolder().getAbsolutePath()+"/"+languageAbbreviationFileTable.get(language));
    	return(abbreviationFile);
    }

//======================= start: important issues
 // characters which have to be cut off at the beginning of a word
    private final static String PChar = "\\[\\{\\(´`\"»«‚„†‡‹‘’“”•–—›";
    // characters which have to be cut off at the end of a word
    private final static String FChar = "\\]\\}'`\"\\),;:!\\?%»«‚„…†‡‰‹‘’“”•–—›";

    // character sequences which have to be cut off at the beginning of a word
    private String PClitic="";
    // character sequences which have to be cut off at the end of a word
    private String FClitic="";
    
    /**
     * Sets clitics corresponding to the given language.
     * @param lngLang language
     */
    private void setClitics(TTLanguages lngLang)
    {
        if (this.getLngLang()!=null)
        {
            this.setLngLang(lngLang);
            switch (lngLang){
                case en:
                    this.FClitic = "('(s|re|ve|d|m|em|ll)|n't)";
                    break;
                case fr:
                    this.PClitic = "([dcjlmnstDCJLNMST]'|[Qq]u'|[Jj]usqu'|[Ll]orsqu')";
                    this.FClitic = "(-t-elles?|-t-ils?|-t-on|-ce|-elles?|-ils?|-je|-la|-les?|-leur|-lui|-mêmes?|-m'|-moi|-nous|-on|-toi|-tu|-t'|-vous|-en|-y|-ci|-là)";
                    break;
                case it:
                    this.PClitic = "([dD][ae]ll'|[nN]ell'|[Aa]ll'|[lLDd]'|[Ss]ull'|[Qq]uest'|[Uu]n'|[Ss]enz'|[Tt]utt')";
                    break;
                case de: //do nothing

            }
        }
    }
    
    /**
     * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
     * A list of tokenized text is returned with the text anchor (start and end position) in original text.
     * @param strInput original text
     * @return tokenized text fragments and their position in the original text
     */
    public List<Token> tokenizeToToken(String strInput) 
    {
    	List<Token> retVal= null;
    	
    	if (this.getLngLang()== null)
    		throw new TTTokenizerException("Cannot start tokenization, no language is set so far.");
    	
    	if (this.abbriviationFolder== null)
    		throw new TTTokenizerException("Cannot start tokenization, no folder containing the abbreviation is set so far.");
    	
    	this.setClitics(this.getLngLang());
    	this.readAbbreviations(this.getAbbreviationFile(this.getAbbriviationFolder(), this.getLngLang()));
    	
    	List<String> strTokens = null;
    	strTokens= this.tokenizeToString(strInput);
    	if (	(strTokens!= null)&&
    			(strTokens.size()> 0))
    	{
    		retVal= new Vector<Token>();
    		char[] chrText= strInput.toCharArray();
    		int tokenCntr= 0;
    		
    		for (int i=0; i< chrText.length; i++ )
     		{
    			if (	(strTokens.get(tokenCntr).length()< 1) ||
    					(strTokens.get(tokenCntr).substring(0, 1).equals(String.valueOf(chrText[i]))))
     			{//first letter matches
     	 			StringBuffer pattern= new StringBuffer();
     				for (int y=0; y < strTokens.get(tokenCntr).length(); y++)
     				{//compute pattern in text
     					pattern.append(chrText[i+y]);
     				}//compute pattern in text
     				if (strTokens.get(tokenCntr).hashCode()== pattern.toString().hashCode())
     				{//pattern found
     					Token token= new Token();
     	    			retVal.add(token);
     	    			token.text= strTokens.get(tokenCntr);
     	    			token.start= i;
     	    			token.end= i+strTokens.get(tokenCntr).length();
     					i= i+strTokens.get(tokenCntr).length()-1;
     					tokenCntr++;
     					if (tokenCntr >= strTokens.size())
     						break;
     				}//pattern found
     			}//first letter matches
     		}
    	}
    	return(retVal);
    }
    
    /**
     * The general task of this class is to tokenize a given text in the same order as the tool TreeTagger will do. 
     * Returns a list of tokenized text. 
     * @param strInput original text
     * @return tokeized text fragments
     */
    public List<String> tokenizeToString(String strInput) 
    {
    	if (this.getLngLang()== null)
    		throw new TTTokenizerException("Cannot start tokenization, no language is set so far.");
    	
    	if (this.abbriviationFolder== null)
    		throw new TTTokenizerException("Cannot start tokenization, no folder containing the abbreviation is set so far.");
    	
    	this.setClitics(this.getLngLang());
    	this.readAbbreviations(this.getAbbreviationFile(this.getAbbriviationFolder(), this.getLngLang()));

        //insert missing blanks after punctuation
        strInput = strInput.replaceAll("\\.\\.\\."," ... ");
        strInput = strInput.replaceAll("([;\\!\\?])([^ ])","$1 $2");
            
        //replace any amount of white spaces with one space
        strInput = strInput.replaceAll("\\s+", " ");
        
        //make sure there are no leading or trailing spaces
        strInput = strInput.trim();
        
        String[] strOutput;
        //split based on whitespace
        strOutput = strInput.split(" ");

        ArrayList<String> lstTokens = new ArrayList<String>(Arrays.asList(strOutput));
        Pattern p = null;
        Matcher m = null;
        Pattern p2 = null;
        Matcher m2 = null;
        
           for (int i=0; i < lstTokens.size();i++)
           {
               
               //cut off preceding punctuation 
               p = Pattern.compile("^([" + PChar + "])(.+)");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  continue; //advance further in the loop, checking the token without preceding punctuation
               }               
               
               //cut off trailing punctuation 
               p = Pattern.compile("^(.+)([" + FChar + "])$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i--; //do not advance, the token needs to be checked without trailing punctuation
                  continue; //repeat the loop, checking the same token without trailing punctuation
               }

               //cut off trailing periods if punctuation precedes
               p = Pattern.compile("^(.+[" + FChar + "])(\\.)$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i--; //do not advance, the token needs to be checked without trailing period
                  continue; //repeat the loop, checking the same token without trailing period
               }

               //check abbreviation list
               if (hashAbbreviations.containsKey(lstTokens.get(i)))
               {
                   //known abbreviation found
                   continue;
               }

               //abbreviations of the form A. or U.S.A.
               p = Pattern.compile("^([A-Za-zÁÂÃÈý®Ð×ÝÞÍðÎÓÔÕØÙãõš›€ß‚ƒ„‡ˆ‰Š‹ŒŽøŸ÷·”“’]\\.)+$");
               m = p.matcher(lstTokens.get(i));
               if (m.find())
               {
                  continue; //leave this acronym token alone and advance the loop
               }
               
               //disambiguate periods
               p = Pattern.compile("^(.+)(\\.)$");
               m = p.matcher(lstTokens.get(i));
               p2 = Pattern.compile("^(\\.\\.\\.|[0-9]+\\.)$");
               m2 = p2.matcher(lstTokens.get(i));
               if (m.find() && !m2.find())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i++; //no need to check next token, as it is a separate period
                  continue; //advance the loop
               }

                //attempt to separate proclitics
                p = Pattern.compile("^(" + PClitic + ")(.+)$");
                m = p.matcher(lstTokens.get(i));
               if (m.find() && !PClitic.isEmpty())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  continue; //proclitic has been removed, but next token must still be checked
               }

               //attempt to separate enclitics
               p = Pattern.compile("(.+)(" + FClitic + ")$");
               m = p.matcher(lstTokens.get(i));
               if (m.find() && !FClitic.isEmpty())
               {
                  lstTokens.remove(i);
                  lstTokens.add(i, m.group(2));
                  lstTokens.add(i, m.group(1));
                  i++; //next token is a known enclitic, skip it
                  continue; //advance to get past the enclitic
               }

                   
               
           }
        
        return lstTokens;
    }
// ======================= end: important issues
}
