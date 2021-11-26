package com.example.StudyPopupApiApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.StudyPopupApiApplication.controller")
public class StudyPopupApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyPopupApiApplication.class, args);
	}

}
