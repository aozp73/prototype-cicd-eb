package com.portfolio.portfolio_project.web.resume;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.ResumeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/resume")
    public String resumepage(){
        return "/resume";
    }



    @PostMapping("/auth/resume/schooledu")
    public ResponseEntity<?> resume_schooledu_post(@RequestBody ResumeDTO_In.schooledu_postDTO postDTO_In){
        ResumeDTO_Out.schooledu_postDTO postDTO_Out = resumeService.resume_schooledu_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
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
