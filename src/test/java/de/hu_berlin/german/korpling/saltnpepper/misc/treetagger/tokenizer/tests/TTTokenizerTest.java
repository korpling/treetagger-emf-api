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
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer.tests;

import java.io.File;
import java.util.List;
import java.util.Vector;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer.TTTokenizer;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer.TTTokenizer.TTLanguages;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer.Token;

import junit.framework.TestCase;

/**
 * 
 * Tests the class TTTokenizer.
 * @author Florian Zipser
 *
 */
public class TTTokenizerTest extends TestCase
{
	private TTTokenizer fixture= null;

	/**
	 * @param fixture the fixture to set
	 */
	public void setFixture(TTTokenizer fixture) {
		this.fixture = fixture;
	}

	/**
	 * @return the fixture
	 */
	public TTTokenizer getFixture() {
		return fixture;
	}
	
	public void setUp()
	{
		this.setFixture(new TTTokenizer());
		this.getFixture().setAbbriviationFolder(new File("./src/main/resources/abbreviations/"));
	}
	
	/**
	 * checks the following text via TokenizeToToken:
	 * "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober."
	 */
	public void testCase1()
	{
		String text= "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober.";
		List<Token> expectedToken= new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("�lpest", 4, 10));
		expectedToken.add(new Token("im", 11, 13));
		expectedToken.add(new Token("Golf", 14, 18));
		expectedToken.add(new Token("von", 19, 22));
		expectedToken.add(new Token("Mexiko", 23, 29));
		expectedToken.add(new Token("sei", 30, 33));
		expectedToken.add(new Token("eine", 34, 38));
		expectedToken.add(new Token("\"", 39, 40));
		expectedToken.add(new Token("f�rchterliche", 40, 53));
		expectedToken.add(new Token("Trag�die", 54, 62));
		expectedToken.add(new Token(",", 62, 63));
		expectedToken.add(new Token("f�r", 64, 67));
		expectedToken.add(new Token("die", 68, 71));
		expectedToken.add(new Token("ich", 72, 75));
		expectedToken.add(new Token("als", 76, 79));
		expectedToken.add(new Token("Verantwortlicher", 80, 96));
		expectedToken.add(new Token("bei", 97, 100));
		expectedToken.add(new Token("BP", 101, 103));
		expectedToken.add(new Token("immer", 104, 109));
		expectedToken.add(new Token("eine", 110, 114));
		expectedToken.add(new Token("gro�e", 115, 120));
		expectedToken.add(new Token("Verantwortung", 121, 134));
		expectedToken.add(new Token("f�hlen", 135, 141));
		expectedToken.add(new Token("werde", 142, 147));
		expectedToken.add(new Token("\"", 147, 148));
		expectedToken.add(new Token(",", 148, 149));
		expectedToken.add(new Token("erkl�rte", 150, 158));
		expectedToken.add(new Token("der", 159, 162));
		expectedToken.add(new Token("scheidende", 163, 173));
		expectedToken.add(new Token("Konzernchef", 174, 185));
		expectedToken.add(new Token("Hayward", 186, 193));
		expectedToken.add(new Token(".", 193, 194));
		expectedToken.add(new Token("BP", 195, 197));
		expectedToken.add(new Token("werde", 198, 203));
		expectedToken.add(new Token("sich", 204, 208));
		expectedToken.add(new Token("durch", 209, 214));
		expectedToken.add(new Token("den", 215, 218));
		expectedToken.add(new Token("Vorfall", 219, 226));
		expectedToken.add(new Token("ver�ndern", 227, 236));
		expectedToken.add(new Token("und", 237, 240));
		expectedToken.add(new Token("solle", 241, 246));
		expectedToken.add(new Token("unter", 247, 252));
		expectedToken.add(new Token("neuer", 253, 258));
		expectedToken.add(new Token("F�hrung", 259, 266));
		expectedToken.add(new Token("in", 267, 269));
		expectedToken.add(new Token("diese", 270, 275));
		expectedToken.add(new Token("Phase", 276, 281));
		expectedToken.add(new Token("starten", 282, 289));
		expectedToken.add(new Token(",", 289, 290));
		expectedToken.add(new Token("begr�ndete", 291, 301));
		expectedToken.add(new Token("er", 302, 304));
		expectedToken.add(new Token("seinen", 305, 311));
		expectedToken.add(new Token("R�ckzug", 312, 319));
		expectedToken.add(new Token("zum", 320, 323));
		expectedToken.add(new Token("1.", 324, 326));
		expectedToken.add(new Token("Oktober", 327, 334));
		expectedToken.add(new Token(".", 334, 335));
		
		this.getFixture().setLngLang(TTLanguages.de);
		List<Token> retTokens= this.getFixture().tokenizeToToken(text);
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
	
	
	
