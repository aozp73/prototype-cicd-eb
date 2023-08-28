package com.portfolio.portfolio_project.web.resume;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEdu;

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
    public static class schooledu_postDTO {
        private String id;
        private String schoolAdmissionDate;
        private String schoolGraduateDate;
        private String schoolGraduateStatus;

        private String schoolName;
        private String schoolMajor;
        private String schoolCredit;

        public static schooledu_postDTO fromEntity(ResumeSchoolEdu resumeSchoolEdu) {
            return schooledu_postDTO.builder()
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
}