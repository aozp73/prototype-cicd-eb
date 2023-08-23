package com.portfolio.portfolio_project.web.skills;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SkillsController {

    @GetMapping("/skills")
    public String skillspage(){
        return "/skills";
    }
}
