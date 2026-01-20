package com.hpe.hpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
		System.out.println("application started:" +"locahost:8080/");
	}

}
