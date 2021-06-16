package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	/*
	 * Add User
	 */
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	/*
	 * Get User details
	 */
	public User getUserDetailsByUserName(String username) throws InvalidUsernameException {
		return userRepository.findById(username).orElseThrow(() -> new InvalidUsernameException("username not found"));

	}

	/*
	 * Delete User
	 */
	@Override
	public void deleteUser(String username) throws InvalidUsernameException {
		Optional<User> findUserByusername = userRepository.findById(username);
		if (findUserByusername.isPresent()) {
			userRepository.deleteById(username);
		} else
			throw new InvalidUsernameException("Username Not Found to Delete");
	}

	/*
	 * Update User Password
	 */
	@Override
	public int updatePassword(String username, String newPassword) throws InvalidUsernameException {
		Optional<User> findBusOperatorByUsername = userRepository.findById(username);
		if (findBusOperatorByUsername.isPresent()) {
			return userRepository.updatePassoword(username, newPassword);
		} else
			throw new InvalidUsernameException("User username not exists!!");

	}

}
