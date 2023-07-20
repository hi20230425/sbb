package com.mysite.sbb.question;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor    //생성자를 이용한 객체 주입 방식 : class내부의 final 이 붙은 변수에 객체를 주입 
@Controller
public class QuestionController {
	// Controller 는 Repository를 직접 접근하지 않는다. 
		// -- 중복된 코드, 보안 
	// Controller 는 Service를 접근 한다. 
	
	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService; 
	
	//client의 /question/list 요청을 처리하는 메소드 : http://localhost:9696/question/list
	@GetMapping ("/question/list")
	public String list(Model model) {
		//1. client 요청을 받는다. http://localhost:9696/question/list
		
		//2. 비즈 니스 로직 처리 
		List<Question> questionList = questionService.getList() ; 
		
		//3. 받아온 List를 client 로 전송 ( Model 객체에 저장해서 Cient로 전송 )  
		model.addAttribute("questionList", questionList); 
		
		return "question_list"; 
	}
	

}
