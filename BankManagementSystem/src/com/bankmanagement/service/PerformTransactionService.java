package com.bankmanagement.service;

import java.math.BigInteger;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;

public interface PerformTransactionService {

	double updateTransactionDetails(TransactionDetailsVO detailsVO) throws BankManagementException;

	BigInteger getTransactionId();

}