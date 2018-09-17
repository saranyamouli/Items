package io.javabrains.springbootstarter.items;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {

	private String id;
	private LocalDateTime dateTime;
	public Item() {
		
	}
	public Item(String id, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.dateTime = dateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
