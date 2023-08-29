package com.portfolio.portfolio_project.web.myproject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.MyProjectService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyProjectController {

    private final MyProjectService myProjectService;

    @GetMapping("/project")
    public String projectpage(){
        return "/myproject";
    }

    @PostMapping("/auth/myproject")
    public ResponseEntity<?> myproject_post(@RequestBody MyProjectDTO_In.postDTO postDTO_In){
        MyProjectDTO_Out.PostDTO postDTO_Out = myProjectService.main_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
}
