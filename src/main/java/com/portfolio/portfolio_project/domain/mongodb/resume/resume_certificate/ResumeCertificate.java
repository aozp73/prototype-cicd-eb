package com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "resume_certificate_tb")
public class ResumeCertificate {
    @Id
    private String id;

    @Comment("이력 페이지 - 자격증 취득일")
    @Field("acquisition_date")
    private String acquisitionDate;

    @Comment("이력 페이지 - 자격증 종류")
    @Field("certificate_type")
    private String certificate_type;
    @Comment("이력 페이지 - 자격증명")
    @Field("certificate_name")
    private String certificate_name;
    @Comment("이력 페이지 - 자격증 발행처")
    @Field("certificate_issuing_agency")
    private String certificateIssuingAgency;

    @Comment("이력 페이지 - 자격증 취득상태 (ex. 필기합격, 최종합격)")
    @Field("certificate_status")
    private String certificateStatus;

    @Comment("이력 페이지 - 등록 시간")
    @Field("created_at")
    private String createdAt;
    @Comment("이력 페이지 - 수정 시간")
    @Field("updated_at")
    private String updatedAt;
}