package com.java1234.model;

public class UserTable {
	private String username;
	private String usersex;
	private String userdate;
	private String usermajor;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserdate() {
		return userdate;
	}
	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}
	public String getUsermajor() {
		return usermajor;
	}
	public void setUsermajor(String usermajor) {
		this.usermajor = usermajor;
	}
	public UserTable(String username, String usersex, String userdate, String usermajor) {
		super();
		this.username = username;
		this.usersex = usersex;
		this.userdate = userdate;
		this.usermajor = usermajor;
	}
	public UserTable() {
		super();
	}
	
}
