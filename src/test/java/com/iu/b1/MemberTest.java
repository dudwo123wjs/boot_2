package com.iu.b1;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.Member.MemberRepository;
import com.iu.b1.Member.MemberVO;

@SpringBootTest
class MemberTest {
	@Autowired
	private MemberRepository memberRepository;
	
	//@Test
	void test() {
	
//		Optional<MemberVO> opt = memberRepository.findById("iu99");
//		MemberVO memberVO = opt.get();
//		
//		System.out.println("NAME = "+memberVO.getName());
//		System.out.println("FNAME = "+memberVO.getFilesVO().getFname());
//		System.out.println("FILE ID = "+memberVO.getFilesVO().getMemberVO().getId());
		
//		MemberVO memberVO = memberRepository.findById("iu99").get();
//		
//		System.out.println(memberVO.getId());
//		System.out.println();
		
		MemberVO memberVO = new MemberVO();
		
		
		memberVO.setId("dd");
		memberVO.setPw("ds");
		memberVO.setPw2("ds");
		memberVO.setName("sda");
		memberVO.setEmail("sdd");
		
		memberRepository.save(memberVO);
		
	}
	

	

}
