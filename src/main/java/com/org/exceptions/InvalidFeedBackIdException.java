package com.org.exceptions;

public class InvalidFeedBackIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s;

	public InvalidFeedBackIdException(String message) {
		super(message);
	}

}
