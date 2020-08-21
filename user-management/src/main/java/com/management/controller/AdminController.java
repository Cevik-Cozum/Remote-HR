package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.model.User;
import com.management.service.UserService;

@RestController
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/registration")
	public ResponseEntity<?> register(@RequestBody User user) {
		if (userService.findByUserName(user.getUsername()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/admin/all")
	public ResponseEntity<?> findAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	
}
