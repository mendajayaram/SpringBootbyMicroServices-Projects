package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudCsEurekaServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCsEurekaServer1Application.class, args);
	}

}
