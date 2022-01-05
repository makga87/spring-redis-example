package com.example.springapisample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringApiSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiSampleApplication.class, args);
    }

}
