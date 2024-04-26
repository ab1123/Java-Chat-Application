package com.dit.chatapp.dto;

public class userdto {
	private String userid;
	private char[]password;
	public userdto(String userid, char[]password) {
		this.userid=userid;
		this.password=password;
		
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	

}
