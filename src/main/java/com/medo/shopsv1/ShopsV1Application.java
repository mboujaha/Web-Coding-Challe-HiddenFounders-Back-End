package com.medo.shopsv1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ShopsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ShopsV1Application.class, args);
	}

}
