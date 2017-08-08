package com.bankmanagement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bankmanagement.dao.UserDetailsDAOImpl;
import com.bankmanagement.exception.BankManagementException;

public class UserDetailsDAOImplTest {

	@Test
	public void test() {
		UserDetailsDAOImpl daoImpl = new UserDetailsDAOImpl();
		try {
			daoImpl.getUserDetails(1234567890654321L);
			
			
		} catch (BankManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
