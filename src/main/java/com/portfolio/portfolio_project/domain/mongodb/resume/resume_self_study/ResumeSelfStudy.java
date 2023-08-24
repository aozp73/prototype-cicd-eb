package com.portfolio.portfolio_project.domain.mongodb.resume.resume_self_study;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_self_study_tb")
public class ResumeSelfStudy {
// MongoDB는 @Comment, @Column 지원하지 않음
// 가독성을 위해 작성
    @Id
    private String id;

    @Comment("이력 페이지 - 개인학습 시작일")
    @Column(name = "self_study_date")
    private LocalDate selfStudyDate;
    @Comment("이력 페이지 - 개인학습 종류 (ex. 백엔드, linux, 데브옵스 등)")
    @Column(name = "self_study_date")
    private String selfStudytype;
    @Comment("이력 페이지 - 개인학습 주제 (ex. 강의명)")
    @Column(name = "self_study_theme")
    private String selfStudyTheme;
    @Comment("이력 페이지 - 개인학습 수강장소 (ex. 인프런 인터넷 강의)")
    @Column(name = "self_study_platform")
    private String selfStudyPlatform;
    @Comment("이력 페이지 - 개인학습 블로깅 링크")
    @Column(name = "self_study_blogging_link")
    private String selfStudyBloggingLink;

    @Comment("이력 페이지 - 등록 시간")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Comment("이력 페이지 - 수정 시간")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
