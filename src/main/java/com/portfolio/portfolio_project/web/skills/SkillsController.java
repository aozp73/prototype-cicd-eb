package com.portfolio.portfolio_project.web.skills;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;

@Controller
public class SkillsController {

    @GetMapping("/skills")
    public String skillspage(){
        return "/skills";
    }

    @PostMapping("/auth/skills")
    public ResponseEntity<?> skills_post(@RequestBody SkillsDTO_In.PostDTO postDTO_In){
        System.out.println("테스트 : " + postDTO_In.getBackEnd().get(0).getName());
        System.out.println("테스트 : " + postDTO_In.getFrontEnd().get(0).getStatus());
        System.out.println("테스트 : " + postDTO_In.getDevOps().get(0).getName());
        System.out.println("테스트 : " + postDTO_In.getETC().get(0).getStatus());
        
        
        return ResponseEntity.ok().body(new ResponseDTO<>().data(""));
    }
}
