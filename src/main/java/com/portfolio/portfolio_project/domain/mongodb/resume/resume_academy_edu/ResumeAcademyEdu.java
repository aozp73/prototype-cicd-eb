package com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import org.springframework.data.annotation.Id;

import org.hibernate.annotations.Comment;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_academy_edu_tb")
public class ResumeAcademyEdu {
// MongoDB는 @Comment, @Column 지원하지 않음
// 가독성을 위해 작성
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

    @Comment("이력 페이지 - 등록 시간")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Comment("이력 페이지 - 수정 시간")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
