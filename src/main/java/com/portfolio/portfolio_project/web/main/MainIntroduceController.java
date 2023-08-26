package com.portfolio.portfolio_project.web.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.MainIntroduceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainIntroduceController {

    private final MainIntroduceService mainIntroduceService;

    @GetMapping("/main")
    public String mainpage(){
        return "/main";
    }

    @PostMapping("/auth/main")
    public ResponseEntity<?> main_post(@RequestBody MainIntroduceDTO_In.postDTO postDTO_In){
        MainIntroduceDTO_Out.postDTO postDTO_Out = mainIntroduceService.main_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
}
