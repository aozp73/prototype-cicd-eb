package com.portfolio.portfolio_project.service.module;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.portfolio.portfolio_project.core.exception.Exception400;
import com.portfolio.portfolio_project.domain.jpa.skills.enums.SkillType;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkill;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkillRepository;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill_type_code.MySkillTypeCode;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill_type_code.MySkillTypeCodeRepository;
import com.portfolio.portfolio_project.web.skills.MySkillsDTO_In;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MySkillsModules {
    
    private final MySkillTypeCodeRepository mySkillTypeCodeRepository;
    private final MySkillRepository mySkillRepository;

    public void processSkills(List<MySkillsDTO_In.PostDTO.SkillDTO> skillDTOs, String section, List<MySkill> toAdd, List<MySkill> toRemove) {
    if (skillDTOs == null) return;

    for (MySkillsDTO_In.PostDTO.SkillDTO skillDTO : skillDTOs) {
        MySkillTypeCode mySkillTypeCodePS = mySkillTypeCodeRepository.findBySkillType(SkillType.valueOf(section)).orElseThrow(() -> {
            throw new Exception400("존재하지 않는 스킬타입입니다.");
        });
        System.out.println("테스트 00 : " + skillDTO.getStatus());

        // 새로 추가하는 스킬이라면 list에 모아서 한번에 saveAll()
        if ("added".equals(skillDTO.getStatus())) {
            MySkill mySkill = MySkill.builder()
                    .skill(skillDTO.getName())
                    .mySkillTypeCode(mySkillTypeCodePS)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            toAdd.add(mySkill);

        // 제거하는 스킬이라면 list에 모아서 한번에 deleteAll()
        } else if ("removed".equals(skillDTO.getStatus())) {
            System.out.println("테스트 11 ");
            MySkill existingSkill = mySkillRepository.findBySkillAndMySkillTypeCode(skillDTO.getName(), mySkillTypeCodePS).orElseThrow(() -> {
                throw new Exception400("삭제하려는 스킬이 존재하지 않습니다.");
            });
            toRemove.add(existingSkill);
        }
    }
}
}
