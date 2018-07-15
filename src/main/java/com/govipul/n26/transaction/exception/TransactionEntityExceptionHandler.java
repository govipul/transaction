package com.govipul.n26.transaction.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.govipul.n26.transaction.model.TransactionError;

@RestControllerAdvice
public class TransactionEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionEntityExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> unknownException(Exception exception) {
		String message = "Invalid data: %s";
		TransactionError error = new TransactionError(HttpStatus.NO_CONTENT,
				String.format(message, exception.getMessage()));

		LOGGER.info(error.toString());

		return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
	}

}
