package com.iu.b1.Member;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.Member.MemberFilesVO;
import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;	
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired	private FileSaver fileSaver;
	@Autowired
	private MemberFIlesRepository memberFIlesRepository;
//---------------------------------------------------------------------------		
	public void memberDelete(MemberVO memberVO)throws Exception{
		memberRepository.deleteById(memberVO.getId());
		
	}
	
	
	
//---------------------------------------------------------------------------	
	public MemberVO memberUpdate(MemberVO memberVO, MultipartFile files)throws Exception{
		
		
		if(files.getSize()>0) {
			File file = filePathGenerator.getUseClassPathResource("upload");
			String fileName = fileSaver.save(file, files);
			MemberFilesVO memberFilesVO = memberVO.getFilesVO();
			memberFilesVO.setFname(fileName);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			memberVO.setFilesVO(memberFilesVO);
			memberFilesVO.setMemberVO(memberVO);
		}
		
		return memberRepository.save(memberVO);
	}

	
//---------------------------------------------------------------------------		
	
	public boolean memberIdCheck(String id)throws Exception{
		return memberRepository.existsById(id);
	}
	
//---------------------------------------------------------------------------
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		
		return memberRepository.findById(memberVO.getId()).get();
	}
	
//---------------------------------------------------------------------------	
	
	public boolean memberJoinValidate(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check = false;
		//true -> error, false -> ok
		
		//annotation  검증 결과
		if(bindingResult.hasErrors()) {
			check=true;
		}
		
		//pw가 일치 하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			check=true;
			bindingResult.rejectValue("pw2", "Not Equal PW", "비밀번호가 일치하지 않습니다");
									 //form의 path명, properties의 키 	
		}
		
		
		Boolean ch = memberRepository.existsById(memberVO.getId());
		
		if(ch) {
			check = true;
			bindingResult.rejectValue("id", "Duplicate Id", "중복 ID");
		}
		
		return check;
	}
	
//---------------------------------------------------------------------------		

	public void memberJoin(MemberVO memberVO, MultipartFile files) throws Exception {
		File file = filePathGenerator.getUseClassPathResource("upload");
		String fileName = fileSaver.save(file, files);
		System.out.println(fileName);
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		memberVO.setFilesVO(memberFilesVO);
		memberFilesVO.setMemberVO(memberVO);
		memberRepository.save(memberVO);
		
	}
	
//---------------------------------------------------------------------------		
	public MemberFilesVO getImg(MemberVO memberVO)throws Exception{
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.getMemberVO().setId(memberVO.getId());

		return memberFIlesRepository.findById(memberFilesVO.getFnum()).get();
	}
	
	
}
