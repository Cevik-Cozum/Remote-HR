package com.management.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.jwt.JwtTokenProvider;
import com.management.model.User;
import com.management.service.UserService;

@RestController
public class UserController {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserService userService;

	
	@GetMapping("/user/login")
	public ResponseEntity<?> login(Principal principal) {
		if (principal == null) {
			return ResponseEntity.ok(principal);
		}
		UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
		User user = userService.findByUserName(authenticationToken.getName());
		user.setToken(jwtTokenProvider.generateToken(authenticationToken));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
