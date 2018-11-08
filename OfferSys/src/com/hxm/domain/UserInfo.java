package com.hxm.domain;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private String userName;
	private String passWord;
	private String permissions;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String userName, String passWord, String permissions) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.permissions = permissions;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", passWord=" + passWord
				+ ", permissions=" + permissions + "]";
	}	
}
