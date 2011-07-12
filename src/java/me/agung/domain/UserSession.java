package me.agung.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserSession implements Serializable
{		
	public static final String sessionName = "UserSession";
	
	private String name;
			
	public UserSession(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}