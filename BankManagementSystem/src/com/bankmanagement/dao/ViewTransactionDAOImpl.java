package com.bankmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.TransactionDetailsEntity;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.TransactionDetailsVO;

@Repository
public class ViewTransactionDAOImpl implements ViewTransactionDAO {
	private SessionFactory factory;

	public ViewTransactionDAOImpl() {
	}

	@Autowired
	public ViewTransactionDAOImpl(SessionFactory factory) {
		System.out.println("factory ->"+factory);
		this.factory = factory;
	}
	
	/* (non-Javadoc)
	 * @see com.bankmanagement.dao.ViewTransactionDAO#retreiveTransactionDetails(java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<TransactionDetailsVO> retreiveTransactionDetails(Long accountNumber, Long transactionId) throws BankManagementException {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			List<TransactionDetailsEntity> transactionDetails = session
					.createQuery("FROM TransactionDetailsEntity WHERE accountNumber = :accountNumber")
					.setParameter("accountNumber", accountNumber).list();
			TransactionDetailsVO transactionVO = null;
			List<TransactionDetailsVO> list = new ArrayList<>();
			for (TransactionDetailsEntity details : transactionDetails) {
				transactionVO = new TransactionDetailsVO();
				transactionVO.setAccountBalance(details.getAccountBalance());
				transactionVO.setAccountNumber(details.getAccountNumber());
				transactionVO.setTransactionDescription(details.getTransactionDescription());
				transactionVO.setTransactionID(details.getTransactionID());
				transactionVO.setTransactionType(details.getTransactionType());
				list.add(transactionVO);
			}
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			//logger.error("Exception occured in getUserDetails method - ", e);
			throw new BankManagementException("Exception in User details DAO");
		} finally {
			System.out.println("finally");
			session.close();
		}
	}
}
