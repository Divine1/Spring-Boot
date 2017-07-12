package com.rw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/getsports")
	public List<String> getSports(){
		List<String> sports = new ArrayList<>();
		sports.add("cricket");
		sports.add("football");
		
		return sports;
	}
}