	/**
	 * checks the following text via TokenizeToText:
	 * "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober."
	 */
	public void testCase2()
	{
		String text= "Die �lpest im Golf von Mexiko sei eine \"f�rchterliche Trag�die, f�r die ich als Verantwortlicher bei BP immer eine gro�e Verantwortung f�hlen werde\", erkl�rte der scheidende Konzernchef Hayward. BP werde sich durch den Vorfall ver�ndern und solle unter neuer F�hrung in diese Phase starten, begr�ndete er seinen R�ckzug zum 1. Oktober.";
		List<String> expectedToken= new Vector<String>();
		expectedToken.add("Die");
		expectedToken.add("�lpest");
		expectedToken.add("im");
		expectedToken.add("Golf");
		expectedToken.add("von");
		expectedToken.add("Mexiko");
		expectedToken.add("sei");
		expectedToken.add("eine");
		expectedToken.add("\"");
		expectedToken.add("f�rchterliche");
		expectedToken.add("Trag�die");
		expectedToken.add(",");
		expectedToken.add("f�r");
		expectedToken.add("die");
		expectedToken.add("ich");
		expectedToken.add("als");
		expectedToken.add("Verantwortlicher");
		expectedToken.add("bei");
		expectedToken.add("BP");
		expectedToken.add("immer");
		expectedToken.add("eine");
		expectedToken.add("gro�e");
		expectedToken.add("Verantwortung");
		expectedToken.add("f�hlen");
		expectedToken.add("werde");
		expectedToken.add("\"");
		expectedToken.add(",");
		expectedToken.add("erkl�rte");
		expectedToken.add("der");
		expectedToken.add("scheidende");
		expectedToken.add("Konzernchef");
		expectedToken.add("Hayward");
		expectedToken.add(".");
		expectedToken.add("BP");
		expectedToken.add("werde");
		expectedToken.add("sich");
		expectedToken.add("durch");
		expectedToken.add("den");
		expectedToken.add("Vorfall");
		expectedToken.add("ver�ndern");
		expectedToken.add("und");
		expectedToken.add("solle");
		expectedToken.add("unter");
		expectedToken.add("neuer");
		expectedToken.add("F�hrung");
		expectedToken.add("in");
		expectedToken.add("diese");
		expectedToken.add("Phase");
		expectedToken.add("starten");
		expectedToken.add(",");
		expectedToken.add("begr�ndete");
		expectedToken.add("er");
		expectedToken.add("seinen");
		expectedToken.add("R�ckzug");
		expectedToken.add("zum");
		expectedToken.add("1.");
		expectedToken.add("Oktober");
		expectedToken.add(".");
		
		this.getFixture().setLngLang(TTLanguages.de);
		List<String> retTokens= this.getFixture().tokenizeToString(text);
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
	
	/**
	 * checks the following text via TokenizeToToken, tests tokenizing with starting blank
	 * " Die"
	 */
	public void testCase4()
	{
		String text= "Die �lpest";
		List<Token> expectedToken= null;
		List<Token> retTokens= null;
		
		expectedToken= new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("�lpest", 4, 10));
		this.getFixture().setLngLang(TTLanguages.de);
		retTokens= this.getFixture().tokenizeToToken(text);
		
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
	
	/**
	 * checks the following text via TokenizeToToken, tests tokenizing with starting blank
	 * " Die"
	 */
	public void testCase5()
	{
		String text= "Feigenblatt  ";
		List<Token> expectedToken= null;
		List<Token> retTokens= null;
		
		expectedToken= new Vector<Token>();
		expectedToken.add(new Token("Feigenblatt", 0, 11));
		this.getFixture().setLngLang(TTLanguages.de);
		retTokens= this.getFixture().tokenizeToToken(text);
		
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
	
	/**
	 * checks the following text via TokenizeToToken, tests tokenizing two times with same TTTokenizer object
	 * " Die"
	 */
	public void testCase6()
	{
		String text= "Die �lpest";
		List<Token> expectedToken= null;
		List<Token> retTokens= null;
		
		expectedToken= new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("�lpest", 4, 10));
		this.getFixture().setLngLang(TTLanguages.de);
		retTokens= this.getFixture().tokenizeToToken(text);
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
		
		expectedToken= new Vector<Token>();
		expectedToken.add(new Token("Die", 0, 3));
		expectedToken.add(new Token("�lpest", 4, 10));
		this.getFixture().setLngLang(TTLanguages.de);
		retTokens= this.getFixture().tokenizeToToken(text);
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
	
	/**
	 * checks the following text via TokenizeToToken:
	 * "O.K., so the answer's obvious."
	 */
	public void testCase7()
	{
		String text= "O.K., so the answer's obvious.";
		List<Token> expectedToken= new Vector<Token>();
		expectedToken.add(new Token("O.K.", 0, 4));
                expectedToken.add(new Token(",", 4, 5));
		expectedToken.add(new Token("so", 6, 8));
		expectedToken.add(new Token("the", 9, 12));
		expectedToken.add(new Token("answer", 13, 19));
		expectedToken.add(new Token("'s", 19, 21));
		expectedToken.add(new Token("obvious", 22, 29));
		expectedToken.add(new Token(".", 29, 30));
		
		this.getFixture().setLngLang(TTLanguages.en);
		List<Token> retTokens= this.getFixture().tokenizeToToken(text);
		System.out.println("retTokens: "+ retTokens);
		
		assertEquals(expectedToken.size(), retTokens.size());
		for (int i= 0; i< expectedToken.size(); i++)
		{
			assertEquals(expectedToken.get(i), retTokens.get(i));
		}
	}
}
