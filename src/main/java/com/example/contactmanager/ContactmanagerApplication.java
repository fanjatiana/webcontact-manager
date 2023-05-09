package com.example.contactmanager;

import com.example.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactmanagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
	}

	@Autowired
	UserService userService;
	@Override
	public void run(String... args) throws Exception {
		userService.addUser();
	}
}
