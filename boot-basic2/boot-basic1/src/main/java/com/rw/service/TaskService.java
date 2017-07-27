package com.rw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rw.model.Task;
import com.rw.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		for (Task task : taskRepository.findAll()) {
			tasks.add(task);
		}
		return tasks;
	}

	public void save(Task task) {
		taskRepository.save(task);
	}

	public void delete(int id) {
		taskRepository.delete(id);
	}
}
