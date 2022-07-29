package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Address;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public User saveUserDetails(User user) {
		User persistentUser = userRepo.save(user);
		return persistentUser;
	}
	
	@Override
	public List<User> getAllUserDetails() {
		return userRepo.findAll();
	}

	@Override
	public User getUserDetails(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!!!" + userId));
		return user;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg = "Deletion of User details failed.!!!!!!!!";
		
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			mesg = "User details deleted successfully , for user id : " + userId;
		}
		return mesg;
	}

	@Override
	public User updateUserDetails(User updatedUser) {
		return userRepo.save(updatedUser);
	}

	
	@Override
	public String linkAddress(Long userId, Address a) {
		User user = getUserDetails(userId);//above method
		a.setUser(user);
		addressRepo.save(a);
		return "Address Linked Successfully";
	}

	@Override
	public Address getAddress(Long id) {
		Address a = addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!"+id));
		return a;
	}
	
}
