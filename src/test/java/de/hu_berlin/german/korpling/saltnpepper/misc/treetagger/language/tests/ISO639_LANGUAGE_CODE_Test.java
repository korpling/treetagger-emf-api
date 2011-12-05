package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language.tests;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.language.ISO639_LANGUAGE_CODE;
import junit.framework.TestCase;

public class ISO639_LANGUAGE_CODE_Test extends TestCase 
{
	public void testValueOfByName()
	{
		assertEquals(ISO639_LANGUAGE_CODE.GER_DEU, ISO639_LANGUAGE_CODE.valueOfByName("german"));
		assertEquals(ISO639_LANGUAGE_CODE.ENG, ISO639_LANGUAGE_CODE.valueOfByName("english"));
		assertEquals(ISO639_LANGUAGE_CODE.FRE_FRA, ISO639_LANGUAGE_CODE.valueOfByName("french"));
		assertEquals(ISO639_LANGUAGE_CODE.ITA, ISO639_LANGUAGE_CODE.valueOfByName("italian"));
	}
}
