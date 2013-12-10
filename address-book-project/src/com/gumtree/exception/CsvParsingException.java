package com.gumtree.exception;

public class CsvParsingException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CsvParsingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
