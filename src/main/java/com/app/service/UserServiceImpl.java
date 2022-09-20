package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressRepository;
import com.app.dao.UserRepository;
import com.app.dto.AddressDTO;
import com.app.dto.AuthRequestDTO;
import com.app.dto.UserDTO;
import com.app.pojos.Address;
import com.app.pojos.Role;
import com.app.pojos.User;

@Service
@Transactional//tx mangement--->any time when there is dao layer method involment(CRUD)
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO saveUserDetails(UserDTO userDto) {
		User user = mapper.map(userDto, User.class);//DTO ---> Entity
		User persistentUser = userRepo.save(user);
	
		return mapper.map(persistentUser, UserDTO.class);
	}
	
	@Override
	public List<UserDTO> getAllUserDetails() {
		List<User> list = userRepo.findAll();
		List<UserDTO> userDtoList=new ArrayList<>();
		for(User u:list) {
			userDtoList.add(mapper.map(u, UserDTO.class));
		}
		return userDtoList;
	}

	@Override
	public UserDTO getUserDetails(Long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!!!" + userId));
		return mapper.map(user, UserDTO.class);
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
	public UserDTO updateUserDetails(UserDTO updatedUser) {
		User user = mapper.map(updatedUser, User.class);
		
		return mapper.map(userRepo.save(user), UserDTO.class);
	}

	
	@Override
	public AddressDTO linkAddress(Long userId, AddressDTO a) {
		Address address = mapper.map(a, Address.class);
		User user = userRepo.getById(userId);
				//.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!!!" + userId));
		address.setUser(user);
		return mapper.map(addressRepo.save(address), AddressDTO.class);
	}

	@Override
	public AddressDTO getAddress(Long id) {
		Address a = addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!"+id));
		return mapper.map(a, AddressDTO.class);
	}

	@Override
	public AddressDTO updateAddress(Long userId, AddressDTO updatedAddress) {
		Address adr = mapper.map(updatedAddress, Address.class);
		User user = userRepo.getById(userId);
				//.orElseThrow(() -> new ResourceNotFoundException("Invalid User id..!!!!!!" + userId));
		adr.setUser(user);
		return mapper.map(addressRepo.save(adr), AddressDTO.class);
	}

	@Override
	public UserDTO AuthenticateUser(AuthRequestDTO user) {
		User authUser = mapper.map(user, User.class);
		User authenticateduser = userRepo.authenticateUserDetails(authUser.getEmail(), authUser.getPassword());
		return mapper.map(authenticateduser, UserDTO.class);
	}

	@Override
	public List<UserDTO> getUserByRole(Role role) {
		List<User> list = userRepo.findByRole(role);
		List<UserDTO> dtoList = new ArrayList<>();
		for(User u:list) {
			dtoList.add(mapper.map(u, UserDTO.class));
		}
		return dtoList;
	}
	
}
