package in.nareshit.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudVendorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVendorServiceApplication.class, args);
	}

}
