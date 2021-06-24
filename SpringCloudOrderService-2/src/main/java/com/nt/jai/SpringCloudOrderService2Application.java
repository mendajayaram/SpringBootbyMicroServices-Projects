package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudOrderService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderService2Application.class, args);
	}

}
