package com.iu.b1.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{

	//findAll은 모든 정보를 가져오되, 정렬이 안된 무작위로 가져오기 때문에 정렬해주는 코드가 필요하다.
	//List 앞 public 을 안써줄시 interface이기 때문에 자동적으로 불러오게 된다.
	//select * from notice order where num > ? by num desc
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.entity-persistence
	List<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num)throws Exception;
	
}
