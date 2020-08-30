package com.example.demoJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "java.com.example.demojava")
public class DemoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJavaApplication.class, args);
	}

}
