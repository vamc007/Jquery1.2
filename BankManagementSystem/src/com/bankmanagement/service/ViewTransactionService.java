package com.bankmanagement.service;

import java.util.List;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;

public interface ViewTransactionService {

	List<TransactionDetailsVO> retreiveTransactionDetails(Long accountNumber, Long transactionId)
			throws BankManagementException;

}