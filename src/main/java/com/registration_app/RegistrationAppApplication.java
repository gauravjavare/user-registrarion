package com.registration_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class RegistrationAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(RegistrationAppApplication.class, args);
	}
	@Bean
  public Random random(){
		return new Random();
  }
}
