package com.portfolio.portfolio_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio_project.core.exception.Exception500;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkill;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkillRepository;
import com.portfolio.portfolio_project.service.module.MySkillsModules;
import com.portfolio.portfolio_project.web.skills.MySkillsDTO_In;
import com.portfolio.portfolio_project.web.skills.MySkillsDTO_Out;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MySkillsService {
    
    private final MySkillRepository mySkillRepository;
    private final MySkillsModules mySkillsModules;
    
    @Transactional(readOnly = true)
    public MySkillsDTO_Out.FindAllDTO findAllSkills() {
        List<MySkill> mySkillsPS = new ArrayList<>();
        try {
            mySkillsPS = mySkillRepository.findAll();
        } catch (Exception e) {
            throw new Exception500("스킬 조회에 실패했습니다.");
        }

        return MySkillsDTO_Out.FindAllDTO.fromEntity(mySkillsPS);
    }

    @Transactional
    public void mySkills_post(MySkillsDTO_In.PostDTO postDTO_In) {
        List<MySkill> toAdd = new ArrayList<>();
        List<MySkill> toRemove = new ArrayList<>();

        // toAdd, toRemove 리스트에 추가, 삭제할 엔터티 모으는 함수
        mySkillsModules.processSkills(postDTO_In.getBackEnd(), "BackEnd", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getFrontEnd(), "FrontEnd", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getDevOps(), "DevOps", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getETC(), "ETC", toAdd, toRemove);

        // 추가, 삭제 진행
        try {
            mySkillRepository.saveAll(toAdd);
        } catch (Exception e) {
            throw new Exception500("스킬 저장에 실패했습니다.");
        }
        try {
            mySkillRepository.deleteAll(toRemove);
        } catch (Exception e) {
            throw new Exception500("스킬 삭제에 실패했습니다.");
        }
    }
}