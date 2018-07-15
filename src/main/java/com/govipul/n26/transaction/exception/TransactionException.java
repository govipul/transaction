package com.govipul.n26.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class TransactionException extends RuntimeException {

	private static final long serialVersionUID = 5138492748548665210L;

	public TransactionException() {
		super();
	}

	public TransactionException(String message) {
		super(message);
	}

	public TransactionException(Throwable cause) {
		super(cause);
	}

	public TransactionException(String message, Throwable cause) {
		super(message, cause);
	}
}