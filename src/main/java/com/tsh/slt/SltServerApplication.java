package com.tsh.slt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class SltServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SltServerApplication.class, args);
    }

}
