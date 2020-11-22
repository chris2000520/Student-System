package com.java1234.model;
/*
 * 图书类别实体
 */
public class WorkType {
	private String wname;
	private String wpost;
	private String waddress;
	
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWpost() {
		return wpost;
	}
	public void setWpost(String wpost) {
		this.wpost = wpost;
	}
	public String getWaddress() {
		return waddress;
	}
	public void setWaddress(String waddress) {
		this.waddress = waddress;
	}
	public WorkType(String wname, String waddress, String wpost) {
		super();
		this.wname = wname;
		this.wpost = wpost;
		this.waddress = waddress;
	}
	public WorkType() {
		super();
	}
}
