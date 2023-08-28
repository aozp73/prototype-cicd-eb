package com.portfolio.portfolio_project.web.resume;

import java.time.LocalDateTime;
import java.util.List;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu.ResumeSchoolEdu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResumeDTO_In {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class schooledu_postDTO {
        private List<String> values;

        public ResumeSchoolEdu toEntity() {
            return ResumeSchoolEdu.builder()
                    .schoolAdmissionDate(values.get(0))
                    .schoolGraduateDate(values.get(1))
                    .schoolGraduateStatus(values.get(2))
                    .schoolName(values.get(3))
                    .schoolMajor(values.get(4))
                    .schoolCredit(values.get(5))
                    .createdAt(LocalDateTime.now().toString())
                    .updatedAt(LocalDateTime.now().toString())
                    .build();
        }
    }
    @Getter
    @Setter
    public static class academyedu_postDTO {
        private List<String> values;
    }
    @Getter
    @Setter
    public static class certificate_postDTO {
        private List<String> values;
    }
    @Getter
    @Setter
    public static class selfstudy_postDTO {
        private List<String> values;
    }
}