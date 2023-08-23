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
			.defaultSuccessUrl("/main")
			
			.and()
			.logout()  // 로그아웃 관련 설정 추가
			.logoutUrl("/auth/logout")  // 로그아웃을 진행할 URL
			.logoutSuccessUrl("/main")  // 로그아웃 성공 후 리다이렉트될 URL
			.invalidateHttpSession(true)  // 로그아웃 시 세션 무효화
			.deleteCookies("JSESSIONID");  // 로그아웃 시 쿠키 삭제
		
		return http.build();
	}	
}