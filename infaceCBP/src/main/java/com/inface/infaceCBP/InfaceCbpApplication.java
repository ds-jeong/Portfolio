package com.inface.infaceCBP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.inface.infaceCBP.*"})
public class InfaceCbpApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfaceCbpApplication.class, args);
	}
}
