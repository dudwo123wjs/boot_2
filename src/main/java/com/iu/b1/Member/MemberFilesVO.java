package com.iu.b1.Member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberFiles")
public class MemberFilesVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	private String id;
	private String fname;
	private String oname;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	
}
