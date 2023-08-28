package com.portfolio.portfolio_project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu.ResumeAcademyEdu;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu.ResumeAcademyEduRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificate;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificateRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEdu;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEduRepository;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_self_study.ResumeSelfStudy;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_self_study.ResumeSelfStudyRepository;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_In;
import com.portfolio.portfolio_project.web.resume.ResumeDTO_Out;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeService {
    
    private final ResumeSchoolEduRepository resumeSchoolEduRepository;
    private final ResumeAcademyEduRepository resumeAcademyEduRepository;
    private final ResumeCertificateRepository resumeCertificateRepository;
    private final ResumeSelfStudyRepository resumeSelfStudyRepository;

    @Transactional
    public ResumeDTO_Out.FindAllDTO resume_findAll() {
        List<ResumeSchoolEdu> schoolEdus = resumeSchoolEduRepository.findAll(); 
        List<ResumeAcademyEdu> academyEdus = resumeAcademyEduRepository.findAll();
        List<ResumeCertificate> certificates = resumeCertificateRepository.findAll();
        List<ResumeSelfStudy> selfStudies = resumeSelfStudyRepository.findAll();

        return ResumeDTO_Out.FindAllDTO.fromEntities(academyEdus, certificates, selfStudies, schoolEdus);
    }

    @Transactional
    public ResumeDTO_Out.SchoolEdu_postDTO resume_schooledu_post(ResumeDTO_In.Schooledu_postDTO postDTO_In) {
        ResumeSchoolEdu resumeSchoolEdu = postDTO_In.toEntity();

        resumeSchoolEduRepository.save(resumeSchoolEdu);

        return ResumeDTO_Out.SchoolEdu_postDTO.fromEntity(resumeSchoolEdu);
    }
    @Transactional
    public ResumeDTO_Out.AcademyEdu_postDTO resume_academyedu_post(ResumeDTO_In.Academyedu_postDTO postDTO_In) {
        ResumeAcademyEdu resumeAcademyEdu = postDTO_In.toEntity();

        resumeAcademyEduRepository.save(resumeAcademyEdu);

        return ResumeDTO_Out.AcademyEdu_postDTO.fromEntity(resumeAcademyEdu);
    }
    @Transactional
    public ResumeDTO_Out.Certificate_postDTO resume_certificate_post(ResumeDTO_In.Certificate_postDTO postDTO_In) {
        ResumeCertificate resumeCertificate = postDTO_In.toEntity();

        resumeCertificateRepository.save(resumeCertificate);

        return ResumeDTO_Out.Certificate_postDTO.fromEntity(resumeCertificate);
    }
    @Transactional
    public ResumeDTO_Out.SelfStudy_postDTO resume_selfstudy_post(ResumeDTO_In.Selfstudy_postDTO postDTO_In) {
        ResumeSelfStudy resumeSelfStudy = postDTO_In.toEntity();

        resumeSelfStudyRepository.save(resumeSelfStudy);

        return ResumeDTO_Out.SelfStudy_postDTO.fromEntity(resumeSelfStudy);
    }
}
