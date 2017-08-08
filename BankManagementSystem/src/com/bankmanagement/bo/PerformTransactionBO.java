package com.bankmanagement.bo;

import com.bankmanagement.constant.PerformTransactionConstants;
import com.bankmanagement.vo.TransactionDetailsVO;

public class PerformTransactionBO {

	public boolean checkAmountValidation(TransactionDetailsVO detailsVO, double balance, String accountType,
			double transactionAmount) {
		if(accountType.equals(PerformTransactionConstants.SAVING) && ((balance - transactionAmount) >= 5000)){
			return true;
		}else if(accountType.equals(PerformTransactionConstants.SALARY) && ((balance - transactionAmount) >= 0)){
			return true;
		}else{
			return false;
		}
	}
}
