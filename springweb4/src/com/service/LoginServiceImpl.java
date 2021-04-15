package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.Users;


@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserDAO userDao;
	
	public final UserDAO getUserDao() {
		return userDao;
	}
	public final void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
@Override
public void createUser(Users user) {
	userDao.insertUser(user);
}

@Override
public boolean checkUser(String uname, String upass) {
	Users userDTO =userDao.getUserByName(uname);
	if(userDTO!=null) {
		if(userDTO.getUpass().equalsIgnoreCase(upass)) {
			return true;
		}
		return false;
	}
	return false;
}
@Override
public boolean checkFlag(String uname) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public int updateFlag(String uname, int flag) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int registerUser(Users user) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public Users getUserByUName(String uname) {
	return userDao.getUserByName(uname);
}
}
