package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//Spring Security 를 제어하는 설정 클래스 
	
	/*
	 	SbbSbbApplication.java  : 스프링 부트가 부팅될때 모든 설정을 적용되는 파일 
	 	@Configuration       :  스프링의 각종 설저을 잡는 어노테이션 
		@EnableWebSecurity   : 스프링의 보안 설정을 담당 
		
		@Bean : 메소드 위에서 리턴 객체를 Spring IoC Container에 등록 
				클래스위에 
					@Component, @Controller, @Service , @Repository 
		
	*/ 

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// http://localhost:9696/ 요청은 인증 없이 접근을 허용 
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			
			// http://localhost:9696/h2-console 요청의 접근 을 허용   , h2 DB는 csrf 적용이안되어서 설정 	
			//.csrf().disable()   // 모든 csrf를 사용하지 않도록 설정 
			.csrf((csrf)-> csrf
					.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
					)
			// H2 콘솔에서 프레임을 작동 시키도록 설정 
			.headers((headers) -> headers
					.addHeaderWriter(new XFrameOptionsHeaderWriter(
							XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
							))
					)
			
			;	
		return http.build(); 
	}
	
	
	@Bean					//Spring 컨테이버 (Ioc 컨테이너 ) 객체를 등록  
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	// PasswordEncoder ( 인터페이스 )  ==> BCryptPasswordEncoder ( 구현한 클래스 ) 

	
}
