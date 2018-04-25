package com.elsevier.restFileSearch.exception;

/**
 * 
 * Base Exception class
 * @author Santosh Kumar G.
 *
 */
public class FileSearchException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FileSearchException() {
		super();
	}
	
	public FileSearchException(String message) {
		super(message);
	}
	
	public FileSearchException(String message, Throwable cause) {
		super(message, cause);
	}
}
