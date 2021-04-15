package com.dao;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Customer;

@Repository
public class CustomerMasterDAOImpl implements CustomerMasterDAO{
	@Autowired
	private SessionFactory factory;
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public int registerUser(Customer customer) {
		Session session=factory.getCurrentSession();
		session.save(customer);
		return 0;
		
	}
	@Override
	public int deleteCustomer(int custno) {
		Session session=factory.getCurrentSession();
		
		return 0;
	}
	@Override
	public int updateCustomer(Customer customerMasterDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getemail(int custno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getphone(int custno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer getCustomerMaster(int custno) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("from Customer where customerno = :customerno");
		query.setInteger("customerno", custno);
		Customer customer= (Customer) query.uniqueResult();
		return customer;
	}
	@Override
	public Set<Customer> getCustomerMasterAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
