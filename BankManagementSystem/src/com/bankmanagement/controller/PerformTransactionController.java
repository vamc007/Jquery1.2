package com.bankmanagement.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.constant.PerformTransactionConstants;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.PerformTransactionService;
import com.bankmanagement.vo.TransactionDetailsVO;

/**
 * Main controller class to perform transaction. 
 * @author 420137
 *
 */
@Controller
public class PerformTransactionController {
	
	private PerformTransactionService performTransactionService;
	
	private final static Logger logger = Logger.getLogger(PerformTransactionController.class);
	
	public PerformTransactionController(){}
	
	@Autowired
	public PerformTransactionController(PerformTransactionService performTransactionService){
		this.performTransactionService = performTransactionService;
	}
	
	/**
	 * This method helps to avoid transactionID not to bind with result from form.
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(new String[]{"transactionID"});
		binder.registerCustomEditor(String.class, "accountBalance", new StringTrimmerEditor(true));
		binder.registerCustomEditor(String.class, "accountNumber", new StringTrimmerEditor(true));
	}
	
	/**
	 * This method is invoked to get transaction form.
	 * @return ModelAndView
	 */
	@RequestMapping(value="/startTransaction", method = RequestMethod.GET)
	public ModelAndView startTransaction(){
		ModelAndView modelAndView = new  ModelAndView(PerformTransactionConstants.PERFORM_TRANSACTION_JSP);
		modelAndView.addObject(PerformTransactionConstants.NEXT_TRANSACTION_ID, performTransactionService.getTransactionId());
		return modelAndView; 
	}

	/**
	 * This method is invoked when transaction form is submitted.
	 * @param detailsVO
	 * @param result
	 * @return ModelAndView
	 */
	@RequestMapping(value="/initateTransaction", method = RequestMethod.POST)
	public ModelAndView initiatetransaction(@Valid @ModelAttribute("transactionForm")TransactionDetailsVO detailsVO, BindingResult result) {
		logger.info("Inside initiatetransaction method.");
		if(result.hasErrors()){
			logger.error("Error occured while binding form values.");
			ModelAndView modelAndView = new ModelAndView(PerformTransactionConstants.PERFORM_TRANSACTION_JSP);
			modelAndView.addObject(PerformTransactionConstants.NEXT_TRANSACTION_ID, performTransactionService.getTransactionId());
			return modelAndView;
		}else{
		ModelAndView modelAndView = new ModelAndView(PerformTransactionConstants.TRANSACTION_RESULT_JSP);
		try{
		double balanceAmount = performTransactionService.updateTransactionDetails(detailsVO);
		modelAndView.addObject("trasactionMessage", "You have succefully "+detailsVO.getTransactionType()+"ed "+" amount from your account.");
		modelAndView.addObject("balanceAmount", "Your balance in account is "+balanceAmount);
		}catch (BankManagementException e) {
			logger.error("Exception occured while updating transaction details - ",e);
			modelAndView.addObject("trasactionMessage", "Exception occured why transacting !!! "+e.getMessage());
		}
		return modelAndView;
		}
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
