package com.example.maxmessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MaxMessagingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxMessagingServiceApplication.class, args);

	}

}
