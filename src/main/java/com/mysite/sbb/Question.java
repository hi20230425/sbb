package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;		//spring boot 3.0 ,
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import javax.persistence.Entity;	//spring boot 2.0 

@Entity
public class Question {
		//질문 테이블 : 부모 테이블 
	
	//@Entity :  클래스 위에 부여 , DataBase의 테이블과 매칭 되는 자바 클래스 
		// Question : 테이블명 
		// 		변수 : 컬럼명 
	//테이블의 컬럼명을 지정
	// JPA를 사용해서 테이블의 컬럼을 정의 할시 반드시 Primary Key 를 정의 
		// @Id 어노테이션 : Primary Key 컬럼을 부여 , 중복된 데어터를  넣을 수 없다. 
		// @GeneratedValue : 자동으로 값을 증가 , 시퀀스 (오라클) , auto_increament (MySQL) 
				// identity (MSSQL) 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column (length = 200)
	private String subject; 
	
	@Column(columnDefinition = "Text")
	private String content; 
	
	private LocalDateTime createDate; 
	
	/*
	@Column( length = 100) 
	private String name; 
	
	@Column( length = 100) 
	private String age; 
	*/ 

}
