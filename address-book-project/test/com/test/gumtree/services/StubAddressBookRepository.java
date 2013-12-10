package com.test.gumtree.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gumtree.entities.Person;
import com.gumtree.exception.CsvParsingException;
import com.gumtree.services.AddressBookRepository;
import com.gumtree.util.AddressBookUtil;
import com.gumtree.util.Gender;

public class StubAddressBookRepository implements AddressBookRepository{
	
	private static Map<Integer, Person> addressBook = new HashMap<Integer, Person>();
	
	static{
		try {
			addressBook = AddressBookUtil.parseCsv(new File("test/csv-files/AddressBook.csv"));
		} catch (CsvParsingException e) {
			//TODO log4j or similar
			System.out.println("Data loading error");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public List<Person> getPeopleByGender(Gender gender){
		List<Person> people = new ArrayList<Person>();
		for(Person person : getAllPeople()){
			if(person.getGender().equals(gender)){
				people.add(person);
			}
		}
		return people;
	}
	
	public Person getPersonByUniqueName(String name){
		for(Person person : getAllPeople()){
			if(person.getName().equals(name)){
				return person;
			}
		}
		//return null for now
		return null;
	}
	
	public List<Person> getAllPeople(){
		return (List<Person>) addressBook.values();
	}
}
