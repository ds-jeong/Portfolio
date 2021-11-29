package com.example.StudyapiApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//SpringBoot는 자동 으로 주입해주지만, pakage가 자동으로 잡히지 않을땐, 아래와 같이 위치를 잡아주어야 한다.
@ComponentScan(basePackages = {"com.example.*", "com.example.StudyapiApplication"})
public class StudyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyapiApplication.class, args);
	}

}
