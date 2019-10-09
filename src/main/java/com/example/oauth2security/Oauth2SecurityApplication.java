package com.example.oauth2security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Oauth2SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SecurityApplication.class, args);
	}

}
