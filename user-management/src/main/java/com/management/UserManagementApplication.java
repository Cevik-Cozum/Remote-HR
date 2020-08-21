package com.management;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.management.controller.AdminController;
import com.management.model.Role;
import com.management.model.User;

@SpringBootApplication
public class UserManagementApplication {

	@Autowired
	private AdminController adminController;

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			User admin = new User();
			admin.setName("admin");
			admin.setUsername("admin");
			admin.setPassword("admin123");
			admin.setRole(Role.ADMIN);
			adminController.register(admin);
		};
	}

}
