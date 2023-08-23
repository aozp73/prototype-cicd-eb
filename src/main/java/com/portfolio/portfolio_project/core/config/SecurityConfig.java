package com.portfolio.portfolio_project.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/auth/**").authenticated()
			.anyRequest().permitAll()
			
			.and()
			.formLogin()
			.loginPage("/login") // 인증이 필요한 페이지 요청 시 진행 (GET 방식)  
			.loginProcessingUrl("/auth/signin") // 로그인 POST요청 시 진행 (POST 방식)
			.defaultSuccessUrl("/main");
			
		
		return http.build();
	}	
}