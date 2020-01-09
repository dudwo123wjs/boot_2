package com.iu.b1.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "noticeFiles")
public class NoticeFIlesVO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	private String fname;
	private String oname;
	
	@ManyToOne
	@JoinColumn(name = "num")
	private NoticeVO noticeVO;

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
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

	public NoticeVO getNoticeVO() {
		return noticeVO;
	}

	public void setNoticeVO(NoticeVO noticeVO) {
		this.noticeVO = noticeVO;
	}
	
	
}
