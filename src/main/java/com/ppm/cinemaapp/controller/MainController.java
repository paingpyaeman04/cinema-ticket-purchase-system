package com.ppm.cinemaapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/")
public class MainController {
	
	@GetMapping
	public Map<String, Object> appInfo() {
		Map<String, Object> app = new HashMap<String, Object>();
		app.put("name", "cinema-ticket-purchase-system");
		app.put("version", "1.0");
		app.put("description", "REST API of online cinema ticket purchase system using Spring Boot, Spring Security and Spring Data JPA with MySQL database");
		return app;
	}

}
