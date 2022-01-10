package com.esiea.fr.arch.you.dto;

import java.util.Date;

public class UserDto {
	
	public UserDto(String firstname, String lastname, String username, String password, String mobile, Date birthday) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.birthday = birthday;
	}
	private String firstname;
	private String lastname;
	
	private String username;
	private String password;
	
	private String mobile;
	private Date birthday;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
