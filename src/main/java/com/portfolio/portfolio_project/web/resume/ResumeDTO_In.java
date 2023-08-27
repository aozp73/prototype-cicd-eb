package com.portfolio.portfolio_project.web.resume;

import java.time.LocalDate;
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
                    .schoolAdmissionDate(LocalDate.parse(values.get(0)))  // 학교 입학일
                    .schoolGraduateDate(LocalDate.parse(values.get(1)))  // 학교 졸업일
                    .schoolGraduateStatus(values.get(2))  // 졸업구분
                    .schoolName(values.get(3))  // 학교명
                    .schoolMajor(values.get(4))  // 전공명
                    .schoolCredit(values.get(5))  // 학점
                    .createdAt(LocalDateTime.now())  // 현재 시간
                    .updatedAt(LocalDateTime.now())  // 현재 시간
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