package com.bankmanagement.exception;

public class BankManagementException extends Exception {

	private static final long serialVersionUID = 1L;

	public BankManagementException(String message) {
		super(message);
	}
	
	public BankManagementException(Throwable throwable){
		super(throwable);
	}
	
	public BankManagementException(String message, Throwable throwable){
		super(message, throwable);
	}
}
