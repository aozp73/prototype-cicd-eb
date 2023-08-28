package com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate;

import org.springframework.data.mongodb.repository.Query;

import com.portfolio.portfolio_project.core.util.order_utils.OrderableRepository;

public interface ResumeCertificateRepository extends OrderableRepository<ResumeCertificate, String> {
    @Query(sort = "{'order' : -1}")
    ResumeCertificate findTopByOrderByOrderDesc();
}