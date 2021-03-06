package com.cevikcozum.hr.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevikcozum.hr.usermanagement.model.User;
import  com.cevikcozum.hr.usermanagement.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username).orElse(null);
	}
	
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
}
