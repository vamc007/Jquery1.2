package com.bankmanagement.dao;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.UserDetailsVO;

public interface UserDetailsDAO {

	UserDetailsVO getUserDetails(long accountNumber) throws BankManagementException;

	void updateBalance(long accountNumber, double changeBalance) throws BankManagementException;

}