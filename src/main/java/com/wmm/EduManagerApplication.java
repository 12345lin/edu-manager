package com.wmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ServletComponentScan
@EnableAsync
@SpringBootApplication
public class EduManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduManagerApplication.class, args);
    }

}