package com.iu.b1.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.iu.b1.board.BoardVO;



@Entity
@Table(name = "notice")
//@Data	//setter, getter포함해서 해주는 것  // equals, hashcode도 오버라이딩 하는 기능 포함.
public class NoticeVO extends BoardVO{

	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFIlesVO> noticeFIlesVOs;
	
}
