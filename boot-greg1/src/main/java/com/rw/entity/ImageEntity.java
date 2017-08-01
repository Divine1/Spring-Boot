package com.rw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ImageEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	private ImageEntity() {
		super();
	}
	public ImageEntity(String name) {
		super();
		this.name = name;
	}
	public long getId() {
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
	
	
	
}
