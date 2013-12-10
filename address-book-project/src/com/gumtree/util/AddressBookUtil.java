package com.gumtree.util;

import java.io.File;
import java.io.IOException;
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

	public static Map<Integer, Person> parseCsv(File csvFile) throws CsvParsingException {
		List<String> lines;
		try {
			lines = FileUtils.readLines(csvFile, "UTF-8");
			for (String line : lines) {
				String[] fields = line.split(",");
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].trim();
				}
				
			}
		} catch (IOException e) {
			throw new CsvParsingException();
		}
		return null;
	}

	/**
	 * For unit testing and injection
	 * @throws CsvParsingException 
	 */
	public Map<Integer, Person> getParser(File csvFile) throws CsvParsingException {
		return parseCsv(csvFile);
	}
}
