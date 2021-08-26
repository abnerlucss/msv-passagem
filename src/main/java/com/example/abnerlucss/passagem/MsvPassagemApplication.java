package com.example.abnerlucss.passagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvPassagemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvPassagemApplication.class, args);
    }

}
