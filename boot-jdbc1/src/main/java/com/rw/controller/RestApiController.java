package com.rw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rw.bean.Task;
import com.rw.service.TaskService;

@RestController
public class RestApiController {

	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/getall")
	public List<Task> getall(){
		List<Task> tasks = null;
		tasks = taskService.getall();
		return tasks;
	}
	
	@GetMapping("/getone/{id}")
	public List<Task> getone(@PathVariable int id){
		List<Task> tasks = null;
		tasks = taskService.getone(id);
		return tasks;
	}
}
