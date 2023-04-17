package com.medicalsystem.Medical.service;

import com.medicalsystem.Medical.service.restcontroller.UserRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@ComponentScan(basePackageClasses = UserRestController.class)

public class MedicalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalServiceApplication.class, args);
	}
}
