package com.portfolio.portfolio_project.web.skills;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.portfolio.portfolio_project.domain.jpa.skills.enums.SkillType;
import com.portfolio.portfolio_project.domain.jpa.skills.my_skill.MySkill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MySkillsDTO_Out {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FindAllDTO {
        private List<String> backEndSkills;
        private List<String> frontEndSkills;
        private List<String> devOpsSkills;
        private List<String> etcSkills;

        public static FindAllDTO fromEntity(List<MySkill> mySkillsPS) {
            Map<SkillType, List<String>> groupedSkills = mySkillsPS.stream()
                    .collect(Collectors.groupingBy(
                            skill -> skill.getMySkillTypeCode().getSkillType(),
                            Collectors.mapping(MySkill::getSkill, Collectors.toList())
                    ));
            
            List<String> backEndSkills = groupedSkills.getOrDefault(SkillType.BackEnd, Collections.emptyList());
            List<String> frontEndSkills = groupedSkills.getOrDefault(SkillType.FrontEnd, Collections.emptyList());
            List<String> devOpsSkills = groupedSkills.getOrDefault(SkillType.DevOps, Collections.emptyList());
            List<String> etcSkills = groupedSkills.getOrDefault(SkillType.ETC, Collections.emptyList());

            return FindAllDTO.builder()
                    .backEndSkills(backEndSkills)
                    .frontEndSkills(frontEndSkills)
                    .devOpsSkills(devOpsSkills)
                    .etcSkills(etcSkills)
                    .build();
        }
    }
}