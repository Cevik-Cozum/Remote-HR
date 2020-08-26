package com.cevikcozum.hr.usermanagement.service;

import java.util.List;

import  com.cevikcozum.hr.usermanagement.model.User;

public interface UserService {

	User saveUser(User user);

	User findByUserName(String username);

	List<User> findAllUsers();

}
