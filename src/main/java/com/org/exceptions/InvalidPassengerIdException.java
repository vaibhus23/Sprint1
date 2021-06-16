package com.org.exceptions;

public class InvalidPassengerIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidPassengerIdException(String message) {
		super(message);
	}

}
