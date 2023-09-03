package com.portfolio.portfolio_project.integration_test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.user.User;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu.ResumeAcademyEduRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificateRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEduRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_self_study.ResumeSelfStudyRepository;
import com.portfolio.portfolio_project.integration_test.dummy.ResumeDummy;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In.Academyedu_postDTO;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In.Certificate_postDTO;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In.Schooledu_postDTO;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In.Selfstudy_postDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("이력 페이지 - 통합 테스트")
@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc
@Rollback(value = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ResumeIntegrationTest {

        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        @Autowired
        private EntityManager em;
        @Autowired
        private MyJwtProvider myJwtProvider;
        
        @Autowired
        private ResumeSchoolEduRepository resumeSchoolEduRepository;
        @Autowired
        private ResumeAcademyEduRepository resumeAcademyEduRepository;
        @Autowired
        private ResumeCertificateRepository resumeCertificateRepository;
        @Autowired
        private ResumeSelfStudyRepository resumeSelfStudyRepository;

        @BeforeEach
        public void init() {
            resumeSchoolEduRepository.deleteAll();
            resumeAcademyEduRepository.deleteAll();
            resumeCertificateRepository.deleteAll();
            resumeSelfStudyRepository.deleteAll();

            setup();
        }

        @AfterEach
        public void clean() {
            resumeSchoolEduRepository.deleteAll();
            resumeAcademyEduRepository.deleteAll();
            resumeCertificateRepository.deleteAll();
            resumeSelfStudyRepository.deleteAll();
        }

        // POST 테스트
        @DisplayName("학교교육 이력 등록")
        @Test
        public void resume_school_edu_post_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                Schooledu_postDTO schooledu_postDTO = new Schooledu_postDTO();
                schooledu_postDTO.setValues(Arrays.asList("2018-09-01","2022-12-31","졸업","자바 대학교","기계 공학과","3.7"));
                String requestBody = om.writeValueAsString(schooledu_postDTO);

                // when
                ResultActions resultActions = mvc
                                                .perform(post("/auth/resume/schooledu").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.info("결과 : " + responseBody);

                // then
                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.schoolAdmissionDate").value("2018-09-01"))
                        .andExpect(jsonPath("$.data.schoolName").value("자바 대학교"));
        } 

        @DisplayName("학원교육 이력 등록")
        @Test
        public void resume_academy_edu_post_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                Academyedu_postDTO academyedu_postDTO = new Academyedu_postDTO();
                academyedu_postDTO.setValues(Arrays.asList("2022-09-01","2023-03-31","수료","파이썬 아카데미","웹개발 과정","-"));
                String requestBody = om.writeValueAsString(academyedu_postDTO);

                // when
                ResultActions resultActions = mvc
                                                .perform(post("/auth/resume/academyedu").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.info("결과 : " + responseBody);

                // then
                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.academyEnrollDate").value("2022-09-01"))
                        .andExpect(jsonPath("$.data.academyName").value("파이썬 아카데미"));
        } 

        @DisplayName("자격증 이력 등록")
        @Test
        public void resume_certificate_post_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                Certificate_postDTO certificate_postDTO = new Certificate_postDTO();
                certificate_postDTO.setValues(Arrays.asList("2023-06-01","IT 자격증","정보처리기사","산업인력공단","최종합격"));
                String requestBody = om.writeValueAsString(certificate_postDTO);

                // when
                ResultActions resultActions = mvc
                                                .perform(post("/auth/resume/certificate").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.info("결과 : " + responseBody);

                // then
                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.acquisitionDate").value("2023-06-01"))
                        .andExpect(jsonPath("$.data.certificateName").value("정보처리기사"));
        } 

        @DisplayName("자기주도학습 이력 등록")
        @Test
        public void resume_selfstudy_post_test() throws Exception {
                // given
                String jwt = myJwtProvider.create(User.builder().id(1L).email("aozp73@naver.com").role("admin").build());
                Selfstudy_postDTO selfstudy_postDTO = new Selfstudy_postDTO();
                selfstudy_postDTO.setValues(Arrays.asList("2023-08-01","데브옵스","Docker","인프런","학습 링크"));
                String requestBody = om.writeValueAsString(selfstudy_postDTO);

                // when
                ResultActions resultActions = mvc
                                                .perform(post("/auth/resume/selfstudy").content(requestBody)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .header(MyJwtProvider.HEADER, MyJwtProvider.TOKEN_PREFIX + jwt));
                String responseBody = resultActions.andReturn().getResponse().getContentAsString();
                log.info("결과 : " + responseBody);

                // then
                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data.selfStudyDate").value("2023-08-01"))
                        .andExpect(jsonPath("$.data.selfStudyTheme").value("Docker"));
        } 




        // 각 Document 세팅
        public void setup() {
            resumeSchoolEduRepository.save(ResumeDummy.newResumeSchoolEdu1());
            resumeSchoolEduRepository.save(ResumeDummy.newResumeSchoolEdu2());

            resumeAcademyEduRepository.save(ResumeDummy.newResumeAcademyEdu1());
            resumeAcademyEduRepository.save(ResumeDummy.newResumeAcademyEdu2());
    
            resumeCertificateRepository.save(ResumeDummy.newResumeCertificate1());
            resumeCertificateRepository.save(ResumeDummy.newResumeCertificate2());
 
            resumeSelfStudyRepository.save(ResumeDummy.newResumeSelfStudy1());
            resumeSelfStudyRepository.save(ResumeDummy.newResumeSelfStudy2());

            em.flush();
            em.clear();
        }
}
