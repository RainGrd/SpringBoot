package com.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot12HotDeployApplication {

    public static void main(String[] args) {
        System.getProperty("spring.devtools.restart.enable","false");
        SpringApplication.run(Springboot12HotDeployApplication.class, args);
    }

}
