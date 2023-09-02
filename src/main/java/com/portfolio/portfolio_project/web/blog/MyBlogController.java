package com.portfolio.portfolio_project.web.blog;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.MyBlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyBlogController {
    
    private final MyBlogService myBlogService;

    @GetMapping("/blog")
    public String myblogpage(){
        return "/myblog";
    }

    @PostMapping("/auth/blog")
    public ResponseEntity<?> main_post(@RequestBody MyBlogDTO_In.postDTO postDTO_In){
        myBlogService.myBlog_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
