package com.java1234.model;

/**
 * @author Chris
 *
 */
public class User {
	private int id;
	private String username;
	private String password;
	
	
	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	

	public String getUsername() {
		return username;
	}
	public String getPassword() {
			return password;
	}
	public int getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}

}
