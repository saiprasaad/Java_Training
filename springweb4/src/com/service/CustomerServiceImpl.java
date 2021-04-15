package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerMasterDAO;
import com.dao.UserDAO;
import com.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMasterDAO customerDao;
	
	public final CustomerMasterDAO getCustomerDao() {
		return customerDao;
	}
	public final void setCustomerDao(CustomerMasterDAO customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public void registerUser(Customer customer) {
		customerDao.registerUser(customer);
	}

}
