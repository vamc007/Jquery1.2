package com.bankmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.dao.ViewTransactionDAO;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;
@Service
public class ViewTransactionServiceImpl implements ViewTransactionService {

	private ViewTransactionDAO viewTransactionDAO;
	
	public ViewTransactionServiceImpl(){
		
	}
	
	@Autowired
	public ViewTransactionServiceImpl(ViewTransactionDAO viewTransactionDAO){
		this.viewTransactionDAO = viewTransactionDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.bankmanagement.service.ViewTransactionService#retreiveTransactionDetails(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<TransactionDetailsVO> retreiveTransactionDetails(Long accountNumber, Long transactionId) throws BankManagementException {
		return viewTransactionDAO.retreiveTransactionDetails(accountNumber, transactionId);
	}
}
