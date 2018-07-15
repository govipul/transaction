package com.govipul.n26.transaction.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.govipul.n26.transaction.model.Transaction;
import com.govipul.n26.transaction.model.TransactionStatics;
import com.govipul.n26.transaction.service.TransactionService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TransactionServiceImpl.class })
public class TransactionServiceImplTest {

	@Autowired
	private TransactionService service;
	private Transaction transactionTest;
	private Transaction transactionNow;

	@Before
	public void init() {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		transactionNow = new Transaction(750d, utc.toEpochSecond() * 1000);
		transactionTest = new Transaction(350d, 1531584685086L);
	}

	@Test
	public void testAddTransaction_with_age_greater_60s() {
		boolean addTransaction = service.addTransaction(transactionTest);
		assertFalse(addTransaction);
	}

	@Test
	public void testAddTransaction_with_age_now() {
		boolean addTransaction = service.addTransaction(transactionNow);
		assertTrue(addTransaction);
	}

	@Test
	public void testValidateTransaction_false() {
		boolean validateTransaction = service.validateTransaction(transactionTest);
		assertFalse(validateTransaction);
	}

	@Test
	public void testValidateTransaction_true() {
		boolean validateTransaction = service.validateTransaction(transactionNow);
		assertTrue(validateTransaction);
	}

	@Test
	public void testGetStatistics_validate_data() {
		service.addTransaction(transactionNow);
		TransactionStatics statistics = service.getStatistics();
		assertTrue(statistics.getCount() >= 1);
		assertEquals(750d, statistics.getMax(), 0);

	}

}
