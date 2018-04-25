package com.elsevier.restFileSearch.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elsevier.restFileSearch.exception.ErrorFileException;
import com.elsevier.restFileSearch.exception.NotFoundException;

@RestControllerAdvice
public class FileSearchExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e) {
		ErrorDetails errorDetails = createDefaultErrorDetails(e, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException e) {
		ErrorDetails errorDetails = createDefaultErrorDetails(e, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ErrorFileException.class)
	public ResponseEntity<ErrorDetails> handleErrorFileException(ErrorFileException e) {
		ErrorDetails errorDetails = createDefaultErrorDetails(e, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	private ErrorDetails createDefaultErrorDetails(Exception e, HttpStatus httpStatus) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorMessage(e.getMessage());

		return errorDetails;
	}

}
