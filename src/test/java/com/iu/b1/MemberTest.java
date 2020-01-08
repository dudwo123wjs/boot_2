package com.iu.b1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.b1.Member.MemberRepository;
import com.iu.b1.Member.MemberVO;

@SpringBootTest
class MemberTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void test() {
	
		MemberVO memberVO = memberRepository.findById("iu99").get();
		
		System.out.println(memberVO.getId());
		System.out.println();
	}
	
	
	
	

}
