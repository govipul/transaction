package com.govipul.n26.transaction.model;

public class Transaction {

	private double amount;
	private long timeStamp;

	public Transaction() {

	}

	public Transaction(double amount, long timeStamp) {
		this.amount = amount;
		this.timeStamp = timeStamp;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getAmount() {
		return amount;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}
}
