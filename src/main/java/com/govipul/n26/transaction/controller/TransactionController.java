package com.govipul.n26.transaction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.govipul.n26.transaction.model.Transaction;
import com.govipul.n26.transaction.model.TransactionStatics;
import com.govipul.n26.transaction.service.TransactionService;

@RestController
public class TransactionController {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TransactionService service;

	@PostMapping(value = "/transactions")
	public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
		LOG.info("Amount {}, Timestamp: {}", transaction.getAmount(), transaction.getTimeStamp());
		if (transaction.getAmount() > 0 && service.addTransaction(transaction)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/statistics")
	@ResponseBody
	public TransactionStatics getStatistics() {
		return service.getStatistics();
	}

}
