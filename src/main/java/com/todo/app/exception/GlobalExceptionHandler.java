package com.todo.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Custom exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> resourceNotFoundException(CustomException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * Globle excpetion handler.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
