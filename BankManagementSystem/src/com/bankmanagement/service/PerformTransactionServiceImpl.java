package com.bankmanagement.service;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.bo.PerformTransactionBO;
import com.bankmanagement.constant.PerformTransactionConstants;
import com.bankmanagement.dao.PerformTransactionDAO;
import com.bankmanagement.dao.UserDetailsDAO;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;

@Service
public class PerformTransactionServiceImpl implements PerformTransactionService {

	private PerformTransactionDAO performTransactionDAO;
	private UserDetailsDAO userDetailsDAO;
	private PerformTransactionBO performTransactionBO;
	private final static Logger logger = Logger.getLogger(PerformTransactionServiceImpl.class);
	
	public PerformTransactionServiceImpl(){
		
	}
	
	@Autowired
	public PerformTransactionServiceImpl(PerformTransactionDAO performTransactionDAO, UserDetailsDAO userDetailsDAO, PerformTransactionBO performTransactionBO){
		this.performTransactionDAO = performTransactionDAO;
		this.userDetailsDAO = userDetailsDAO;
		this.performTransactionBO = performTransactionBO;
	}
	
	@Override
	public double updateTransactionDetails(TransactionDetailsVO detailsVO) throws BankManagementException {
		logger.info("Inside updateTransactionDetails method.");
		double balanceAmount = 0;
		try {
			double balance = userDetailsDAO.getUserDetails(detailsVO.getAccountNumber()).getAccountBalance();
			String accountType = userDetailsDAO.getUserDetails(detailsVO.getAccountNumber()).getAccountType();
			double transactionAmount = detailsVO.getAccountBalance();
			if(detailsVO.getTransactionType().equals(PerformTransactionConstants.DEPOSIT)){
				double totalBalance = balance + transactionAmount;
				detailsVO.setAccountBalance(totalBalance);
				performTransactionDAO.updateTransactionDetails(detailsVO);
				userDetailsDAO.updateBalance(detailsVO.getAccountNumber(), totalBalance);
			}else if(detailsVO.getTransactionType().equals(PerformTransactionConstants.WITHDRAWAL)){
				if(performTransactionBO.checkAmountValidation(detailsVO, balance, accountType, transactionAmount)){
					double totalBalance = balance - transactionAmount;
					detailsVO.setAccountBalance(totalBalance);
					performTransactionDAO.updateTransactionDetails(detailsVO);
					userDetailsDAO.updateBalance(detailsVO.getAccountNumber(), totalBalance);
				}else{
					throw new BankManagementException("Cannot withdraw as minimum balance is 0");
				}				
			}else{
				logger.error("Transaction type can be either Deposit or Withdrawal.");
			}
			balanceAmount = detailsVO.getAccountBalance();
		} catch (Exception e) {
			logger.error("Exception occured in updateTransactionDetails to DAO operation - ",e);
			throw new BankManagementException("No user found with this account number "+detailsVO.getAccountNumber());
		}
		return balanceAmount;
	}

	@Override
	public BigInteger getTransactionId(){
		logger.info("Inside getTransactionId method.");
		return performTransactionDAO.getTransactionId();
	}
	
}
