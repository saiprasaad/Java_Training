package com.dao;


import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Users;


@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory factory;
	
	public final SessionFactory getFactory() {
		return factory;
	}
	public final void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

//@Override
//public void getAllUsers() {
//	Session session=factory.getCurrentSession();
//	Query query=session.createQuery("from Users");
//	List<Users> list=query.list();
//	for(Users user:list) {
//		System.out.println(user.getUid());
//		System.out.println(user.getFlag());
//		System.out.println(user.getUname());
//		System.out.println(user.getUpass());
//	}
//}
	
@Override
public Set<Users> getAllUserDTO() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int deleteUser(int uid) {
	Session session=factory.getCurrentSession();
    Query query = session.createQuery("DELETE from Users where uid = :uid");
    query.setInteger("uid", uid);
     int row = query.executeUpdate();
	return row;
}
@Override
public int updateUser(Users userDTO) {
	
	return 0;
}
@Override
public int insertUser(Users userDTO) {
	Session session=factory.getCurrentSession();
	session.persist(userDTO);
	return 0;
}
@Override
public Users getUserByName(String uname) {
	Session session=factory.getCurrentSession();
	Query query=session.createQuery("from Users where uname = :uname");
	query.setString("uname", uname);
	Users user = (Users) query.uniqueResult();
	return user;
}
@Override
public int getcustNo(String uname) {
	// TODO Auto-generated method stub
	return 0;
}
}
