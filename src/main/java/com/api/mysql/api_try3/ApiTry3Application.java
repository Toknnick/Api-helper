package com.api.mysql.api_try3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiTry3Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiTry3Application.class, args);
    }

}
