package com.moto.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.moto.service.repositorio")
public class MotoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotoServiceApplication.class, args);
    }

}
