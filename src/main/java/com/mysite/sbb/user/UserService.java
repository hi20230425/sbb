package com.mysite.sbb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor			// DI : 생성자를 통한 객체 주입 방식 
@Service
public class UserService {
	// Clinet ==> Controller ==> Service ==> Repository ==> Entity ==> DB Table 
	
	private final UserRepository userRepository; 
	private final PasswordEncoder passwordEncoder; 
	
	// Controller :  id, passwod, email 받아서 DB에 저장 하는 메소드 
	public SiteUser create (String username, String email , String password) {
		SiteUser user = new SiteUser(); 
		
		//매개변수의 값을 받아서 setter 주입 
		user.setUsername(username);
		user.setEmail(email);
		
		// 패스워드 암호화 처리후 setter 주입 	
		// 메소드 내부에서 암호화 객체를 생성하면 암호화 키가 변경이 되면 수정하기가 어렵다. 
		// 스프링이 부팅될때 IoC 컨테이너에 객체를 생성하고 DI 를 통해서 사용 
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		
		// 패스워드를 암호화 해서 주입 
		user.setPassword(passwordEncoder.encode(password));
		
		userRepository.save(user); 
		
		return user ; 
	}
	

}
