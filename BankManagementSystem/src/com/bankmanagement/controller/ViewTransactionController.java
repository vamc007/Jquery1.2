package com.bankmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.constant.PerformTransactionConstants;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.ViewTransactionService;
import com.bankmanagement.vo.TransactionDetailsVO;

@RestController
public class ViewTransactionController {

	private ViewTransactionService viewTransactionService;
	public ViewTransactionController(){}
	@Autowired
	public ViewTransactionController(ViewTransactionService viewTransactionService){
		this.viewTransactionService = viewTransactionService;
	}
	/**
	 * Method to initiate view transaction
	 * @return
	 */
	@RequestMapping(value="/startViewTransaction", method=RequestMethod.GET)
	public ModelAndView initiateViewTransaction(){
		ModelAndView modelAndView = new ModelAndView("Viewtransaction");
		return modelAndView;
	}
	
	/**
	 * Method for search user transaction
	 * @param accountNumber
	 * @param transactionId
	 * @return
	 * @throws BankManagementException 
	 */
	@RequestMapping(value = "viewTransaction", method = RequestMethod.GET, produces = "application/json")
	public List<TransactionDetailsVO> searchUserTransaction(@RequestParam("accountNumber")Long accountNumber, @RequestParam("transactionId") Long transactionId) throws BankManagementException{
		return viewTransactionService.retreiveTransactionDetails(accountNumber, transactionId);
	}
	
	/**
	 * Common method to provide header for all JSP's
	 * @param model
	 */
	@ModelAttribute()
	public void addObject(Model model){
		model.addAttribute(PerformTransactionConstants.HEADER_TEXT, PerformTransactionConstants.HEADER_TITLE);		
	}
}
