package com.bankmanagement.vo;



import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class TransactionDetailsVO {
	
	@NotNull(message="Account balance can't be empty")
	private double accountBalance;
	
	@NotNull(message="Account number can't be empty")
	private long accountNumber;
	
	@NotEmpty(message="Transaction description cannot be empty")
	private String transactionDescription;
	
	private long transactionID;
	
	@NotEmpty(message="Transaction type cannot be empty")
	private String transactionType;

	public double getAccountBalance() {
		return accountBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
