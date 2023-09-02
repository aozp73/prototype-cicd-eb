package com.portfolio.portfolio_project.web.blog;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.MyBlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyBlogController {
    
    private final MyBlogService myBlogService;

    // FindAll
    @GetMapping("/blog")
    public String myblogpage(Model model){
        List<MyBlogDTO_Out.FindAllDTO> myBlogList = myBlogService.myBlog_findAll();
         model.addAttribute("myBlogList", myBlogList);

        return "/myblog";
    }

    // POST
    @PostMapping("/auth/blog")
    public ResponseEntity<?> main_post(@RequestBody MyBlogDTO_In.postDTO postDTO_In){
        MyBlogDTO_Out.PostDTO postDTO_Out = myBlogService.myBlog_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }

    // PUT
    @PutMapping("/auth/blog")
    public ResponseEntity<?> main_put(@RequestBody MyBlogDTO_In.putDTO putDTO_In){
        System.out.println("테스트 : " + putDTO_In.getId());
        System.out.println("테스트 : " + putDTO_In.getMainTitle());
        System.out.println("테스트 : " + putDTO_In.getSubTitle());
        System.out.println("테스트 : " + putDTO_In.getContent());
        System.out.println();
        System.out.println("테스트 : " + putDTO_In.getContentType());
        System.out.println("테스트 : " + putDTO_In.getImageData());
        System.out.println("테스트 : " + putDTO_In.getImageName());
        System.out.println("테스트 : " + putDTO_In.getImgChangeCheck());

        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
