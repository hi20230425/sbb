package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository; 
	
	//Question 테이블의 모든 레코드를 읽어와서 List<Question> 으로 값을 리턴하는 메소드 
	public List<Question> getList() {
		
		
		List<Question> questionList = questionRepository.findAll(); 
		//return questionRepository.findAll(); 
		return questionList; 
	}

}
