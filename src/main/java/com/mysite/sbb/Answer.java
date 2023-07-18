package com.mysite.sbb;

import java.time.LocalDateTime;		//그 지역에 맞도록 날짜와 시간을 등록 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;   

@Entity
public class Answer {
		//답변글을 저장하는 테이블 : 자식 테이블 
	
	//@Entity : Java의 클래스를 DB의 테이블로 매핑 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(columnDefinition = "text")
	private String content; 
	
	private LocalDateTime createDate;
		//JPA 에서 필드이름을 : createDate   <=====> CREATE_DATE 
	
	
	//Foreign Key ; 
		// question   <======> QUESTION_ID
	@ManyToOne         //   답변(Answer) : Many   ======>   질문(Question)  : one
	private Question question; 
	

}
