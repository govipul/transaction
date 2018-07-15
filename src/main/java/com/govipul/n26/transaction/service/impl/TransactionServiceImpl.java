package com.govipul.n26.transaction.service.impl;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.stereotype.Service;

import com.govipul.n26.transaction.model.Transaction;
import com.govipul.n26.transaction.model.TransactionStatics;
import com.govipul.n26.transaction.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final List<Transaction> TRANSACTION_LIST = new ArrayList<>();
	private static final double DEFAULT_VALUE = 0.0d;
	private static final Long ONE_MINUTE_IN_MILLIS = 60 * 1000L;

	@Override
	public boolean addTransaction(Transaction transaction) {
		boolean isAdded = false;
		if (transaction != null && validateTransaction(transaction)) {
			TRANSACTION_LIST.add(transaction);
			isAdded = true;
		}
		return isAdded;
	}

	@Override
	public TransactionStatics getStatistics() {
		TransactionStatics statics = new TransactionStatics();
		if (!TRANSACTION_LIST.isEmpty()) {
			double sum = TRANSACTION_LIST.stream().filter(transaction -> validateTransaction(transaction))
					.mapToDouble(transaction -> transaction.getAmount()).sum();
			OptionalDouble avg = TRANSACTION_LIST.stream().filter(transaction -> validateTransaction(transaction))
					.mapToDouble(transaction -> transaction.getAmount()).average();
			OptionalDouble max = TRANSACTION_LIST.stream().filter(transaction -> validateTransaction(transaction))
					.mapToDouble(transaction -> transaction.getAmount()).max();
			OptionalDouble min = TRANSACTION_LIST.stream().filter(transaction -> validateTransaction(transaction))
					.mapToDouble(transaction -> transaction.getAmount()).min();
			long size = TRANSACTION_LIST.stream().filter(transaction -> validateTransaction(transaction)).count();

			statics = new TransactionStatics(sum, avg.isPresent() ? avg.getAsDouble() : DEFAULT_VALUE,
					max.isPresent() ? max.getAsDouble() : DEFAULT_VALUE,
					min.isPresent() ? min.getAsDouble() : DEFAULT_VALUE, (int) size);
		}
		return statics;
	}

	@Override
	public boolean validateTransaction(Transaction transaction) {
		long epochInMillis = ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond() * 1000;
		return (epochInMillis - transaction.getTimeStamp()) <= ONE_MINUTE_IN_MILLIS;
	}
}
