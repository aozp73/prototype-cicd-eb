package com.portfolio.portfolio_project.web.myproject;

import java.util.List;
import java.util.stream.Collectors;

import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProject;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role.MyProjectRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MyProjectDTO_Out {
    
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostDTO {
        private Long id;

        // 프로젝트명, 인원, 날짜 정보
        private String projectName;
        private Integer member;
        private String startDate;
        private String endDate;

        // 수행 역할 정보 (BackEnd,FrontEnd,DevOps 형식)
        private List<String> selectedRoles;

        // readme, github 주소
        private String readmeUrl;
        private String githubUrl;

        // 프로젝트, 개인수행 이미지 URL
        private String projectImgURL;
        private String individualPerformanceImageNameURL;

        public static MyProjectDTO_Out.PostDTO fromEntity(MyProject myProjectPS, List<MyProjectRole> myProjectRoles){
            List<String> selectedRoles = myProjectRoles.stream()
                .map(myProjectRole -> {
                    Long roleCodeLong = myProjectRole.getRoleCode().getId();
                    int roleCode = roleCodeLong.intValue();
                    switch (roleCode) {
                        case 1:
                            return "BackEnd";
                        case 2:
                            return "FrontEnd";
                        case 3:
                            return "DevOps";
                        default:
                            return "Unknown";
                    }
                })
                .collect(Collectors.toList());

            return MyProjectDTO_Out.PostDTO.builder()
                .id(myProjectPS.getId())
                .projectName(myProjectPS.getProjectName())
                .member(myProjectPS.getMember())
                .startDate(myProjectPS.getStartDate().toString())
                .endDate(myProjectPS.getEndDate().toString())
                .selectedRoles(selectedRoles)
                .readmeUrl(myProjectPS.getReadmeUrl())
                .githubUrl(myProjectPS.getGithubUrl())
                .projectImgURL(myProjectPS.getProjectImgUrl())
                .individualPerformanceImageNameURL(myProjectPS.getIndividualPerformanceImgUrl())
                .build();
        }
    }
}
