package com.org.test;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;
import com.org.repository.IUserRepository;
import com.org.service.IUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private IUserServiceImpl userService;

	@MockBean
	IUserRepository userRepository;

	/*
	 * Validation of addUser method
	 */
	@Test
	public void addUserValidTest() {
		User user = new User();
		user.setUsername("Vaibhav");
		user.setPassword("Vaibhav");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assertions.assertThat(userService.addUser(user)).isEqualTo(user);
	}

	/*
	 * Validation of getUserDetailsByUserName method
	 */
	@Test
	public void getUserDetailsByUserNameValidTest() {

		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("vaibhav");
		Mockito.when(userRepository.findById("vaibhav")).thenReturn(Optional.of(user));
		try {
			Assertions.assertThat(userService.getUserDetailsByUserName("vaibhav")).isEqualTo(user);
		} catch (InvalidUsernameException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Validation of deleteUserByUserName method
	 */
	@Test
	public void deleteUserByUserNameValidTest() {
		User user = new User();
		user.setUsername("Vaibhav");
		user.setPassword("Vaibhav");
		try {
			userService.deleteUser(user.getUsername());
		} catch (InvalidUsernameException e) {
			e.printStackTrace();
		}

	}
}
