package com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import com.portfolio.portfolio_project.domain.jpa.myproject.my_project.MyProject;
import com.portfolio.portfolio_project.domain.jpa.myproject.my_project_role_code.MyProjectRoleCode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "my_project_role_tb")
public class MyProjectRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("어떤 프로젝트의 Role인지")
    @JoinColumn(name = "project_id")
    private MyProject project;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("해당 프로젝트의 roleCode가 무엇인지")
    @JoinColumn(name = "role_code_id")
    private MyProjectRoleCode roleCode;
}