package com.portfolio.portfolio_project.web.myskills;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MySkillsDTO_In {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostDTO {
        @JsonDeserialize(as = ArrayList.class, contentAs = SkillDTO.class)
        private List<SkillDTO> BackEnd;
        @JsonDeserialize(as = ArrayList.class, contentAs = SkillDTO.class)
        private List<SkillDTO> FrontEnd;
        @JsonDeserialize(as = ArrayList.class, contentAs = SkillDTO.class)
        private List<SkillDTO> DevOps;
        @JsonDeserialize(as = ArrayList.class, contentAs = SkillDTO.class)
        private List<SkillDTO> ETC;
 
        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class SkillDTO {
            private String name;
            private String status;

        }
    }
}
