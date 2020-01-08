package com.iu.b1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	
	
	
	
	
//---------------------------------------------------------------------------		
	public List<NoticeVO> boardList(NoticeVO noticeVO)throws Exception{
		
		
		return noticeRepository.findAll();
		
	}
	
	
	
	
	
	
	
	
	
	
}
