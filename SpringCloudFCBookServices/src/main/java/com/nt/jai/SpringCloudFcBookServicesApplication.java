package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudFcBookServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFcBookServicesApplication.class, args);
	}

}
