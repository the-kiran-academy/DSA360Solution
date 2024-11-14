package com.dsa360.api.daoimpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dsa360.api.dao.CustomerDao;
import com.dsa360.api.dto.DocumentDTO;
import com.dsa360.api.entity.CustomerEntity;
import com.dsa360.api.entity.DocumentEntity;
import com.dsa360.api.entity.LoanApplicationEntity;
import com.dsa360.api.exceptions.SomethingWentWrongException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createCustomer(CustomerEntity customerEntity) {

		try (Session session = sessionFactory.openSession()) {
			session.save(customerEntity);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during create customer for {} ", customerEntity.getId());
			throw new SomethingWentWrongException(
					"Exception occurred during create customer for " + customerEntity.getId());
		}
	}

	@Override
	public String checkLoanEligibility(String customerId) {

		return null;
	}

	@Override
	public void customerLoanApplication(LoanApplicationEntity loanApplicationEntity) {

		try (Session session = sessionFactory.openSession()) {
			session.save(loanApplicationEntity);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during loan application for loan ID {} ", loanApplicationEntity.getId());
			throw new SomethingWentWrongException(
					"Exception occurred during loan application for loan Id " + loanApplicationEntity.getId());
		}
	}

	@Override
	public void uploadDocument(String customerId, DocumentEntity documentEntity) {
		try (Session session = sessionFactory.openSession()) {
			session.save(documentEntity);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during upload customer document {}", customerId);
			throw new SomethingWentWrongException("Exception occurred during upload customer document " + customerId);
		}

	}

	@Override
	public List<CustomerEntity> getAllCustomers() {

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerEntity getCustomerById(String id) {
		try {
			String hql = "SELECT c FROM CustomerEntity c " + "LEFT JOIN FETCH c.loanApplications "
					+ "LEFT JOIN FETCH c.documents " + "WHERE c.id = :id";

			Session session = sessionFactory.getCurrentSession();
			Query<CustomerEntity> query = session.createQuery(hql, CustomerEntity.class);
			query.setParameter("id", id);

			return query.uniqueResult();
		} catch (

		Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during load customer data {}", id);
			throw new SomethingWentWrongException("Exception occurred during load customer data " + id);
		}

	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

		return null;
	}

	@Override
	public void cancelCustomerLoanApplication(String id) {

	}

	@Override
	public List<DocumentDTO> getDocumentsByCustomerId(String customerId) {

		return null;
	}

	@Override
	public DocumentDTO getDocumentById(String customerId, String documentId) {

		return null;
	}

	@Override
	public void deleteDocument(String customerId, String documentId) {

	}

}
