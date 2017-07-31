package com.rw.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.rw.bean.Task;

public class TaskRowMapper implements RowMapper<Task>{

	@Override
	public Task mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Task task = new Task();
		task.setId(rs.getInt("id"));
		task.setName(rs.getString("name"));
		task.setDescription(rs.getString("description"));
		task.setDate_created(rs.getDate("date_created"));
		task.setFinished(rs.getBoolean("finished"));
		
		
		return task;
	}

	
}
