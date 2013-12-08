package com.test.gumtree.services;

import java.io.File;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.entities.Person;
import com.gumtree.util.CsvParser;

public class TestCSVParser {

	private CsvParser instance;
	
	@Before
	public void init(){
		instance = new CsvParser();
	}
	
	@Test
	public void testParseCsv_usingTestFile(){
		File csvFile = new File("");
		Map<Integer, Person> people = instance.getParser(csvFile);
		Assert.assertEquals(people.size(), 5);
		//TODO person toString equals for each person
	}
}
