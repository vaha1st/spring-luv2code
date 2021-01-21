package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName",
															Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer
		currentSession.saveOrUpdate(customer);
		
		
	}

	@Override
	public Customer getCustomer(int theID) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Get cutomer with id
		Customer theCustomer = currentSession.get(Customer.class, theID);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theID) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get and delete the customer
//		Customer theCustomer = currentSession.get(Customer.class, theID);
//		currentSession.delete(theCustomer);
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theID);
		
		// update the delete
		theQuery.executeUpdate();
	}
	
	
	
	

}
