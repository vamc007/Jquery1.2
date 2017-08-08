package com.bankmanagement.dao;

import java.util.List;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;

public interface ViewTransactionDAO {

	List<TransactionDetailsVO> retreiveTransactionDetails(Long accountNumber, Long transactionId)
			throws BankManagementException;

}