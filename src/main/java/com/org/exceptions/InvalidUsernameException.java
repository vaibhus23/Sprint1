package com.org.exceptions;

public class InvalidUsernameException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidUsernameException(String message) {
		super(message);
	}

}
