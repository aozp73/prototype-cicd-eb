package com.portfolio.portfolio_project.web.myproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MyProjectDTO_In {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class postDTO {
        // 프로젝트명, 인원, 날짜 정보
        private String projectName;
        private Integer members;
        private String startDate;
        private String endDate;

        // 수행 역할 정보 (BackEnd,FrontEnd,DevOps 형식)
        private String selectedRoles;

        // url
        private String readmeUrl;
        private String githubUrl;

        // 프로젝트, 개인수행 이미지 정보
        private String projectImgBase64;
        private String individualPerformanceBase64;
        private String projectImageName;
        private String projectImageType;
        private String individualPerformanceImageName;
        private String individualPerformanceImageType;
    }
}
