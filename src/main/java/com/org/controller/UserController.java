package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.service.IUserServiceImpl;

/*
 * User Controller
 */
@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserServiceImpl userService;

	/*
	 * Add User
	 */
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	/*
	 * Get User details By username
	 */
	@GetMapping("/byUserName/{username}")
	public User getUserByUserName(@PathVariable String username) throws InvalidUsernameException {
		return userService.getUserDetailsByUserName(username);
	}

	/*
	 * Delete User By username
	 */
	@DeleteMapping("/deletebyUserName/{username}")
	public void deleteByUserName(@PathVariable String username) throws InvalidUsernameException {
		userService.deleteUser(username);
	}

	/*
	 * Update Password Using username
	 */

	@PutMapping("/update/updatePassword/{username}/{newPassword}")
	public ResponseEntity<String> updatePassword(@PathVariable String username, @PathVariable String newPassword)
			throws InvalidUsernameException {
		int count = userService.updatePassword(username, newPassword);
		if (count == 1) {
			return new ResponseEntity<String>("updated Password", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not Updated", HttpStatus.OK);
		}
	}
}