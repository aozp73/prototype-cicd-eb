package com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Comment;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_school_edu_tb")
public class ResumeSchoolEdu {
    @Id
    private String id;

    @Comment("이력 페이지 - 학교 입학일")
    @Column(name = "school_admission_date")
    private LocalDate SchoolAdmissionDate;
    @Comment("이력 페이지 - 학교 졸업일")
    @Column(name = "school_graduate_date")
    private LocalDate SchoolGraduateDate;
    @Comment("이력 페이지 - 졸업구분")
    @Column(name = "school_graduate_status")
    private String SchoolGraduateStatus;

    @Comment("이력 페이지 - 학교명")
    @Column(name = "school_name")
    private String SchoolName;
    @Comment("이력 페이지 - 전공명")
    @Column(name = "school_major")
    private String SchoolMajor;
    @Comment("이력 페이지 - 학점")
    @Column(name = "school_credit")
    private String SchoolCredit;
}
