package com.govipul.n26.transaction.model;

public class Transaction {

	private final double amount;
	private final long timeStamp;

	public Transaction(double amount, long timeStamp) {
		super();
		this.amount = amount;
		this.timeStamp = timeStamp;
	}

	public double getAmount() {
		return amount;
	}

	public long getTimeStamp() {
		return timeStamp;
	}
}
