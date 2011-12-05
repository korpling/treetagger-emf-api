package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language.tests;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language.ISO639_LANGUAGE_CODE;
import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language.LanguageDetector;
import junit.framework.TestCase;

/**
 * Tests class {@link LanguageDetector}.
 * @author Florian Zipser
 *
 */
public class LanguageDetectorTest extends TestCase
{	
	public void testLANGUAGE_DESCRIPTION()
	{
		assertEquals(ISO639_LANGUAGE_CODE.GER_DEU, ISO639_LANGUAGE_CODE.valueOfByName("german"));
		assertEquals(ISO639_LANGUAGE_CODE.ENG, ISO639_LANGUAGE_CODE.valueOfByName("english"));
		assertEquals(ISO639_LANGUAGE_CODE.FRE_FRA, ISO639_LANGUAGE_CODE.valueOfByName("french"));
		assertEquals(ISO639_LANGUAGE_CODE.ITA, ISO639_LANGUAGE_CODE.valueOfByName("italian"));
	}
	
	public void testDetectLanguage()
	{
		String text= null;
		
		text= "The Java Text Categorizing Library (JTCL) is a pure java 1.5 implementation of libTextCat which in turn is \"a library that was primarily developed for language guessing, a task on which it is known to perform with near-perfect accuracy\".";
		assertEquals(ISO639_LANGUAGE_CODE.ENG, LanguageDetector.detectLanguage(text));
		
		text= "Die Java-Text Kategorisierung Library (JTCL) ist eine reine Java 1.5 Implementierung von libtextcat die wiederum \"eine Bibliothek, die vor allem für die Sprache zu raten, eine Aufgabe, auf denen bekannt ist, mit nahezu perfekter Genauigkeit durchzuführen ist, wurde entwickelt.\"";
		assertEquals(ISO639_LANGUAGE_CODE.GER_DEU, LanguageDetector.detectLanguage(text));
		
		text= "La bibliothèque Java Catégorisation Texte (JTCL) est un pur Java 1.5 mise en œuvre de libtextcat qui à son tour \"une bibliothèque qui a été développé pour la langue deviner Primar, une tâche sur laquelle il est connu de réaliser avec une précision quasi-parfaite.\"";
		assertEquals(ISO639_LANGUAGE_CODE.FRE_FRA, LanguageDetector.detectLanguage(text));
		
		text= "Text Library Java Categorizzare (JTCL) è un puro Java 1.5 realizzazione di libtextcat che a sua volta è \"una libreria che è stato sviluppato per la lingua indovinare Primar, un compito su cui è conosciuto per eseguire con precisione quasi perfetta.\"";
		assertEquals(ISO639_LANGUAGE_CODE.ITA, LanguageDetector.detectLanguage(text));
	}
}
