package com.org.exceptions;

public class InvalidBusNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String s;

	public InvalidBusNumberException(String message) {
		super(message);
	}
}
