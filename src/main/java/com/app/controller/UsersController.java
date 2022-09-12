package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.pojos.Address;
import com.app.service.IUserService;

@RestController 
@RequestMapping("/api/user")
@Validated
@CrossOrigin
public class UsersController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUserRequest(@RequestBody String email,@RequestBody String pass) {
		UserDTO authenticatedUser = userService.AuthenticateUser(email, pass);
		if(authenticatedUser == null) {
			return new ResponseEntity<>("Invalid User Details", HttpStatus.OK);
		}
		return new ResponseEntity<>(authenticatedUser,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO user) {
		return new ResponseEntity<>( userService.saveUserDetails(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> listAllUsers(){
		 List<UserDTO> list = userService.getAllUserDetails();
		 if(list.isEmpty())
				return ResponseEntity.ok("Empty List...!!!!");
		 		//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id) {
			return ResponseEntity.ok(userService.getUserDetails(id));	
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUserDetails(id);
	}
	
	@PutMapping
	public UserDTO updateUser(@RequestBody @Valid UserDTO user) {
		return userService.updateUserDetails(user);
	}
	
	@PostMapping("/{id}/address")
	public ResponseEntity<String> linkUserAddress(@PathVariable Long id,@RequestBody Address a) {
		return new ResponseEntity<>(userService.linkAddress(id, a),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}/address")
	public ResponseEntity<?> getUserAddress(@PathVariable Long id) {
			return ResponseEntity.ok(userService.getAddress(id));	
	}
	
	@PutMapping("/{id}/address")
	public ResponseEntity<Address> updateUserAddress(@PathVariable Long id,@RequestBody Address a) {
		return new ResponseEntity<>(userService.updateAddress(id, a),HttpStatus.CREATED);
		
	}

}
