package com.portfolio.portfolio_project.domain.resume.resume_school_edu;

import java.time.LocalDate;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_school_edu_tb")
public class ResumeSchoolEdu {
    @Id
    private String id;
    private LocalDate admissionDate;
    private LocalDate graduateDate;
    private String graduateStatus;
    private String school;
    private String major;
    private String credit;
}
