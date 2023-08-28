package com.portfolio.portfolio_project.domain.mongodb.resume.resume_school_edu;

import org.springframework.data.mongodb.repository.Query;

import com.portfolio.portfolio_project.core.util.order_utils.OrderableRepository;

public interface ResumeSchoolEduRepository extends OrderableRepository<ResumeSchoolEdu, String> {
    @Query(sort = "{'order' : -1}")
    ResumeSchoolEdu findTopByOrderByOrderDesc();
}