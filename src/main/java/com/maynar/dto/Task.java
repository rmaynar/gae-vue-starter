package com.maynar.dto;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Task {
	@Id
	private String id;
	private String description;
	public Task(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Task() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
