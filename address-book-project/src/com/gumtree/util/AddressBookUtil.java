package com.gumtree.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.gumtree.entities.Person;
import com.gumtree.exception.CsvParsingException;

/**
 * Apache Commons CSV looks good though not yet released, using custom technique
 * 
 * @author Jon
 * 
 */
public class AddressBookUtil {
	
	private static final int NAME_INDEX = 0;
	private static final int GENDER_INDEX = 1;
	private static final int DOB_INDEX = 2;
	
	public static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	public static Map<Integer, Person> parseCsv(File csvFile) throws CsvParsingException {
		Map<Integer, Person> people = new HashMap<Integer, Person>();
		try {
			List<String> lines;
			Person person;
			int count = 0;
			lines = FileUtils.readLines(csvFile, "UTF-8");
			for (String line : lines) {
				count++;
				String[] fields = line.split(",");
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].trim();
				}
				person = new Person();
				person.setName(fields[NAME_INDEX]);
				person.setGender(Gender.valueOf(fields[GENDER_INDEX].toUpperCase()));
				person.setDob(formatter.parse(fields[DOB_INDEX]));
				people.put(count, person);
			}
		} catch (Exception e) {
			throw new CsvParsingException("Parsing error", e);
		}
		return people;
	}

	/**
	 * For unit testing and injection
	 * @throws CsvParsingException 
	 */
	public Map<Integer, Person> getParser(File csvFile) throws CsvParsingException {
		return parseCsv(csvFile);
	}
}
