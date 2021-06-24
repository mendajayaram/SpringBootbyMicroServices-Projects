package com.nt.jai.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {
@Value("${server.port}")
public String port;
@GetMapping("/msg")
public ResponseEntity<String> showData(){
	return ResponseEntity.ok("FROM PRODUCT " + port);
}

}