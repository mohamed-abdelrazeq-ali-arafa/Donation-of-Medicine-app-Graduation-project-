package com.medicalsystem.Medical.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

//@ComponentScan(basePackageClasses = UserRestController.class)

public class MedicalServiceApplication {
	private static final Logger logger
			= LoggerFactory.getLogger(MedicalServiceApplication.class);
	public static void main(String[] args) {

		logger.info("Example log from {}", MedicalServiceApplication.class.getSimpleName());
		SpringApplication.run(MedicalServiceApplication.class, args);
	}

}
