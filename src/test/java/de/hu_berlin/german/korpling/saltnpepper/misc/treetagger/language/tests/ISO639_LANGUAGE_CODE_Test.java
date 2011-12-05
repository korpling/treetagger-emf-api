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
