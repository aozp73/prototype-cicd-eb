package com.portfolio.portfolio_project.domain.jpa.skills.my_skill_type_code;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import com.portfolio.portfolio_project.domain.jpa.skills.enums.SkillType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "my_skill_type_tb")
public class MySkillTypeCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("BackEnd, FrontEnd, DevOps, ETC")
    @Enumerated(EnumType.STRING)
    @Column(name = "skill_type")
    private SkillType skillType;
}