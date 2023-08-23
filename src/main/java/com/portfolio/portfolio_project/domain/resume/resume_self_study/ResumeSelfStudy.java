package com.portfolio.portfolio_project.domain.resume.resume_self_study;

import java.time.LocalDate;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_self_study_tb")
public class ResumeSelfStudy {
    @Id
    private String id;
    private LocalDate studyDate;
    private String type;
    private String studyTheme;
    private String studyPlatform;
    private String bloggingLink;
}
