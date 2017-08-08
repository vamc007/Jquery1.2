package com.bankmanagement.dao;

import java.math.BigInteger;

import com.bankmanagement.vo.TransactionDetailsVO;

public interface PerformTransactionDAO {

	double updateTransactionDetails(TransactionDetailsVO detailsVO);

	BigInteger getTransactionId();

}