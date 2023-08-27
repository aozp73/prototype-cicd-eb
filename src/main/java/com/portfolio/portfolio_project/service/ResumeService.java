package com.portfolio.portfolio_project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEdu;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEduRepository;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_Out;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeService {
    
    private final ResumeSchoolEduRepository resumeSchoolEduRepository;

    @Transactional
    public ResumeDTO_Out.schooledu_postDTO resume_schooledu_post(ResumeDTO_In.schooledu_postDTO postDTO_In) {
        ResumeSchoolEdu resumeSchoolEdu = postDTO_In.toEntity();
        System.out.println("테스트 : " + resumeSchoolEdu.getSchoolAdmissionDate());
        System.out.println("테스트 : " + resumeSchoolEdu.getUpdatedAt());
        resumeSchoolEduRepository.save(resumeSchoolEdu);

        return ResumeDTO_Out.schooledu_postDTO.fromEntity(resumeSchoolEdu);
    }
}
