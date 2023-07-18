package com.mysite.sbb;

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
		

}
