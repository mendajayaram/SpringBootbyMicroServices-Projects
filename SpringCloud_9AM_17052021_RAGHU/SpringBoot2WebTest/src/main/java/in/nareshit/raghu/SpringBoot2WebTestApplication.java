package in.nareshit.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoot2WebTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2WebTestApplication.class, args);
	}

}
