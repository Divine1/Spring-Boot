package com.rw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
	
	@GetMapping("/test")
	public String rest(){
		return "rest controller test";
	}
}
