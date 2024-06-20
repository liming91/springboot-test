package com.yb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class MySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootApplication.class, args);
    }

}
