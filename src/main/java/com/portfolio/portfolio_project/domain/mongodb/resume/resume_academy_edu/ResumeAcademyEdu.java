package com.portfolio.portfolio_project.domain.mongodb.resume.resume_academy_edu;

import java.time.LocalDate;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_academy_edu_tb")
public class ResumeAcademyEdu {
    @Id
    private String id;
    private LocalDate enrollDate;
    private LocalDate completionDate;
    private String completionStatus;
    private String academy;
    private String course;
    private String etc;
}
