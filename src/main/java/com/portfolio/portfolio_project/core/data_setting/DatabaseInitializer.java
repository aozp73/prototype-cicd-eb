package com.portfolio.portfolio_project.core.data_setting;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.portfolio.portfolio_project.domain.user.User;
import com.portfolio.portfolio_project.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void run(String... args) {

        Optional<User> userCheck = userRepository.findByEmail("aozp73@naver.com");

        if (!userCheck.isPresent()) {
            String encPassword = bCryptPasswordEncoder.encode("1234");
            User user = User.builder()
                    .email("aozp73@naver.com")
                    .password(encPassword)
                    .role("ROLE_admin")
                    .createdAt(LocalDateTime.now())
                    .build();
            userRepository.save(user);
        }
    }   
}