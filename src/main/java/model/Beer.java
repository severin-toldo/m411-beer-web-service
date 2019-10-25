package main.java.model;

import java.text.MessageFormat;

public class Beer {
	private String id;
	private String name;
	private String description;
	private Integer styleId;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStyleId() {
		return this.styleId;
	}
	
	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("{0};{1};{2};{3};", id, name, description, styleId);
	}
}
