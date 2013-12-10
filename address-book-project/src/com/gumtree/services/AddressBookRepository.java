package com.gumtree.services;

import java.util.List;

import com.gumtree.entities.Person;
import com.gumtree.util.Gender;

public interface AddressBookRepository {

	public List<Person> getPeopleByGender(Gender gender);
	
	public Person getPersonByUniqueName(String name);
	
	public List<Person> getAllPeople();
}