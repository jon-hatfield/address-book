package com.test.gumtree.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.entities.Person;
import com.gumtree.services.BasicAddressBookService;

public class TestBasicAddressBookService {

	private BasicAddressBookService instance;
	
	@Before
	public void init(){
		instance = new BasicAddressBookService();
		instance.setRepository(new StubAddressBookRepository());
	}
	
	@Test
	public void testGetTotalMaleCount(){
		int count = instance.getTotalMaleCount();
		Assert.assertEquals(3, count);
	}
	
	@Test
	public void testGetOldestPerson() {
		Person oldest = instance.getOldestPerson();
		Assert.assertEquals("Wes Jackson", oldest.getName());
	}

	@Test
	public void testGetAgeDifferenceInDays() {
		//TODO failure cases and this age difference test plus implementation
		String firstPerson = "";
		String secondPerson = "";
		int days = instance.getAgeDifferenceInDays(firstPerson, secondPerson);
		Assert.assertEquals(0, days);
	}
}