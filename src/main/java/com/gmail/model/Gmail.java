package com.gmail.model;

import org.springframework.stereotype.Component;

@Component
public class Gmail {

	String message;
	String subject;
	String to;
	String name;
	
	
	
	
	public Gmail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Gmail(String message, String subject, String to, String name) {
		super();
		this.message = message;
		this.subject = subject;
		this.to = to;
		this.name = name;
	}




	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
	
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}


	@Override
	public String toString() {
		return "Gmail [message=" + message + ", subject=" + subject + ", to=" + to + ", name=" + name + "]";
	}
	
	
	
	
}
