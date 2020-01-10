package com.iu.b1.qna;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "qnafiles")
//@Data << getter, setter안되서..
public class QnaFilesVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	private String oname;
	private String fname;
	
	@ManyToOne
	@JoinColumn(name = "num")
	private QnaVO qnaVO;

	
	
	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public QnaVO getQnaVO() {
		return qnaVO;
	}

	public void setQnaVO(QnaVO qnaVO) {
		this.qnaVO = qnaVO;
	}

	
	
	
	
	
}
