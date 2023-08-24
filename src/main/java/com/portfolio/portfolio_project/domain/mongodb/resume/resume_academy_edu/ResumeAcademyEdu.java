package com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Comment;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_academy_edu_tb")
public class ResumeAcademyEdu {
    @Id
    private String id;

    @Comment("이력 페이지 - 교육 시작일")
    @Column(name = "academy_enroll_date")
    private LocalDate academyEnrollDate;
    @Comment("이력 페이지 - 교육 수료일")
    @Column(name = "academy_completion_date")
    private LocalDate academyCompletionDate;
    
    @Comment("이력 페이지 - 교육 수료상태")
    @Column(name = "academy_completion_status")
    private String academyCompletionStatus;
    @Comment("이력 페이지 - 교육장소")
    @Column(name = "academy_name")
    private String academyName;
    @Comment("이력 페이지 - 교육과정명")
    @Column(name = "academy_course")
    private String academyCourse;
    @Comment("이력 페이지 - 기타내용")
    @Column(name = "academy_etc")
    private String academyEtc;
}
