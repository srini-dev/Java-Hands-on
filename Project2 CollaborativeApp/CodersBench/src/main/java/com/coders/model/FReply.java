package com.coders.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class FReply {

	@Id
	@GeneratedValue
	int rid;
	int fid;
	String rpl;
	String fusr;
	Date rdat;
	
	public FReply(){}
	
	public FReply( int fid, String rpl, String fusr, Date rdat) {
	
		
		this.fid = fid;
		this.rpl = rpl;
		this.fusr = fusr;
		this.rdat = rdat;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getRpl() {
		return rpl;
	}
	public void setRpl(String rpl) {
		this.rpl = rpl;
	}
	public String getFusr() {
		return fusr;
	}
	public void setFusr(String fusr) {
		this.fusr = fusr;
	}
	public Date getRdat() {
		return rdat;
	}
	public void setRdat(Date rdat) {
		this.rdat = rdat;
	}
}
