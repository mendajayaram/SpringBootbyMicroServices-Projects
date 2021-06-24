package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@RefreshScope
public class EmployeeRestController {

	@Value("${my.app.title}")
	private String code;
	
	@GetMapping("/data")
	public String showData() {
		return "Hello FROM MS# " + code;
	}
}
