package com.portfolio.portfolio_project.integration_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.main.main_introduce.MainIntroduceRepository;
import com.portfolio.portfolio_project.domain.jpa.user.User;
import com.portfolio.portfolio_project.web.main.MainIntroduceDTO_In;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("메인페이지 통합 테스트")
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MainIntroduceIntegrationTest {
    
        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        
        @Autowired
        private MyJwtProvider myJwtProvider;


        @DisplayName("게시글 등록")
        @Test
        public void stadium_save_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                MainIntroduceDTO_In.PostDTO postDTO_In = new MainIntroduceDTO_In.PostDTO("테스트 제목", 
                                                                                         "테스트 내용", 
                                                                                         "테스트 이미지 이름.png",
                                                                                         "image/png",
                                                                                         "data:image/png;base64,aGVsbG8=");

                String requestBody = om.writeValueAsString(postDTO_In);

                // when
                ResultActions resultActions = mvc
                                .perform(post("/auth/main").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.debug(responseBody);

                // then
                resultActions.andExpect(status().isOk());
        }
}
