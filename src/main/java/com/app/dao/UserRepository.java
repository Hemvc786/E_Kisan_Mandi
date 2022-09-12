package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	User authenticateUserDetails(String email,String password);

}
