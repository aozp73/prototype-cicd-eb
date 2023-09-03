package com.portfolio.portfolio_project.integration_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlog;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlogRepository;
import com.portfolio.portfolio_project.integration_test.dummy.MyBlogDummy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("블로그 페이지 - 통합 테스트")
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MyBlogIntegrationTest {

        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        
        @Autowired
        private MyJwtProvider myJwtProvider;
        @Autowired
        private MyBlogRepository myBlogRepository;

        @BeforeEach
        public void setUp() {
                List<MyBlog> myBlogs = new ArrayList<>();
                myBlogs.add(MyBlogDummy.newMyBlog1());
                myBlogs.add(MyBlogDummy.newMyBlog2());
                myBlogRepository.saveAll(myBlogs);
        }

        
    
}
