package com.govipul.n26.transaction.service;

import org.springframework.stereotype.Service;

import com.govipul.n26.transaction.model.Transaction;
import com.govipul.n26.transaction.model.TransactionStatics;

@Service
public interface TransactionService {

	public boolean addTransaction(Transaction transaction);

	public TransactionStatics getStatistics();

	public boolean validateTransaction(Transaction transaction);
}
