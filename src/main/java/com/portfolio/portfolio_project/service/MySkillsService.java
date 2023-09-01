package com.portfolio.portfolio_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<MySkill> mySkillsPS = mySkillRepository.findAll();
        return MySkillsDTO_Out.FindAllDTO.fromEntity(mySkillsPS);
    }

    @Transactional
    public void mySkills_post(MySkillsDTO_In.PostDTO postDTO_In) {
        List<MySkill> toAdd = new ArrayList<>();
        List<MySkill> toRemove = new ArrayList<>();

        mySkillsModules.processSkills(postDTO_In.getBackEnd(), "BackEnd", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getFrontEnd(), "FrontEnd", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getDevOps(), "DevOps", toAdd, toRemove);
        mySkillsModules.processSkills(postDTO_In.getETC(), "ETC", toAdd, toRemove);

        mySkillRepository.saveAll(toAdd);
        mySkillRepository.deleteAll(toRemove);
    }


}