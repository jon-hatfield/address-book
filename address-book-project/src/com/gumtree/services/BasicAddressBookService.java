package com.gumtree.services;

import com.gumtree.entities.Person;
import com.test.gumtree.services.StubAddressBookRepository;

public class BasicAddressBookService implements AddressBookService {
	
	private AddressBookRepository repository;

	public AddressBookRepository getRepository() {
		return repository;
	}

	//TODO use DI e.g. Spring
	public void setRepository(AddressBookRepository repository) {
		this.repository = repository;
	}

	@Override
	public int getTotalMaleCount() {
		return 0;
	}

	@Override
	public Person getOldestPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAgeDifferenceInDays(String firstPersonName, String secondPersonName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
