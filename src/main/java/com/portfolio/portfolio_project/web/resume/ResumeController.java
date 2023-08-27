package com.portfolio.portfolio_project.web.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String resumepage(){
        return "/resume";
    }

    @GetMapping("/auth/resume/schooledu")
    public void resume_schooledu_post(){

    }
    @GetMapping("/auth/resume/academyedu")
    public void resume_academyedu_post(){
        
    }
    @GetMapping("/auth/resume/certificate")
    public void resume_certificate_post(){
        
    }
    @GetMapping("/auth/resume/selfstudy")
    public void resume_selfstudy_post(){
        
    }
}
