package com.rw.dao.resultsetmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.rw.bean.Task;


public class TaskRsMapper implements ResultSetExtractor<List<Task>>{

	@Override
	public List<Task> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Task> tasks = new ArrayList<Task>();
		Task task = null;
		while(rs.next()){
			task = new Task();
			task.setId(rs.getInt("id"));
			task.setName(rs.getString("name"));
			tasks.add(task);
		}
		
		
		return tasks;
	}

}
