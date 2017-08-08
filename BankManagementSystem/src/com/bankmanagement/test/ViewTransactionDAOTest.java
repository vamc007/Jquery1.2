package com.bankmanagement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bankmanagement.dao.ViewTransactionDAO;
import com.bankmanagement.dao.ViewTransactionDAOImpl;
import com.bankmanagement.exception.BankManagementException;

public class ViewTransactionDAOTest {

	@Test
	public void test() throws BankManagementException {
		ViewTransactionDAO dao = new ViewTransactionDAOImpl();
		dao.retreiveTransactionDetails(1234567890654321L, 1000000050L);
	}

}
