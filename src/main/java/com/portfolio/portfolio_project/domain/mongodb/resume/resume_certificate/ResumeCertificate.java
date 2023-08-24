package com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate;

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
@Document(collection = "resume_certificate_tb")
public class ResumeCertificate {
// MongoDB는 @Comment, @Column 지원하지 않음
// 가독성을 위해 작성
    @Id
    private String id;

    @Comment("이력 페이지 - 자격증 취득일")
    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @Comment("이력 페이지 - 자격증 종류")
    @Column(name = "certificate_type")
    private String certificate_type;
    @Comment("이력 페이지 - 자격증명")
    @Column(name = "certificate_name")
    private String certificate_name;
    @Comment("이력 페이지 - 자격증 발행처")
    @Column(name = "certificate_issuing_agency")
    private String certificateIssuingAgency;

    @Comment("이력 페이지 - 자격증 취득상태 (ex. 필기합격, 최종합격)")
    @Column(name = "certificate_status")
    private String certificateStatus;

    @Comment("이력 페이지 - 등록 시간")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Comment("이력 페이지 - 수정 시간")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}