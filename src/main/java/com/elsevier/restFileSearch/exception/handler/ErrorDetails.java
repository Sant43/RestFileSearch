package com.elsevier.restFileSearch.exception.handler;

/**
 * Error Message returned to REST client.
 *
 * @author Santosh Kumar G.
 */
public class ErrorDetails {

	private String errorMessage;

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
