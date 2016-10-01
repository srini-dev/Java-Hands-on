package com.coders.model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Register {

	@Id
	private String id;
	private String Name;
	private String mailid;
	private String phono;
	private String gid;
	private String roll;
	private String pass;
	private String img;
	
	public Register(){}
	
	public Register(String id, String name, String mailid, String phono, String gid, String roll, String pass,
			String img) {
		
		this.id = id;
		Name = name;
		this.mailid = mailid;
		this.phono = phono;
		this.gid = gid;
		this.roll = roll;
		this.pass = pass;
		this.img = img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhono() {
		return phono;
	}
	public void setPhono(String phono) {
		this.phono = phono;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getRoll(){
		return roll;
	}
	public void setPos(String roll) {
		this.roll = roll;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
