package com.portfolio.portfolio_project.web.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String resumepage(){
        return "/resume";
    }

    @PostMapping("/auth/resume/schooledu")
    public void resume_schooledu_post(@RequestBody ResumeDTO_In.schooledu_postDTO postDTO){

    }
    @PostMapping("/auth/resume/academyedu")
    public void resume_academyedu_post(@RequestBody ResumeDTO_In.academyedu_postDTO postDTO){

    }
    @PostMapping("/auth/resume/certificate")
    public void resume_certificate_post(@RequestBody ResumeDTO_In.certificate_postDTO postDTO){

    }
    @PostMapping("/auth/resume/selfstudy")
    public void resume_selfstudy_post(@RequestBody ResumeDTO_In.selfstudy_postDTO postDTO){

    }
}
