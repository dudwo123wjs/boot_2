package com.iu.b1.qna;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QnaService {

	//@Resource 도 가능
	@Autowired
	private QnaRepository qnaRepository;
	
	
	public void qnaUpdate()throws Exception{
		qnaRepository.qnaUpdate("retitle", "recontents", 2);
	}
}
