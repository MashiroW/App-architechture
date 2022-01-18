package com.esiea.fr.arch.you.entity;

import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name ="USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="USER_ID")
	private long id;
	@Column(name ="FIRSTNAME")
	private String firstname;
	@Column(name ="LASTNAME")
	private String lastname;
	@Column(name ="USERNAME")
	private String username;
	@Column(name ="PASSWORD")
	private String password;
	@Column(name ="MOBILE")
	private String mobile;
	@Column(name ="BIRTHDAY")
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}