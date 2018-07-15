package com.govipul.n26.transaction.model;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class TransactionError {
	private HttpStatus code;
	private String message;
	private Instant timestamp;

	public TransactionError(HttpStatus code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = Instant.now();
	}

	public TransactionError(HttpStatus code, String message, Instant timestamp) {
		this.code = code;
		this.message = message;
		this.timestamp = timestamp;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TransactionError [code=" + code + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

}
