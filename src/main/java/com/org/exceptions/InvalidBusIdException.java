package com.org.exceptions;

public class InvalidBusIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidBusIdException(String message) {
		super(message);
	}

}
