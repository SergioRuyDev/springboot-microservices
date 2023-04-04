package com.sergioruy.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest Apis",
				description = "Employee Service Rest Apis Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sergio Ruy",
						email = "sergioruyenator@gmail.com",
						url = "https://sergioruy.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://sergioruy.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee-Service Doc",
				url = "https://sergioruy.com"
		)
)
@SpringBootApplication
@EnableFeignClients //Find Components with Feigh Clients Annotations
//@EnableEurekaClient //In springboot 3 don't need this annotation
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
