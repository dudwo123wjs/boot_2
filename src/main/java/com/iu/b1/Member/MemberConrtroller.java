package com.iu.b1.Member;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberConrtroller {

//	@Autowired
//	private MemberService memberService;
//	
//	@ModelAttribute
//	public MemberVO getMemberVO()throws Exception{
//		return new MemberVO();
//	}
//	
//	
//	@GetMapping("memberJoin")
//	public String memberJoin(Model model)throws Exception{
//		model.addAttribute("memberVO" , new MemberVO());
//		return "member/memberJoin";
//	}
//	
//	
//	@PostMapping("memberJoin") //@Valid + 해당VO + BindingResult bindingResult   <<MemberVO 회원가입 조건 관리
//	public ModelAndView memberJoin(@Valid MemberVO memberVO,BindingResult bindingResult ,MultipartFile files)throws Exception{
//		//files  << memberJoin.jsp의 name과 동일하게 해야하기 때문에 files로 지정
//		ModelAndView mv = new ModelAndView();
//		if(memberService.memberJoinValidate(memberVO, bindingResult)) {
//			mv.setViewName("member/memberJoin");
//			System.out.println("2");
//		}else {
//			System.out.println("3");
//		int result = memberService.memberJoin(memberVO, files);	
//		System.out.println("4");
//		String message = "Join Fail";
//		String path ="../";
//		System.out.println("5");
//		
//		if(result>0) {
//			message= "Join Succes";
//			System.out.println("6");
//		}
//		
//		mv.setViewName("common/result");
//		mv.addObject("message", message);
//		mv.addObject("path", path);
//		
//		}//else문 끝
//		return mv;
//	
//	}
//	
//	
	@GetMapping("memberLogin")
	public String memberLogin()throws Exception{
		
		return "member/memberLogin";
	}
//	
//	@PostMapping("memberLogin")
//	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		memberVO = memberService.memberLogin(memberVO);
//		String message = "로그인 실패";
//		String path = "/";
//		
//		if(memberVO != null) {
//			message ="로그인 성공";
//			path = "/";
//			session.setAttribute("member", memberVO);
//			session.setAttribute("files", memberService.getImg(memberVO));
//		}
//		mv.addObject("message", message);
//		mv.addObject("path", path);
//		mv.setViewName("common/result");		
//		
//		return mv;
//		
//	}
//	
//	@GetMapping("memberMypage")
//	public String memberMypage(MemberVO memberVO)throws Exception{
//		
//
//		
//		return "member/memberMypage";
//	}
//	
//	
//	
//	@GetMapping("memberLogout")
//	public String memberLogout(HttpSession session)throws Exception{
//		
//		session.invalidate();
//		
//		return "redirect:../";
//	}
//	
//	@GetMapping("memberFileDown")
//	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId(memberFilesVO.getId());
//		memberFilesVO =  memberService.getImg(memberVO);
//		if(memberFilesVO != null) {
//			mv.addObject("memberfiles", memberFilesVO);
//			mv.addObject("path", "upload");
//			mv.setViewName("fileDown");
//			
//		}else {
//			mv.addObject("message", "NO Image File");
//			mv.addObject("path", "./membermyPage");
//			mv.setViewName("common/result");
//		}
//		
//		return mv;
//	}
	
	
	
	
	
}
