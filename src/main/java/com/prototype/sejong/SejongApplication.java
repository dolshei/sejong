package com.prototype.sejong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SejongApplication {

    public static void main(String[] args) {
        SpringApplication.run(SejongApplication.class, args);
    }

}
