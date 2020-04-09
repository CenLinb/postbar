package com.chinasofti.postbar.dto;

import java.util.Date;

public class UserDto {
	String userUUID;
	String userName;
	String password;
	Date loginTime;
	String admin;

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String userUUID, String userName, String password, Date loginTime, String admin) {
		super();
		this.userUUID = userUUID;
		this.userName = userName;
		this.password = password;
		this.loginTime = loginTime;
		this.admin = admin;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "UserDto [userUUID=" + userUUID + ", userName=" + userName + ", password=" + password + ", loginTime="
				+ loginTime + ", admin=" + admin + "]";
	}

}
