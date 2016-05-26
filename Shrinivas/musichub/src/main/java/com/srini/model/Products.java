package com.srini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Products {

	@Id
	public String pid;
	
	public String pnm;
	public String pdis;
	public double pprc;
	public Products(){System.out.println("In Product non-org Constroctor");}
	public Products(String pid, String pnm, String pdis, double pprc) {
		super();
		this.pid = pid;
		this.pnm = pnm;
		this.pdis = pdis;
		this.pprc = pprc;
		System.out.println("In Product org Constroctor");
	}
	
	public String getPid() {
		return pid;
	}
	public String getPnm() {
		return pnm;
	}
	public String getPdis() {
		return pdis;
	}
	public double getPprc() {
		return pprc;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public void setPdis(String pdis) {
		this.pdis = pdis;
	}
	public void setPprc(double pprc) {
		this.pprc = pprc;
	}
}
