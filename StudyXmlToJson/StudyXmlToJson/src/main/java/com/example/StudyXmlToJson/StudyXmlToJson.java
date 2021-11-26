package com.example.StudyXmlToJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.StudyXmlToJson.controller")
public class StudyXmlToJson {

    public static void main(String[] args) {
        SpringApplication.run(StudyXmlToJson.class, args);
    }

}
