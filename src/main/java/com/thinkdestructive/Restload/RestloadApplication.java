package com.thinkdestructive.Restload;

import jakarta.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration

public class RestloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestloadApplication.class, args);
	}

}
