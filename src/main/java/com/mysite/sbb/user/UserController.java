package com.mysite.sbb.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping ("/user")
@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService; 
	
	
	//사용자 정보를 입력 하는 요청
	@GetMapping ("/signup")		// http://localhost:9696/user/signup 
		// http://localhost:9696/user/signup?username=user3&email=user3@aaa.com&password=1234
	public String signup(@RequestParam (value = "username") String username
			, @RequestParam(value = "email") String email 
			, @RequestParam(value = "password") String password			
			) {
		
		System.out.println("=======get 방식으로 넘어오는 값을 @RequestParam 으로 받아서 출력 =====");
		System.out.println("username : " + username);
		System.out.println("email : " + email);
		System.out.println("password : " + password);
		
		SiteUser user = 
		userService.create(username, email, password); 
		
		return "redirect:/"; 		// signup_form.html  
	}
	
	@PostMapping("/signup")
	public String signup (String abc) {
		
		return "redirect:/" ; 
	}
	
	
	
	
}
