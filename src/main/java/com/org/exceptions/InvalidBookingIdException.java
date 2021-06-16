package com.org.exceptions;

public class InvalidBookingIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidBookingIdException(String message) {
		super(message);
	}

}
