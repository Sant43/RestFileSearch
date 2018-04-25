/**
 * 
 */
package com.elsevier.restFileSearch.exception;

/**
 * Error File exception thrown when there is an issue in accessing the File.
 * @author Santosh Kumar G.
 *
 */
public class ErrorFileException extends FileSearchException {
	
	private static final long serialVersionUID = 1L;

	public ErrorFileException() {
		super();
	}
	
	public ErrorFileException(String message) {
		super(message);
	}
	
	public ErrorFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
