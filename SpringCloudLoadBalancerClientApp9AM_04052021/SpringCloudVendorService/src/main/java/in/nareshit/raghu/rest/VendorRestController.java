package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorRestController {
	
	@Value("${server.port}")
	private String port;

	@GetMapping("/msg")
	public ResponseEntity<String> showVenMsg() {
		return ResponseEntity.ok("FROM VENDOR " + port);
	}
}
