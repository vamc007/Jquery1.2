package com.bankmanagement.test;

import org.junit.Before;
import org.junit.Test;

import com.bankmanagement.dao.PerformTransactionDAOImpl;
import com.bankmanagement.vo.TransactionDetailsVO;

import junit.framework.*;

public class PerformTransactionDAOImplTest {

	PerformTransactionDAOImpl impl;  
	
	@Before
	public void setup(){
		impl = new PerformTransactionDAOImpl();
	}
	
	
	@Test
	public void testUpdateTransactionDetailsMethod() {
		TransactionDetailsVO  transVO = new TransactionDetailsVO();
		transVO.setAccountBalance(1000);
		transVO.setAccountNumber(1234567890123456L);
		transVO.setTransactionDescription("Description");
		transVO.setTransactionID(1000000001);
		transVO.setTransactionType("Deposit");
		
		Assert.assertEquals(1000.0, transVO.getAccountBalance());
		
		
		
	}

}
