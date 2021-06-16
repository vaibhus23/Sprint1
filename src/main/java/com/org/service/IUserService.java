package com.org.service;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;

public interface IUserService {
	
	public User addUser(User user);

	public void deleteUser(String username)throws InvalidUsernameException;

	public int updatePassword(String username, String newPassword) throws InvalidUsernameException;

	public User getUserDetailsByUserName(String Username) throws InvalidUsernameException;

	
}
