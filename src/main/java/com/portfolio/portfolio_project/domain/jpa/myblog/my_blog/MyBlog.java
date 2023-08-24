package com.portfolio.portfolio_project.domain.jpa.myblog.my_blog;

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
@Table(name = "my_blog_tb")
public class MyBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("블로그 - 메인 제목")
    @Column(name = "main_title")
    private String mainTitle;
    @Comment("블로그 - 서브 제목")
    @Column(name = "sub_title")
    private String subTitle;
    @Comment("블로그 - 게시글 내용")
    @Column(name = "")
    private String content;

    @Comment("블로그 - 게시글 이미지 이름")
    @Column(name = "blog_img_name")
    private String blogImgName;
    @Comment("블로그 - S3 또는 저장된 장소")
    @Column(name = "blog_img_url")
    private String blogImgUrl;
}