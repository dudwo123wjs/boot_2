package com.iu.b1.Member;

import java.nio.file.Files;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberConrtroller {

	@Autowired
	private MemberService memberService;

//---------------------------------------------------------------------------
	@GetMapping("memberDelete")
	public String memberDelete(HttpSession session)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		memberService.memberDelete(memberVO);
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	
	
//---------------------------------------------------------------------------	
	@GetMapping("memberUpdate")
	public void memberUpdate(HttpSession session, Model model)throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("memberVO", memberVO);	
	}
	
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session, MultipartFile files)throws Exception{
		MemberVO loginVO = (MemberVO)session.getAttribute("member");
		
		memberVO.setFilesVO(loginVO.getFilesVO());
		
		memberVO = memberService.memberUpdate(memberVO, files); 
		
		session.setAttribute("member", memberVO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "업데이트 성공");
		mv.addObject("path", "../");
		
		mv.setViewName("common/result");
		
		return mv;
	}
//---------------------------------------------------------------------------	
	@PostMapping("memberIdCheck")
	@ResponseBody //(view 페이지로 보내지 않고 데이터를 넘기라는 코드)
	public boolean memberIdCheck(String id)throws Exception{		
		return memberService.memberIdCheck(id);
	}
	
	@ModelAttribute
	public MemberVO getMemberVO()throws Exception{
		return new MemberVO();
	}
	
//---------------------------------------------------------------------------	
	@GetMapping("memberJoin")
	public String memberJoin(Model model)throws Exception{
		model.addAttribute("memberVO" , new MemberVO());
		return "member/memberJoin";
	}
	
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO,BindingResult bindingResult, MultipartFile files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(memberService.memberJoinValidate(memberVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
		}else {
		
			memberService.memberJoin(memberVO, files);
			String path = "../";
			String message="회원 가입 성공";
			mv.setViewName("common/result");
			mv.addObject("message", message);
			mv.addObject("path", path);
		}
		return mv;
	}

	
//---------------------------------------------------------------------------	
	@GetMapping("memberLogin")
	public String memberLogin()throws Exception{
		
		return "member/memberLogin";
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.memberLogin(memberVO);
		String message = "로그인 실패";
		String path = "/";
		
		if(memberVO != null) {
			message ="로그인 성공";
			path = "/";
			session.setAttribute("member", memberVO);
		}
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");		
		
		return mv;
		
	}
//---------------------------------------------------------------------------	
	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
//---------------------------------------------------------------------------	
	@GetMapping("memberMypage")
	public String memberMypage(MemberVO memberVO)throws Exception{
	
		return "member/memberMypage";
	}		
//---------------------------------------------------------------------------	
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = new MemberVO();
		memberVO.setId(memberVO.getId());
		memberFilesVO =  memberService.getImg(memberVO);
		if(memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
			
		}else {
			mv.addObject("message", "NO Image File");
			mv.addObject("path", "./membermyPage");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
//---------------------------------------------------------------------------	
	
	
	
	
}
