package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com.example.demo.repository.entity")
@SpringBootApplication(scanBasePackages = { "com.example.demo.*" })
public class LeaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveApplication.class, args);
	}

}
