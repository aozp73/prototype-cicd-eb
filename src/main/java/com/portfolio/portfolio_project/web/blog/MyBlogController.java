package com.portfolio.portfolio_project.web.blog;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;

@Controller
public class MyBlogController {
    
    @GetMapping("/blog")
    public String myblogpage(){
        return "/myblog";
    }

    @PostMapping("/auth/blog")
    public ResponseEntity<?> main_post(@RequestBody MyBlogDTO_In.postDTO postDTO_In){
        System.out.println("테스트 : " + postDTO_In.getPostTitle());
        System.out.println("테스트 : " + postDTO_In.getPostContent());
        System.out.println("테스트 : " + postDTO_In.getPostSubTitle());

        System.out.println("테스트 : " + postDTO_In.getImageName());
        System.out.println("테스트 : " + postDTO_In.getContentType());
        System.out.println("테스트 : " + postDTO_In.getImageData().substring(0, 15));

        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
