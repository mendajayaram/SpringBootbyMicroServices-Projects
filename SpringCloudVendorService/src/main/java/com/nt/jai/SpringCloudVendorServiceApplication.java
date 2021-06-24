package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudVendorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVendorServiceApplication.class, args);
	}

}
