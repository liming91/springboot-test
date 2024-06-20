package com.yb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@Slf4j
@EnableSwagger2WebMvc
@SpringBootApplication
@EnableScheduling
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        log.info(">>>>>>>>>>>>>>>>>> {}", SpringbootApplication.class.getSimpleName().toUpperCase() + " STARTING SUCCESS");
    }

}
