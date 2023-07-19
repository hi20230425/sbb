package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
	
	//QuestionRepository 객체 주입 
	@Autowired
	private QuestionRepository qr; 

	//@Test
	void contextLoads() {
		Question q1 = new Question(); 
		
		q1.setSubject("오늘의 날씨는? ");
		q1.setContent("오늘의 날씨는 어떠한지 궁금합니다.");
		q1.setCreateDate(LocalDateTime.now());
		
		qr.save(q1);
	
		
		Question q2 = new Question(); 
		
		q2.setSubject("스프링 부트 질문 ");
		q2.setContent("스프링 부트가 무엇인지 어떠한지 궁금합니다.");
		q2.setCreateDate(LocalDateTime.now());
		
		qr.save(q2); 
	
	}
	
	//@Test
	void contextLoads1() {
		Question q3 = new Question(); 
		
		q3.setSubject("오늘의 스포츠는? ");
		q3.setContent("오늘의 스포츠는 어떠한지 궁금합니다.");
		q3.setCreateDate(LocalDateTime.now());
		
		qr.save(q3); 
		
		Question q4 = new Question(); 
		
		q4.setSubject("미국의 날씨는  ");
		q4.setContent("미국의 날씨가  어떠한지 궁금합니다.");
		q4.setCreateDate(LocalDateTime.now());
		
		qr.save(q4); 
	
	}
	
	//@Test
	void recodeCount() {
		List<Question> all = qr.findAll();
			//qr : Question 테이블과 연결
			//findAll()  : select * from question;
		
			//assertEquals (기대치, 값) ; 
		assertEquals(4, all.size()); 
		
		
	}
	//@Test
	void subjectTest() {		
		List<Question> all = qr.findAll(); 		
		Question q = all.get(1); 

		assertEquals("스프링 부트 질문 ", q.getSubject()); 		
	}
	
	//@Test
	void idSearch () {
		
		//Optional null을 쉽게 처리해주는 객체 
		// qr.findById(1)  <=====> select * from question where id = 1 ; 
		Optional<Question> o = qr.findById(1); 
		
		// isPresent() : Optional 에 저장된 객체가 null 이아닐때 
		if (o.isPresent()) {
			Question q = o.get() ;     // Optional 에 저장된 객체를 끄집어 내서 q 변수에 할당. 
			
			// assertEquals(1, q.getId()) ; 
			assertEquals("오늘의 날씨는? ", q.getSubject()); 
		}
		
	}
	//@Test	// 제목으로 검색 Test 
	void searchSubject() {
		List<Question> all = qr.findBySubject("오늘의 날씨는? "); 
		
		Question q = all.get(0); 
		
		assertEquals("오늘의 날씨는? ", q.getSubject()); 
		assertEquals(1, all.size());
		
	}
	//@Test
	void serchContent() {
		List<Question> all = qr.findByContent("오늘의 날씨는 어떠한지 궁금합니다."); 
		
		Question q = all.get(0); 
		
		assertEquals("오늘의 날씨는 어떠한지 궁금합니다.", q.getContent()); 	
	}
	//@Test
	void searchSubjectLike() {
		//select * from question where subject like '%날씨%' ; 
		List<Question> all = qr.findBySubjectLike("%날씨%"); 
		
		Question q = all.get(1); 
		
		assertEquals(2 , all.size()); 
		assertEquals(4, q.getId()); 
		
	}
	@Test
	void serchContentLike() {
		List <Question> all = qr.findByContentLike("%궁금%"); 
		
		Question q = all.get(3); 
		
		assertEquals(4, all.size());
		assertEquals(4, q.getId()); 
		
	}
	
	

}
