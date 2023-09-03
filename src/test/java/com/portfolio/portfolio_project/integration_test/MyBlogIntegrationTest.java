package com.portfolio.portfolio_project.integration_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlog;
import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlogRepository;
import com.portfolio.portfolio_project.domain.jpa.user.User;
import com.portfolio.portfolio_project.integration_test.dummy.MyBlogDummy;
import com.portfolio.portfolio_project.web.myblog.MyBlogDTO_In;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("블로그 페이지 - 통합 테스트")
@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MyBlogIntegrationTest {

        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        @Autowired
        private EntityManager em;
        @Autowired
        private MyJwtProvider myJwtProvider;
        @Autowired
        private MyBlogRepository myBlogRepository;

        @BeforeEach
        public void setUp() {
                em.createNativeQuery("ALTER TABLE main_introduce_tb AUTO_INCREMENT = 1").executeUpdate();

                List<MyBlog> myBlogs = new ArrayList<>();
                myBlogs.add(MyBlogDummy.newMyBlog1());
                myBlogs.add(MyBlogDummy.newMyBlog2());
                myBlogRepository.saveAll(myBlogs);
        }


        @DisplayName("게시글 등록")
        @Test
        public void blog_post_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                MyBlogDTO_In.PostDTO postDTO_In = new MyBlogDTO_In.PostDTO("등록 제목",
                                                                           "등록 내용", 
                                                                           "등록 소제목",
                                                                           "등록 이미지 이름.png",
                                                                           "image/png",
                                                                           "data:image/png;base64,aGVsbG8=");

                String requestBody = om.writeValueAsString(postDTO_In);

                // when
                ResultActions resultActions = mvc
                                .perform(post("/auth/blog").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.info("결과 : " + responseBody);

                // then
                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.id").value(3L))
                        .andExpect(jsonPath("$.data.mainTitle").value("등록 제목"))
                        .andExpect(jsonPath("$.data.content").value("등록 내용"))
                        .andExpect(jsonPath("$.data.imgURL").exists());
        }

    
}
