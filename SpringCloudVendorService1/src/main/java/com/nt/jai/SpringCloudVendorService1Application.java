package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudVendorService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVendorService1Application.class, args);
	}

}
