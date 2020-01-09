package com.iu.b1.boardnotice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.notice.NoticeRepository;
import com.iu.b1.notice.NoticeVO;

@SpringBootTest
class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	
	
	//@Test
	void test() {
		NoticeVO noticeVO =  noticeRepository.findById(6).get();
		System.out.println(noticeVO.getWriter());
		//for(NoticeFIlesVO noticeFIlesVO: noticeVO.ge)
				
	}

}
