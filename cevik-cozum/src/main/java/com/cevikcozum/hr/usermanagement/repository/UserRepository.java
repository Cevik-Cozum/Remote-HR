package com.cevikcozum.hr.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import  com.cevikcozum.hr.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 
	Optional<User> findByUsername(String username);
}

