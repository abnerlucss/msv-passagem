package com.example.abnerlucss.msvticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvTicketApplication.class, args);
	}

}
