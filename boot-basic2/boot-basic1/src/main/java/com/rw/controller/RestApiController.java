package com.rw.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rw.model.Task;
import com.rw.service.TaskService;

@RestController
public class RestApiController {

	@Autowired
	TaskService taskService;

	@GetMapping("/test")
	public String rest() {
		return "rest controller test";
	}

	@GetMapping("/showall")
	public List<Task> showAll() {

		return taskService.findAll();
	}

	@GetMapping("/save")
	public String save(@RequestParam String name, @RequestParam String description) {
		Task task = new Task(name, description, new Date(), true);
		taskService.save(task);
		return "task saved";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		taskService.delete(id);
		return "task deleted";
	}

}
