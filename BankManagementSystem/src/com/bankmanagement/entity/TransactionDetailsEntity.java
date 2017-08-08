package com.bankmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetailsEntity {
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@Column(name="account_number")
	private long accountNumber;
	
	@Column(name ="transaction_decription")
	private String transactionDescription;
	
	@Id
	@GeneratedValue
	@Column(name="transaction_id")
	private long transactionID;
	
	@Column(name="transaction_type")
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
