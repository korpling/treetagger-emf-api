package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.tests;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.resources.XMLUtils;

import junit.framework.TestCase;

public class XMLUtilsTests extends TestCase {

	public XMLUtilsTests(String name) {
		super(name);
	}

	public final void testIsOpeningTag() {
		assertTrue(XMLUtils.isOpeningTag("<TAG test='testVal'>"));
	}

	public final void testIsS() {
		Character x09 = new Character((char)0x09);
		Character x0A = new Character((char)0x0A);
		Character x0D = new Character((char)0x0D);
		Character x20 = new Character((char)0x20);
		
		String[] valids = {
				x09.toString(),
				x0A.toString(),
				x0D.toString(),
				x20.toString(),
				String.format("%c%c", x09, x0A),
				String.format("%c%c", x20, x09),
				String.format("%c%c", x0D, x20),
				String.format("%c%c%c%c", x09, x20, x09, x0A),
				String.format("%c%c%c%c", x0A, x0D, x20, x09),
				String.format("%c%c%c%c", x09, x09, x0D, x20)
		};
		
		String[] invalids = {
				"",
				"a",
				"_",
				"ten",
				".",
				"?"
		};
		
		for (String valid:valids) {
			if (!XMLUtils.isS(valid)) {
				fail();
			}
		};
		
		for (String invalid:invalids) {
			if(XMLUtils.isS(invalid)) {
				fail();
			}
		};
	}

	
	
	public final void testIsEq() {
		Character x09 = new Character((char)0x09);
		Character x0A = new Character((char)0x0A);
		Character x0D = new Character((char)0x0D);
		Character x20 = new Character((char)0x20);

		String[] valids = {
				"=",
				String.format("%c%c=", x09, x0A),
				String.format("%c=%c", x20, x09),
				String.format("=%c%c", x0D, x20),
				String.format("%c=%c%c%c", x09, x20, x09, x0A),
				String.format("%c%c%c=%c", x0A, x0D, x20, x09),
				String.format("=%c%c%c%c", x09, x09, x0D, x20)
		};
		
		String[] invalids = {
				" ",
				" ",
				"_",
				"t",
				".",
				"?"
		};
		
		for (String valid:valids) {
			if (!XMLUtils.isEq(valid)) {
				fail();
			}
		};
		
		for (String invalid:invalids) {
			if(XMLUtils.isEq(invalid)) {
				fail();
			}
		};
	}
	
	
	
	
	public final void testIsSTag() {
		String[] valids = {
				"<Test>",
				"<TAG test=''>",
				"<TAG test='test:test'>",
				"<TAG test=\"test\">",
		};
		
		String[] invalids = {
				"<>",
				"<TAG test='test\">",
				"<TAG test=\"test'>"
		};
		
		for (String valid:valids) {
			if (!XMLUtils.isOpeningTag(valid)) {
				fail();
			}
		};
		
		for (String invalid:invalids) {
			if(XMLUtils.isOpeningTag(invalid)) {
				fail();
			}
		};
	}
	
	
	
	public final void testGetName() {
		assertEquals("TAG", XMLUtils.getName("<TAG>"));
		assertEquals("TAG", XMLUtils.getName("<TAG >"));
		assertEquals("TAG", XMLUtils.getName("<TAG att='test'>"));
	
		assertNotSame("TAG", XMLUtils.getName("TAG att='test'>"));
	}

	
	public final void testGetAttributeValueList() {
		ArrayList<SimpleEntry<String, String>> list = XMLUtils.getAttributeValueList("<TAG test='testVal' test2='test2Val' test3=\"test3Val\"    test4='test4Val'");
		for (int i=0;i<list.size();i++) {
			SimpleEntry<String,String> entry = list.get(i);
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	public final void testGetAttributeValueTable() {
		Hashtable<String, String> table = XMLUtils.getAttributeValueTable("<TAG test='testVal' test2='test2Val' test3=\"test3Val\"    test4='test4Val'");
		for (Entry<String, String> entry : table.entrySet()) {
  		  System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
	
	
}
