package com.portfolio.portfolio_project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio_project.core.exception.CustomException;
import com.portfolio.portfolio_project.core.exception.Exception400;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.user.User;
import com.portfolio.portfolio_project.domain.user.UserRepository;
import com.portfolio.portfolio_project.web.adminlogin.InAdminLogin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminLoginService {
    private final MyJwtProvider myJwtProvider;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public String 로그인(InAdminLogin.LoginDTO loginDTO) {

        Optional<User> userOP = userRepository.findByEmail(loginDTO.getEmail());

        if (userOP.isPresent()) {
            User userPS = userOP.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), userPS.getPassword())) {
                String jwt = myJwtProvider.create(userPS); // 토큰 생성
                return jwt;
            }
            throw new Exception400("패스워드가 유효하지 않습니다.");
        } else {
            throw new Exception400("이메일이 유효하지 않습니다.");
        }
    }
}