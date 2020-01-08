package com.iu.b1.Member;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.Member.MemberFilesVO;
import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberFIlesRepository memberFIlesRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check = false;
		//true -> error, false -> ok
		
		//annotation 검증 결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		return check;
	}
	
	
	public boolean memberIdCheck(String id)throws Exception{
		return memberRepository.existsById(id);
	}
	
	
	
	
	public int memberJoin(MemberVO memberVO, MultipartFile files)throws Exception{
		int result = 0;
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		if(memberRepository.existsById(memberVO.getId())) {
			
		}else {
			memberVO = memberRepository.save(memberVO);			
			memberFilesVO.setMemberVO(memberVO);
			memberFilesVO.setFname(fileName);
			memberFilesVO.setOname(files.getOriginalFilename());
			memberFilesVO = memberFIlesRepository.save(memberFilesVO);
		}
		if(memberFilesVO != null) {
			result = 1;
		}
		
		return  result;
		
	}
	
	
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		
		return memberRepository.findById(memberVO.getId()).get();
	}
	
	
	
	public MemberVO memberMypage(MemberVO memberVO)throws Exception{
		
		return memberRepository.findById(memberVO.getId()).get();
	}
	
	
	
	public MemberFilesVO getImg(MemberVO memberVO)throws Exception{
		memberVO = memberRepository.findById(memberVO.getId()).get();
		
		return memberFIlesRepository.findById(memberVO.getFilesVO().getFnum()).get();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
