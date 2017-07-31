package com.rw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rw.bean.Task;
import com.rw.dao.TaskDao;

@Service
public class TaskService {

	@Autowired
	TaskDao taskDao;
	
	
	public List<Task> getall(){
		return taskDao.getall();
	}
	
	public List<Task> getone(int id){
		return taskDao.getone(id);
	}
	
}
