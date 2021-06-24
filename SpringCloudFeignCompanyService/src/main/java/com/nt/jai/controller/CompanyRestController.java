package com.nt.jai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.jai.consumer.ProductRestConsumer;

@RestController
@RequestMapping("/company")
public class CompanyRestController {
@Autowired
private ProductRestConsumer consumer;
@GetMapping("/data")
public String findMsg() {
System.out.println(consumer.getClass().getName());
ResponseEntity<String> resp = consumer.showData();
return "FROM COMPANY =>" + resp.getBody();
}

}
