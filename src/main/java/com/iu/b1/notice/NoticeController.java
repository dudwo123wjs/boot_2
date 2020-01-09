package com.iu.b1.notice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//@Resource << 이름으로 찾는 것 = 클래스명의 앞부분을 소문자로 바꾼것
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
//---------------------------------------------------------------------------
	
	@GetMapping("noticeList")
	public ModelAndView noticeList(Model model)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<NoticeVO> ar = noticeService.noticeList();
		
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");	
		return mv;
	}
//---------------------------------------------------------------------------	
	
	
	
//---------------------------------------------------------------------------	
	
	
	
//---------------------------------------------------------------------------	
	
	
	
//---------------------------------------------------------------------------	
	
	
	
//---------------------------------------------------------------------------	
	
	
	
//---------------------------------------------------------------------------
	
	
	
}
