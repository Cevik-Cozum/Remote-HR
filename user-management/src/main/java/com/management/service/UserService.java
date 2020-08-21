package com.management.service;

import java.util.List;

import com.management.model.User;

public interface UserService {

	User saveUser(User user);

	User findByUserName(String username);

	List<User> findAllUsers();

}
