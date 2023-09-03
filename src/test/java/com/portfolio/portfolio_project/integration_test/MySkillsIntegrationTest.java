package com.portfolio.portfolio_project.integration_test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio_project.core.jwt.MyJwtProvider;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkill;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkillRepository;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill_type_code.MySkillTypeCode;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill_type_code.MySkillTypeCodeRepository;
import com.portfolio.portfolio_project.integration_test.dummy.MySkillDummy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("스킬 페이지 - 통합 테스트")
@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc
public class MySkillsIntegrationTest {

        @Autowired
        private MockMvc mvc;
        @Autowired
        private ObjectMapper om;
        @Autowired
        private EntityManager em;
        @Autowired
        private MyJwtProvider myJwtProvider;
        @Autowired
        private MySkillRepository mySkillRepository;
        @Autowired
        private MySkillTypeCodeRepository mySkillTypeCodeRepository;

        @BeforeEach
        public void setUp() {
                em.createNativeQuery("ALTER TABLE my_skill_tb AUTO_INCREMENT = 1").executeUpdate();

                MySkillTypeCode backEnd = mySkillTypeCodeRepository.findById(1L).get();
                MySkillTypeCode frontEnd = mySkillTypeCodeRepository.findById(2L).get();

                List<MySkill> mySkills = new ArrayList<>();
                mySkills.add(MySkillDummy.newSkill1(backEnd));
                mySkills.add(MySkillDummy.newSkill1(frontEnd));

                mySkillRepository.saveAll(mySkills);

                em.flush();
                em.clear();
        }
    
}
