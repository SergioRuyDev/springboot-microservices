package com.sergioruy.organizationservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient Don't need in Springboot 3.
public class OrganizationServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServicesApplication.class, args);
	}

}
