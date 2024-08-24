package com.vaibhav.jain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class Sample {

	@GetMapping("/sample")
	public String getAll() {
	return "Sample reun";	
	}
}
