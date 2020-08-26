package com.cevikcozum.hr;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cevikcozum.hr.usermanagement.controller.AdminController;
import com.cevikcozum.hr.usermanagement.model.Role;
import com.cevikcozum.hr.usermanagement.model.User;

@SpringBootApplication
public class CevikCozumApplication {

	@Autowired
	private AdminController adminController;
	
	public static void main(String[] args) {
		SpringApplication.run(CevikCozumApplication.class, args);
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
