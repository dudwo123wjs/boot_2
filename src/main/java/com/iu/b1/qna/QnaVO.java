package com.iu.b1.qna;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "qna")
//@Data << getter, setter안되서..
public class QnaVO {
//    BoardVO를 받아와도 되지만 따로함
//	  public class QnaVO extends BoardVO{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int num;
	  private String title;
	  private String writer;
	  private String contents;
	  @CreationTimestamp
	  private Date regDate;
	  private int hit;
	  
	  private int ref;
	  private int step;
	  private int depth;
	  
//}  
	  
	  @OneToMany(mappedBy = "qnaVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  private List<QnaFilesVO> qnaFilesVOs;
	    
	  
	public List<QnaFilesVO> getQnaFilesVOs() {
		return qnaFilesVOs;
	}
	public void setQnaFilesVOs(List<QnaFilesVO> qnaFilesVOs) {
		this.qnaFilesVOs = qnaFilesVOs;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	  
	  
	  
	  
	

}
