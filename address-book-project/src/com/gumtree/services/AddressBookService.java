package com.gumtree.services;

import com.gumtree.entities.Person;

public interface AddressBookService {
	
	public int getTotalMaleCount();

	public Person getOldestPerson();
	
	public int getAgeDifferenceInDays(String firstPersonName, String secondPersonName);
}