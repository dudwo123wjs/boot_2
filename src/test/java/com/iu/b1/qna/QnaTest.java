package com.iu.b1.qna;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
//@Transactional
class QnaTest {
	
	@Resource
	private QnaRepository qnaRepository;
	
	@Autowired
	private QnaService qnaService;
	
	
	@Test
	void columTest()throws Exception{
	List<Object []> obj = qnaRepository.qnaSelect(2);
	for(Object[] o:obj) {
		for(Object o2:o) {
		System.out.println(o2);
		
			}
		}
	}
	
	
	
	
	
	
	
	//@Test
	void selectOneTest()throws Exception{
		QnaVO qnaVO = qnaRepository.findQnaVO(2);
		System.out.println(qnaVO.getTitle());	
		System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
	
	}
	
	//@Test
	void UpdateTest()throws Exception{
		qnaService.qnaUpdate();
		
		
	}


}
