package com.portfolio.portfolio_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String resumepage(){
        return "/resume";
    }
}
