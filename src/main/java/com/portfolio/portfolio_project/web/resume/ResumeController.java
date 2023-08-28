package com.portfolio.portfolio_project.web.resume;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.portfolio.portfolio_project.core.dto.ResponseDTO;
import com.portfolio.portfolio_project.service.ResumeService;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_Out.FindAllDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping("/resume")
    public String resumepage(Model model){
        FindAllDTO resumeAllDTO = resumeService.resume_findAll();
        model.addAttribute("resumeAllDTO", resumeAllDTO);
        
        return "/resume";
    }

    @PostMapping("/auth/resume/schooledu")
    public ResponseEntity<?> resume_schooledu_post(@RequestBody ResumeDTO_In.Schooledu_postDTO postDTO_In){
        ResumeDTO_Out.SchoolEdu_postDTO postDTO_Out = resumeService.resume_schooledu_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
    @PostMapping("/auth/resume/academyedu")
    public ResponseEntity<?> resume_academyedu_post(@RequestBody ResumeDTO_In.Academyedu_postDTO postDTO_In){
        ResumeDTO_Out.AcademyEdu_postDTO postDTO_Out = resumeService.resume_academyedu_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
    @PostMapping("/auth/resume/certificate")
    public ResponseEntity<?> resume_certificate_post(@RequestBody ResumeDTO_In.Certificate_postDTO postDTO_In){
        ResumeDTO_Out.Certificate_postDTO postDTO_Out = resumeService.resume_certificate_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
    @PostMapping("/auth/resume/selfstudy")
    public ResponseEntity<?> resume_selfstudy_post(@RequestBody ResumeDTO_In.Selfstudy_postDTO postDTO_In){
        ResumeDTO_Out.SelfStudy_postDTO postDTO_Out = resumeService.resume_selfstudy_post(postDTO_In);

        return ResponseEntity.ok().body(new ResponseDTO<>().data(postDTO_Out));
    }
}
