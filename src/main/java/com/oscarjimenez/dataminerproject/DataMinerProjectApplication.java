package com.oscarjimenez.dataminerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataMinerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMinerProjectApplication.class, args);
	}

}
