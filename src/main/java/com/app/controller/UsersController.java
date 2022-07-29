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

import com.app.pojos.Address;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController 
@RequestMapping("/api/user")
@Validated
@CrossOrigin
public class UsersController {
	
	@Autowired
	private IUserService userService;
	
//	@GetMapping("/login")
//	public String authenticateUser(@RequestBody String userName,@RequestBody String pass) {
//		userService.getUser(userName, pass);
//		return null;
//	}
	
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>( userService.saveUserDetails(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> listAllUsers(){
		 List<User> list = userService.getAllUserDetails();
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
	public User updateUser(@RequestBody @Valid User user) {
		return userService.updateUserDetails(user);
	}
	
	@PostMapping("/{id}/address")
	public ResponseEntity<String> LinkUserAddress(@PathVariable Long id,@RequestBody Address a) {
		return new ResponseEntity<>(userService.linkAddress(id, a),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}/address")
	public ResponseEntity<?> getUserAddress(@PathVariable Long id) {
			return ResponseEntity.ok(userService.getAddress(id));	
	}
	

}
