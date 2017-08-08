package com.bankmanagement.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.TransactionDetailsEntity;
import com.bankmanagement.vo.TransactionDetailsVO;

@Repository
public class PerformTransactionDAOImpl implements PerformTransactionDAO {

	private SessionFactory factory;

	private final static Logger logger = Logger.getLogger(PerformTransactionDAOImpl.class);

	public PerformTransactionDAOImpl() {
	}

	@Autowired
	public PerformTransactionDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public double updateTransactionDetails(TransactionDetailsVO detailsVO) {
		logger.info("Inside updateTransactionDetails method.");
		Session session = null;
		TransactionDetailsEntity transactionDetailsEntity = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			transactionDetailsEntity = new TransactionDetailsEntity();
			transactionDetailsEntity.setAccountBalance(detailsVO.getAccountBalance());
			transactionDetailsEntity.setAccountNumber(detailsVO.getAccountNumber());
			transactionDetailsEntity.setTransactionDescription(detailsVO.getTransactionDescription());
			transactionDetailsEntity.setTransactionID(detailsVO.getTransactionID());
			transactionDetailsEntity.setTransactionType(detailsVO.getTransactionType());
			session.save(transactionDetailsEntity);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception occured in updateTransactionDetails method - ", e);
		} finally {
			session.close();
		}

		return transactionDetailsEntity.getAccountBalance();
	}

	@Override
	public BigInteger getTransactionId() {
		logger.info("Inside getTransactionId method.");
		Session session = null;
		BigInteger lastId = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			List result = session.createSQLQuery("call GetTransactionId ()").list();
			for (int i = 0; i < result.size(); i++) {
				lastId = (BigInteger) result.get(i);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception occured in getTransactionId method - ", e);
		} finally {
			session.close();
		}
		if (lastId == null) {
			lastId = new BigInteger("1000000000");
		}
		return lastId;
	}
}
