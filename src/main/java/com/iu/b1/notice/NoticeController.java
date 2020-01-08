package com.iu.b1.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
//---------------------------------------------------------------------------
	
	public ModelAndView boardList(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVO> ar = noticeService.boardList(noticeVO);
		
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");
		
		
		
		return mv;
	}
	
	
}
