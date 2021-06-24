package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudFeignEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignEurekaServerApplication.class, args);
	}

}
