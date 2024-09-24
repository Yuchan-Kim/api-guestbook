package com.javaex.vo;

public class guestbookVo {
	
	//Fields
	private int personId;
	private String name;
	private String password;
	private String comments;
	private String date;
	
	public guestbookVo() {
		
	}
	
	public guestbookVo(int personId, String name, String password, String comments, String date) {
		this.personId = personId;
		this.name = name;
		this.password = password;
		this.comments = comments;
		this.date = date;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "guestbookVo [personId=" + personId + ", name=" + name + ", password=" + password + ", comments="
				+ comments + ", date=" + date + "]";
	}
	
	
}
