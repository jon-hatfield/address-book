package com.gumtree.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.gumtree.entities.Person;
import com.gumtree.util.Gender;

public class BasicAddressBookService implements AddressBookService {
	
	private AddressBookRepository repository;

	public AddressBookRepository getRepository() {
		return repository;
	}

	//TODO use DI e.g. Spring
	/** A real repository implementation is required for production,
	 *  I would use a database. Using the CSV in the repository stub which
	 *  the JUnit test for this class is using
	 */
	
	public void setRepository(AddressBookRepository repository) {
		this.repository = repository;
	}

	@Override
	public int getTotalMaleCount() {
		List<Person> people = repository.getPeopleByGender(Gender.MALE);
		return people.size();
	}

	@Override
	public Person getOldestPerson() {
		List<Person> people = repository.getAllPeople();
		Date furthestInPast = Calendar.getInstance().getTime();
		Person oldest = new Person();
		for(Person person : people){
			if(person.getDob().before(furthestInPast)){
				furthestInPast = person.getDob();
				oldest = person;
			}
		}
		return oldest;
	}

	@Override
	public int getAgeDifferenceInDays(String firstPersonName, String secondPersonName) {
		// TODO Running out of time, spend around 2 hours
		return 0;
	}

}
