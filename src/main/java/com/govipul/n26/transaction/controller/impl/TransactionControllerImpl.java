package com.govipul.n26.transaction.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.govipul.n26.transaction.controller.TransactionController;
import com.govipul.n26.transaction.model.Transaction;
import com.govipul.n26.transaction.model.TransactionStatics;
import com.govipul.n26.transaction.service.TransactionService;

@Controller
public class TransactionControllerImpl implements TransactionController {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionControllerImpl.class);
	@Autowired
	private TransactionService service;

	@Override
	public ResponseEntity<?> addTransaction(double amount, long timeStamp) {
		LOG.info("Amount {}, Timestamp: {}", amount, timeStamp);
		if (amount > 0 && service.addTransaction(new Transaction(amount, timeStamp))) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public TransactionStatics getStatistics() {
		return service.getStatistics();
	}

}
