package com.nt.jai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
@Value("${my.app.title}")
private String code;
public String showData() {
return "Hello FROM MS# " + code;
}


}
