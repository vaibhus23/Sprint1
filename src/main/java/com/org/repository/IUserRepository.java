package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.entities.User;
import com.org.exceptions.InvalidUsernameException;

/*
 * User Repository
 */
public interface IUserRepository extends JpaRepository<User, String> {

	@Query(value = "select * from User2 u where u.username=?1", nativeQuery = true)
	public User getUserDetailsByUserName(String username);

	@Query(value = "delete from User2 u where u.username=?1", nativeQuery = true)
	public void deleteUser(String username);

	@Modifying
	@Query(value = "update User u set u.password=:password where u.username=:username")
	public int updatePassoword(@Param("username") String username, @Param("password") String newPassword)
			throws InvalidUsernameException;

}
