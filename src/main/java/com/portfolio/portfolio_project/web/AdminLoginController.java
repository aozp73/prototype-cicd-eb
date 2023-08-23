package com.portfolio.portfolio_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {
    
    @GetMapping("/login")
    public String logigForm(){
        return "adminlogin";
    }
    @GetMapping("/auth/main")
    public String tes(){
        return "main";
    }
}
