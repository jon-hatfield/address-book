package com.test.gumtree.services;

import java.io.File;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gumtree.entities.Person;
import com.gumtree.exception.CsvParsingException;
import com.gumtree.util.AddressBookUtil;

public class TestAddressBookUtil {

	private AddressBookUtil instance;
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Before
	public void init(){
		instance = new AddressBookUtil();
	}
	
	@Test
	public void testParseCsv_usingTestFile() throws CsvParsingException{
		File csvFile = new File("test/csv-files/AddressBook.csv");
		
		Map<Integer, Person> people = instance.getParser(csvFile);
		Assert.assertEquals(people.size(), 5);
		
		Person person1 = people.get(0);
		Assert.assertEquals(person1.getName(), "Bill McKnight");
		//TODO rest of fields and test users
	}
	
	@Test
	public void testParseCsv_invalidInput() throws CsvParsingException{
		expected.expect(CsvParsingException.class);
		instance.getParser(null);
		//moving on to test the main service, then the implementations
	}
}
