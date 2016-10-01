package com.coders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity  
@Component
public class Users {

	@Id
	@GeneratedValue
	int id;
	String uid;
	String pwd;
	String unam;
	String email;
	
	public Users(int id, String uid, String pwd, String unam,String email) {
		this.id = id;
		this.uid = uid;
		this.pwd = pwd;
		this.unam = unam;
		this.email=email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users(){}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUnam() {
		return unam;
	}
	public void setUnam(String unam) {
		this.unam = unam;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
