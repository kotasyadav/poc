package com.src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConverFactor1Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverFactor1Application.class, args);
	}

}
