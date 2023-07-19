package com.mysite.sbb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
		// QuestionRepository : Question 테이블을 CRUD 하는 메소드 구현 
	
	//client  ======> Controller ======> Service ======> Repository===> Entity ====> DB 
	//									(비즈니스 로직)    (DAO, DB를 직접접근)
	
	// Repository : 메소드를 사용해서 DB의 테이블을 select, insert, update, delete 
		// JpaRepository <Question, Integer> 인터페이스를 구현 해서 생성해야한다. 
			    //Question : Entity class
				//Integer  : Question Entity 클래스의 Primary Key 컬럼의 DataType 
	
	//JPA 메소드 
		//findAll()   : select
		//save() 	  : insert , update
		//delete()    : delete
	
	//JPA 메소드를 사용한 테이블 검색 : 기본적으로 2개의 메소드는 자동으로 등록 되어 있음. 
			// 그외는 등록 해서 사용 해야 한다. 
		//findAll()    :  select * from question    <== 모든 레코드를 출력 
		//findById(1)     : select * from question where id = 1   <== id를 기준으로 레코드 1개 
	
	//검색된 레코드가 1개일때는 Optional 에 저장 
	//검색된 레코드가 여러개일때는 List 에 저장 
	//Select * from question where subject = ' '  
	List<Question> findBySubject(String subject); 
	
	//Select * from question where content = '' 
	List<Question> findByContent(String content); 
	
	//특정 컬럼의 값을 검색 : Like 검색   <=== 레코드가 여러개가 검색 : List 
	//Select * from question where subject like '%?%'; 
	List<Question> findBySubjectLike(String subject); 
	
	//select * from question where content like '%?%'
	List<Question> findByContentLike(String content); 
	
	

}
