package com.app.service;

import java.util.List;

import com.app.dto.UserDTO;
import com.app.pojos.Address;

public interface IUserService {
	
		//save new user details
		UserDTO saveUserDetails(UserDTO user);
		
		//get all users
		List<UserDTO> getAllUserDetails();
		
		//get user details by specified id
		UserDTO getUserDetails(Long userId);
		
		//delete user details
		String deleteUserDetails(Long userId);
		
		//update user details
		UserDTO updateUserDetails(UserDTO updatedUser);

		//Link Address to user
		String linkAddress(Long userId,Address a);
		
		//get Address of user
		Address getAddress(Long id);
		
		//update address
		Address updateAddress(Long userId, Address updatedAddress);
		
//		//get user from user name and password
//		Users getUser(String userName,String Password);
}
