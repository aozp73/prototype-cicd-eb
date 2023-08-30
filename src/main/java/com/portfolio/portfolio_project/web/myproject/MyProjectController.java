package com.portfolio.portfolio_project.web.myproject;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.MyProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyProjectController {

    private final MyProjectService myProjectService;

    // FindAll
    @GetMapping("/project")
    public String projectpage(Model model){
        List<MyProjectDTO_Out.FindAllDTO> myProjectList = myProjectService.findAllProjectsAndRoles();
        model.addAttribute("myProjectList", myProjectList);

        return "/myproject";
    }

    @PostMapping("/auth/myproject")
    public ResponseEntity<?> myproject_post(@RequestBody MyProjectDTO_In.postDTO postDTO_In){
        MyProjectDTO_Out.PostDTO postDTO_Out = myProjectService.myProject_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }

    @PutMapping("/auth/myproject")
    public ResponseEntity<?> myproject_put(@RequestBody MyProjectDTO_In.putDTO putDTO_In){
        System.out.println("테스트 : " + putDTO_In.getEndDate());
        System.out.println("테스트 : " + putDTO_In.getGithubUrl());
        System.out.println("테스트 : " + putDTO_In.getMembers());
        System.out.println("테스트 : " + putDTO_In.getProjectName());
        System.out.println("테스트 : " + putDTO_In.getReadmeUrl());
        System.out.println("테스트 : " + putDTO_In.getStartDate());
        System.out.println("테스트 : " + putDTO_In.getSelectedRoles().get(0));
        System.out.println("테스트 : " + putDTO_In.getSelectedRoles().get(1));
        System.out.println("테스트 00: " + putDTO_In.getHasRolesChanged());
        System.out.println();
        System.out.println("테스트 11: " + putDTO_In.getFeatureImageDetails().getContentType());
        System.out.println("테스트 11: " + putDTO_In.getFeatureImageDetails().getImageName());
        System.out.println("테스트 11: " + putDTO_In.getFeatureImageDetails().getImageSrc().substring(0, 5));
        System.out.println("테스트 11: " + putDTO_In.getFeatureImageDetails().getImgChangeCheck());
        System.out.println();
        System.out.println("테스트 22: " + putDTO_In.getProjectImageDetails().getContentType());
        System.out.println("테스트 22: " + putDTO_In.getProjectImageDetails().getImageName());
        System.out.println("테스트 22: " + putDTO_In.getProjectImageDetails().getImageSrc().substring(0, 5));
        System.out.println("테스트 22: " + putDTO_In.getProjectImageDetails().getImgChangeCheck());

        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
