package com.rw.repository;

import org.springframework.data.repository.CrudRepository;

import com.rw.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
