package com.govipul.n26.transaction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.govipul.n26.transaction.model.TransactionStatics;

@RestController
public interface TransactionController {

	@PostMapping("/api/transactions")
	public ResponseEntity<?> addTransaction(@RequestParam(value = "amount") double amount,
			@RequestParam(value = "timeStamp") long timeStamp);

	@GetMapping("/api/statistics")
	@ResponseBody
	public TransactionStatics getStatistics();
}
