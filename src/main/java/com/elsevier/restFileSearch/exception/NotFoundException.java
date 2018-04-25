package com.elsevier.restFileSearch.exception;

/**
 * NotFoundException thrown when there is NO search result for a given input  
 * @author Santosh Kumar G.
 *
 */
public class NotFoundException extends FileSearchException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
