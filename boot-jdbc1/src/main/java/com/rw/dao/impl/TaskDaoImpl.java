package com.rw.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rw.bean.Task;
import com.rw.dao.TaskDao;
import com.rw.dao.resultsetmapper.TaskRsMapper;

import com.rw.dao.rowmapper.TaskRowMapper;

@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
/*	@Override
	public List<Task> getall() {

		Task task = new Task("name", "description", new Date(), true);
		return Arrays.asList(task);
	}
	*/
	
	
	@Override
	public List<Task> getall() {
		List<Task> tasks = null;
		String sql = "select * from t_tasks";
		tasks = jdbcTemplate.query(sql, new TaskRsMapper());
		return tasks;	
	}
	
	@Override
	public List<Task> getone(int id) {
		List<Task> tasks = null;
		String sql = "select * from t_tasks where id = (?)";
		tasks = jdbcTemplate.query(sql, new TaskRowMapper(),new Object[]{id});
		return tasks;	
	}
	
}
