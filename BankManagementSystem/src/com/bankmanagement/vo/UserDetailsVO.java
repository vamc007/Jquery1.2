package com.bankmanagement.vo;

import org.springframework.stereotype.Component;

@Component
public class UserDetailsVO {
	private double accountBalance;
	private String accountHolderName;
	private long accountNumber;
	private String accountType;

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
