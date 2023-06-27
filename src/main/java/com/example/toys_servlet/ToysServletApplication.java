package com.example.toys_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ToysServletApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToysServletApplication.class, args);
	}

}
