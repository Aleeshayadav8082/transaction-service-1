package com.maveric.transactionservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionServiceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceTestApplication.class, args);
	}

}
