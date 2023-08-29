package com.portfolio.portfolio_project.core.util.myproject_utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.portfolio.portfolio_project.core.exception.Exception400;
import com.portfolio.portfolio_project.domain.jpa.myproject.enums.ProjectRole;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProject;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role.MyProjectRole;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role.MyProjectRoleRepository;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role_code.MyProjectRoleCode;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role_code.MyProjectRoleCodeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MyProjectUtils {
    private final MyProjectRoleRepository myProjectRoleRepository;
    private final MyProjectRoleCodeRepository myProjectRoleCodeRepository;


    public void saveRolesForProject(String roles, MyProject myProject) {

        String[] parsedRoles = roles.split(",");
        
        for(String role : parsedRoles) {
            MyProjectRoleCode roleCodePS = myProjectRoleCodeRepository.findByProjectRole(ProjectRole.valueOf(role.trim()))
                                                                    .orElseThrow(() -> {
                                                                        throw new Exception400("존재하지 않는 Role입니다.");
                                                                    });

            MyProjectRole myProjectRole = MyProjectRole.builder()
                                                        .project(myProject)
                                                        .roleCode(roleCodePS)
                                                        .createdAt(LocalDateTime.now())
                                                        .updatedAt(LocalDateTime.now())
                                                        .build();
            myProjectRoleRepository.save(myProjectRole);
    
        }
    }
}
