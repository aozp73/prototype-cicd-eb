package com.portfolio.portfolio_project.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    
    @GetMapping("/blog")
    public String blogpage(){
        return "/blog";
    }
}
