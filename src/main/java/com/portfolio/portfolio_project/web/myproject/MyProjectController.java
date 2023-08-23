package com.portfolio.portfolio_project.web.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProjectController {

    @GetMapping("/project")
    public String projectpage(){
        return "/myproject";
    }
}
