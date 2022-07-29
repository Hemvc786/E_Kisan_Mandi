package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
//	@Query("select Users from Users u where u.userName=?1 and u.password=?2")
//	User authenticateUserDetails(String userName,String password);

}
