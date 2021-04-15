package com.service;

import com.model.Users;

import com.model.Users;

public interface LoginService {
	public void createUser(Users user);
	public boolean checkUser(String uname,String upass);
	public boolean checkFlag(String uname);
	public int updateFlag(String uname,int flag);
	public int registerUser(Users user);
	
	
	
	public Users getUserByUName(String uname);
}
