package com.portfolio.portfolio_project.web.myproject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;

@Controller
public class MyProjectController {

    @GetMapping("/project")
    public String projectpage(){
        return "/myproject";
    }

    @PostMapping("/auth/myproject")
    public ResponseEntity<?> myproject_post(@RequestBody MyProjectDTO_In.postDTO postDTO_In){
        // System.out.println("테스트 : " + postDTO_In.getProjectImgBase64());
        // System.out.println("테스트 : " + postDTO_In.getIndividualPerformanceBase64());
        
        System.out.println("테스트 : " + postDTO_In.getIndividualPerformanceImageName());
        System.out.println("테스트 : " + postDTO_In.getIndividualPerformanceImageType());
        System.out.println("테스트 : " + postDTO_In.getProjectImageName());
        System.out.println("테스트 : " + postDTO_In.getProjectImageType());
        System.out.println();
        System.out.println("테스트 : " + postDTO_In.getProjectName());
        System.out.println("테스트 : " + postDTO_In.getStartDate());
        System.out.println("테스트 : " + postDTO_In.getEndDate());
        System.out.println("테스트 : " + postDTO_In.getGithubUrl());
        System.out.println("테스트 : " + postDTO_In.getReadmeUrl());
        System.out.println();
        System.out.println("테스트 : " + postDTO_In.getSelectedRoles());
        System.out.println("테스트 : " + postDTO_In.getMembers());

        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
