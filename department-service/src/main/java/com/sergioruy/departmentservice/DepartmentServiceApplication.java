package com.sergioruy.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest Apis",
				description = "Department Service Rest Apis Documentation",
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
				description = "Department-Service Doc",
				url = "https://sergioruy.com"
		)
)
@SpringBootApplication
//@EnableEurekaClient //In Springboot 3 don't need this annotation
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
