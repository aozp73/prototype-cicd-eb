package com.portfolio.portfolio_project.domain.jpa.myproject.my_project;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "my_project_tb")
public class MyProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Comment("프로젝트 페이지 - 저장된 사진 이름")
    @Column(name = "project_img_name")
    private String projectImgName;

    @Comment("프로젝트 페이지 - S3 또는 저장된 장소")
    @Column(name = "project_img_url")    
    private String projectImgUrl;

    @Comment("프로젝트 페이지 - 프로젝트 제목")
    @Column(name = "title")
    private String title;

    @Comment("프로젝트 페이지 - 프로젝트 참여인원")
    @Column(name = "member")
    private int member;

    @Comment("프로젝트 페이지 - 프로젝트 시작일")
    @Column(name = "start_date")
    private LocalDate startDate;
    @Comment("프로젝트 페이지 - 프로젝트 종료일")
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Comment("프로젝트 페이지 - README 링크")
    @Column(name = "readme_link")
    private String readmeLink;
    @Comment("프로젝트 페이지 - 프로젝트 Github 링크")
    @Column(name = "github_link")
    private String githubLink;
    
    @Comment("프로젝트 페이지 - 개인 수행 사진 이름")
    @Column(name = "individual_performance_img_name")
    private String individualPerformanceImgName;
    @Comment("프로젝트 페이지 - S3 또는 저장된 장소")
    @Column(name = "individual_performance_img_url")
    private String individualPerformanceImgUrl;

}
