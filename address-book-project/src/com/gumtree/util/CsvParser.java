package com.gumtree.util;

import java.io.File;
import java.util.Map;

import com.gumtree.entities.Person;

/**
 * Apache Commons CSV looks good though not yet released, using custom technique
 * @author Jon
 *
 */
public class CsvParser {

	public static Map<Integer, Person> parseCsv(File csvFile){
		return null;
	}
	
	/**
	 * For unit testing and injection
	 * @param csvFile
	 * @return
	 */
	public Map<Integer, Person> getParser(File csvFile){
		return parseCsv(csvFile);
	}
}
