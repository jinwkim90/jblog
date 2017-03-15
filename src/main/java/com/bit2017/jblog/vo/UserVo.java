package com.bit2017.jblog.vo;

import org.hibernate.validator.constraints.*;

public class UserVo {
	
	@NotEmpty
	@Length(min=5, max=10)
	private String userId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Length(min=5, max=15)
	private String password;
	private String regDate;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", password=" + password + ", regDate=" + regDate + "]";
	}
	
	
}
