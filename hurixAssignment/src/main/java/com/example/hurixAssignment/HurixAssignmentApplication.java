package com.example.hurixAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HurixAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(HurixAssignmentApplication.class, args);
    }

}
