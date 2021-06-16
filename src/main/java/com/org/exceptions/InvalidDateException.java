package com.org.exceptions;

public class InvalidDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidDateException(String message) {
		super(message);
	}
}
