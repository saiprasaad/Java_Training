package com.dao;

import java.util.Set;

import com.model.Users;

public interface UserDAO {
	public Set<Users> getAllUserDTO();
	public int deleteUser(int uid);
	public int updateUser(Users userDTO);
	public int insertUser(Users userDTO);
	public Users getUserByName(String uname);
	public int getcustNo(String uname);
}
