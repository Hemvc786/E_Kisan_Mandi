package com.app.service;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.User;

public interface IUserService {
	
		//save new user details
		User saveUserDetails(User user);
		
		//get all users
		List<User> getAllUserDetails();
		
		//get user details by specified id
		User getUserDetails(Long userId);
		
		//delete user details
		String deleteUserDetails(Long userId);
		
		//update user details
		User updateUserDetails(User updatedUser);

		//Link Address to user
		String linkAddress(Long userId,Address a);
		
		//get Address of user
		Address getAddress(Long id);
		
//		//get user from user name and password
//		Users getUser(String userName,String Password);
}
