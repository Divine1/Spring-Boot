package com.rw.dao;

import java.util.List;

import com.rw.bean.Task;

public interface TaskDao {

	public List<Task> getall();
	public List<Task> getone(int id);
}
