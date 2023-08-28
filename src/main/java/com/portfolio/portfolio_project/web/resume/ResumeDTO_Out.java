package com.portfolio.portfolio_project.web.resume;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu.ResumeAcademyEdu;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificate;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEdu;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_self_study.ResumeSelfStudy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResumeDTO_Out {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Schooledu_postDTO {
        private String id;
        private String schoolAdmissionDate;
        private String schoolGraduateDate;
        private String schoolGraduateStatus;

        private String schoolName;
        private String schoolMajor;
        private String schoolCredit;

        public static Schooledu_postDTO fromEntity(ResumeSchoolEdu resumeSchoolEdu) {
            return Schooledu_postDTO.builder()
                .id(resumeSchoolEdu.getId())
                .schoolAdmissionDate(resumeSchoolEdu.getSchoolAdmissionDate())
                .schoolGraduateDate(resumeSchoolEdu.getSchoolGraduateDate())
                .schoolGraduateStatus(resumeSchoolEdu.getSchoolGraduateStatus())
                .schoolName(resumeSchoolEdu.getSchoolName())
                .schoolMajor(resumeSchoolEdu.getSchoolMajor())
                .schoolCredit(resumeSchoolEdu.getSchoolCredit())
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AcademyEdu_postDTO {
        private String id;
        private String academyEnrollDate;
        private String academyCompletionDate;
        private String academyCompletionStatus;

        private String academyName;
        private String academyCourse;
        private String academyEtc;

        public static AcademyEdu_postDTO fromEntity(ResumeAcademyEdu resumeAcademyEdu) {
            return AcademyEdu_postDTO.builder()
                .id(resumeAcademyEdu.getId())
                .academyEnrollDate(resumeAcademyEdu.getAcademyEnrollDate())
                .academyCompletionDate(resumeAcademyEdu.getAcademyCompletionDate())
                .academyCompletionStatus(resumeAcademyEdu.getAcademyCompletionStatus())
                .academyName(resumeAcademyEdu.getAcademyName())
                .academyCourse(resumeAcademyEdu.getAcademyCourse())
                .academyEtc(resumeAcademyEdu.getAcademyEtc())
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Certificate_postDTO {
        private String id;
        private String acquisitionDate;
        private String certificateType;
        private String certificateName;
        private String certificateIssuingAgency;
        private String certificateStatus;

        public static Certificate_postDTO fromEntity(ResumeCertificate resumeCertificate) {
            return Certificate_postDTO.builder()
                .acquisitionDate(resumeCertificate.getId())
                .certificateType(resumeCertificate.getCertificateType())
                .certificateName(resumeCertificate.getCertificateName())
                .certificateIssuingAgency(resumeCertificate.getCertificateIssuingAgency())
                .certificateStatus(resumeCertificate.getCertificateStatus())
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Selfstudy_postDTO {
        private String id;
        private String selfStudyDate;
        private String selfStudytype;
        private String selfStudyTheme;
        private String selfStudyPlatform;
        private String selfStudyBloggingLink;

        public static Selfstudy_postDTO fromEntity(ResumeSelfStudy resumeSelfStudy) {
            return Selfstudy_postDTO.builder()
                .selfStudyDate(resumeSelfStudy.getId())
                .selfStudytype(resumeSelfStudy.getSelfStudytype())
                .selfStudyTheme(resumeSelfStudy.getSelfStudyTheme())
                .selfStudyPlatform(resumeSelfStudy.getSelfStudyPlatform())
                .selfStudyBloggingLink(resumeSelfStudy.getSelfStudyBloggingLink())
                .build();
        }
    }
}