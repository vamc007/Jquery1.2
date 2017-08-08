package com.bankmanagement.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bankmanagement.entity.UserDetailsEntity;
import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.vo.UserDetailsVO;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	private SessionFactory factory;

	private final static Logger logger = Logger.getLogger(UserDetailsDAOImpl.class);

	public UserDetailsDAOImpl() {
	}

	public UserDetailsDAOImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public UserDetailsVO getUserDetails(long accountNumber) throws BankManagementException {
		logger.info("Inside getUserDetails method.");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			List<UserDetailsEntity> detailsEntities = session
					.createQuery("FROM UserDetailsEntity WHERE accountNumber = :accountNumber")
					.setParameter("accountNumber", accountNumber).list();
			for (UserDetailsEntity details : detailsEntities) {
				if (accountNumber == details.getAccountNumber()) {
					UserDetailsVO detailsVO = new UserDetailsVO();
					detailsVO.setAccountBalance(details.getAccountBalance());
					detailsVO.setAccountHolderName(details.getAccountHolderName());
					detailsVO.setAccountNumber(details.getAccountNumber());
					detailsVO.setAccountType(details.getAccountType());
					return detailsVO;
				}
			}
			session.getTransaction().commit();
			return null;
		} catch (Exception e) {
			logger.error("Exception occured in getUserDetails method - ", e);
			throw new BankManagementException("Exception in User details DAO");
		} finally {
			session.close();
		}
		
	}

	@Override
	public void updateBalance(long accountNumber, double changeBalance) throws BankManagementException {
		logger.info("Inside updateBalance method.");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query q = session.createQuery(
					"update UserDetailsEntity set accountBalance=:accountBalance where accountNumber=:accountNumber");
			q.setDouble("accountBalance", changeBalance);
			q.setLong("accountNumber", accountNumber);
			q.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception occured in updateBalance method - ", e);
			throw new BankManagementException("Exception in User details DAO");
		} finally {
			session.close();
		}
	}
}
