package com.rw.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "t_tasks")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2137333845584110197L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
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
