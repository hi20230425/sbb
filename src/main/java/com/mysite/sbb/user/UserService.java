package com.mysite.sbb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor			// DI : 생성자를 통한 객체 주입 방식 
@Service
public class UserService {
	// Clinet ==> Controller ==> Service ==> Repository ==> Entity ==> DB Table 
	
	private final UserRepository userRepository; 
	
	// Controller :  id, passwod, email 받아서 DB에 저장 하는 메소드 
	public SiteUser create (String username, String email , String password) {
		SiteUser user = new SiteUser(); 
		
		//매개변수의 값을 받아서 setter 주입 
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		userRepository.save(user); 
		
		return user ; 
	}
	

}
