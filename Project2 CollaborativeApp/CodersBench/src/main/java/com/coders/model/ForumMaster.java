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
public class ForumMaster 
{
	@Id
	@GeneratedValue
	private int fid;
	private String ftitle;
	private String fdy;
	@Transient
	private MultipartFile fimg;
	private Date fpostdat;
	private String fusr;
	private String fsec;
	private int fcmtct;
	private int flikct;
	
	
	public ForumMaster(){}
	public ForumMaster( String ftitle, String fdy, MultipartFile fimg, Date fpostdat, String fusr, String fsec,
			int fcmtct, int flikct) {

		
		this.ftitle = ftitle;
		this.fdy = fdy;
		this.fimg = fimg;
		this.fpostdat = fpostdat;
		this.fusr = fusr;
		this.fsec = fsec;
		this.fcmtct = fcmtct;
		this.flikct = flikct;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFdy() {
		return fdy;
	}
	public void setFdy(String fdy) {
		this.fdy = fdy;
	}
	public MultipartFile getFimg() {
		return fimg;
	}
	public void setFimg(MultipartFile fimg) {
		this.fimg = fimg;
	}
	public Date getFpostdat() {
		return fpostdat;
	}
	public void setFpostdat(Date fpostdat) {
		this.fpostdat = fpostdat;
	}
	public String getFusr() {
		return fusr;
	}
	public void setFusr(String fusr) {
		this.fusr = fusr;
	}
	public String getFsec() {
		return fsec;
	}
	public void setFsec(String fsec) {
		this.fsec = fsec;
	}
	public int getFcmtct() {
		return fcmtct;
	}
	public void setFcmtct(int fcmtct) {
		this.fcmtct = fcmtct;
	}
	public int getFlikct() {
		return flikct;
	}
	public void setFlikct(int flikct) {
		this.flikct = flikct;
	}

}
