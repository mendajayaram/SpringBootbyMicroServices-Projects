package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudCsEmployeeService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCsEmployeeService1Application.class, args);
	}

}
