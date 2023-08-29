package com.portfolio.portfolio_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio_project.core.exception.Exception400;
import com.portfolio.portfolio_project.core.util.s3_utils.S3Utils;
import com.portfolio.portfolio_project.domain.jpa.myproject.enums.ProjectRole;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProject;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProjectRepository;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role.MyProjectRole;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role.MyProjectRoleRepository;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role_code.MyProjectRoleCode;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role_code.MyProjectRoleCodeRepository;
import com.portfolio.portfolio_project.web.myproject.MyProjectDTO_In;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyProjectService {
    
    private final MyProjectRepository myProjectRepository;
    private final MyProjectRoleRepository myProjectRoleRepository;
    private final MyProjectRoleCodeRepository myProjectRoleCodeRepository;
    private final S3Utils s3Utils;

    @Transactional
    public String main_post(MyProjectDTO_In.postDTO postDTO_In){
        List<String> projectImg_nameAndUrl = s3Utils.uploadImageToS3(postDTO_In.getProjectImgBase64(), 
                                                                     postDTO_In.getProjectImageName(), 
                                                                     postDTO_In.getProjectImageType(),
                                                                     "my_project");
        List<String> individualPerformanceImg_nameAndUrl = s3Utils.uploadImageToS3(postDTO_In.getIndividualPerformanceBase64(), 
                                                                                   postDTO_In.getIndividualPerformanceImageName(), 
                                                                                   postDTO_In.getIndividualPerformanceImageType(),
                                                                                   "my_project_performance");

        // MyProject 엔터티 저장
        MyProject myProject = postDTO_In.toEntity(projectImg_nameAndUrl, individualPerformanceImg_nameAndUrl);
        myProjectRepository.save(myProject);

        // 역할 파싱 및 MyProjectRole 엔터티 저장
        String roles = postDTO_In.getSelectedRoles();
        String[] parsedRoles = roles.split(",");
        
        for(String role : parsedRoles) {
            MyProjectRoleCode roleCodePS = myProjectRoleCodeRepository.findByProjectRole(ProjectRole.valueOf(role.trim())).orElseThrow(() -> {
                throw new Exception400("존재하지 않는 Role입니다.");
            });;
            
            MyProjectRole myProjectRole = MyProjectRole.builder()
                                                        .project(myProject)
                                                        .roleCode(roleCodePS)
                                                        .createdAt(LocalDateTime.now())
                                                        .updatedAt(LocalDateTime.now())
                                                        .build();
            myProjectRoleRepository.save(myProjectRole);
        }

        return "";
    }
}
