package com.portfolio.portfolio_project.integration_test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlog;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlogRepository;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProject;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProjectRepository;
import com.portfolio.portfolio_project.integration_test.dummy.MyBlogDummy;
import com.portfolio.portfolio_project.integration_test.dummy.MyProjectDummy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("프로젝트 페이지 - 통합 테스트")
@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MyProjectIntegrationTest {
    
        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        @Autowired
        private EntityManager em;
        @Autowired
        private MyJwtProvider myJwtProvider;
        @Autowired
        private MyProjectRepository myProjectRepository;

        @BeforeEach
        public void setUp() {
                em.createNativeQuery("ALTER TABLE my_project_tb AUTO_INCREMENT = 1").executeUpdate();

                List<MyProject> myProjects = new ArrayList<>();
                myProjects.add(MyProjectDummy.newMyProject1());
                myProjects.add(MyProjectDummy.newMyProject2());
                myProjectRepository.saveAll(myProjects);
        }
}
