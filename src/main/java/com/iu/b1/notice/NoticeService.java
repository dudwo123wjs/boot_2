package com.iu.b1.notice;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@Qualifier("") 는 AutoWired랑 매칭시킹때 사용하는 것  //같은 이름일 때 이름을 지정해서 사용하는 것
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

//---------------------------------------------------------------------------		
	public List<NoticeVO> noticeList()throws Exception{
		
		
		
		return noticeRepository.findByGreaterThanOrderByNumDesc(0);	
	}
	
	
	//---------------------------------------------------------------------------	
	
	
	
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------	
		
		
		
	//---------------------------------------------------------------------------
		
		
		
}
