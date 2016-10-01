package com.coders.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class BlogMaster {

	@Id
	@GeneratedValue
	private int bid;
	private String btitle;
	private String bdy;
	@Transient
	private MultipartFile bimg;
	private Date bpostdat;
	private String busr;
	private String bsec;
	private int bcmtct;
	private int blikct;
	
	
	
	public BlogMaster() {
		
	}
	public BlogMaster(String btitle, String bdy, Date bpostdat, String busr, String bsec,
			int bcmtct, int blikct) {
		
		
		this.btitle = btitle;
		this.bdy = bdy;
		this.bpostdat = bpostdat;
		this.busr = busr;
		this.bsec = bsec;
		this.bcmtct = bcmtct;
		this.blikct = blikct;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBdy() {
		return bdy;
	}
	public void setBdy(String bdy) {
		this.bdy = bdy;
	}
	public MultipartFile getBimg() {
		return bimg;
	}
	public void setBimg(MultipartFile bimg) {
		this.bimg = bimg;
	}
	public Date getBpostdat() {
		return bpostdat;
	}
	public void setBpostdat(Date bpostdat) {
		this.bpostdat = bpostdat;
	}
	public String getBusr() {
		return busr;
	}
	public void setBusr(String busr) {
		this.busr = busr;
	}
	public String getBsec() {
		return bsec;
	}
	public void setBsec(String bsec) {
		this.bsec = bsec;
	}
	public int getBcmtct() {
		return bcmtct;
	}
	public void setBcmtct(int bcmtct) {
		this.bcmtct = bcmtct;
	}
	public int getBlikct() {
		return blikct;
	}
	public void setBlikct(int blikct) {
		this.blikct = blikct;
	}
	
	
}
