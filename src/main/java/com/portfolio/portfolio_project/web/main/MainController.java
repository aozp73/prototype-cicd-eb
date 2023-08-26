package com.portfolio.portfolio_project.web.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainpage(){
        return "/main";
    }

    @PostMapping("/auth/main")
    public ResponseEntity<?> main_post(@RequestBody MainIntroduceDTO_In.postDTO postDTO){
        System.out.println("테스트 : " + postDTO.getPostTitle());
        System.out.println("테스트 : " + postDTO.getPostContent());
        System.out.println("테스트 : " + postDTO.getImageName());
        System.out.println("테스트 : " + postDTO.getContentType());
        
        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
