package com.dao;

import java.util.Set;

import com.model.Customer;

public interface CustomerMasterDAO {
	public int registerUser(Customer customer);
	public int deleteCustomer(int custno);
	public int updateCustomer(Customer customerMasterDTO);
	public String getemail(int custno);
	public String getphone(int custno);
	public Customer getCustomerMaster(int custno);
	public Set<Customer> getCustomerMasterAll();

}
