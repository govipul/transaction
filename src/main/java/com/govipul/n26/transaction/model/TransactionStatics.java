package com.govipul.n26.transaction.model;

public class TransactionStatics {

	private static double DEFAULT_VALUE = 0.0d;
	private double sum;
	private double avg;
	private double max;
	private double min;
	private int count;

	public TransactionStatics() {
		this.sum = DEFAULT_VALUE;
		this.avg = DEFAULT_VALUE;
		this.max = DEFAULT_VALUE;
		this.min = DEFAULT_VALUE;
		this.count = -1;
	}

	public TransactionStatics(double sum, double avg, double max, double min, int count) {
		super();
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public int getCount() {
		return count;
	}
}
