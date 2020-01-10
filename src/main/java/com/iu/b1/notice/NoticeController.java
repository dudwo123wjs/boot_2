package com.iu.b1.notice;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.b1.Member.MemberFilesVO;
import com.iu.b1.Member.MemberVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//@Resource << 이름으로 찾는 것 = 클래스명의 앞부분을 소문자로 바꾼것
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
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
	@GetMapping("noticeSelect")
	public ModelAndView noticeSelect(Integer num)throws Exception{
		ModelAndView mv = new ModelAndView();
		NoticeVO opt = noticeService.noticeSelect(num);

		if(opt.getTitle() != null) {
			mv.setViewName("notice/noticeSelect");
			mv.addObject("vo", opt);
		}else {
			mv.setViewName("common/result");
			mv.addObject("message", "접속 불가");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	
//---------------------------------------------------------------------------	
	@GetMapping("noticeDelete")
	public ModelAndView noticeDelete(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = 0;
		if (noticeService.noticeDelete(noticeVO).getTitle() == "") {
			result = 1;
		}
		String msg = "삭제 실패";
		if(result > 0) {;
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		
		noticeService.noticeDelete(noticeVO);
		System.out.println("8");
		return mv;
	}
	
//	@GetMapping("noticeDelete")
//	public String noticeDelete(HttpSession session)throws Exception{
//		NoticeVO noticeVO = (NoticeVO)session.getAttribute("notice");
//		
//		noticeService.noticeDelete(noticeVO);
//		session.invalidate();
//		
//		return "redirect:../";
//		
//	}
	
	
	
	
	
//---------------------------------------------------------------------------	
	@PostMapping("noticeWrite")
	public String noticeWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		files.remove(0);
		noticeService.boardWrite(noticeVO, files);
		return "redirect:./noticeList";
	}
	
	
//---------------------------------------------------------------------------	
	@GetMapping("noticeWrite")
	public ModelAndView noticeWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeWrite");
		mv.addObject("noticeVO", new NoticeVO());
		return mv;
	}
	
	
//---------------------------------------------------------------------------
	@GetMapping("noticeFileDown")
	public ModelAndView noticeFileDown(NoticeFIlesVO noticeFIlesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(noticeVO.getNum());
		noticeFIlesVO = noticeService.getImg(noticeVO);
		if(noticeFIlesVO != null) {
			mv.addObject("noticefiles", noticeFIlesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");			
		}else {
			mv.addObject("message", "NO Image File");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
}
