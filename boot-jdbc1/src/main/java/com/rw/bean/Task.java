package com.rw.bean;

import java.util.Date;

public class Task {
	private int id;
	private String name;
	private String description;
	private Date date_created;
	private boolean finished;
	
	
	
	public Task() {
		super();
	}
	public Task(String name, String description, Date date_created, boolean finished) {
		super();
		this.name = name;
		this.description = description;
		this.date_created = date_created;
		this.finished = finished;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	
}
