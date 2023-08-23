package com.portfolio.portfolio_project.domain.resume.resume_certificate;

import java.time.LocalDate;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "resume_certificate_tb")
public class ResumeCertificate {
    @Id
    private String id;
    private LocalDate acquisitionDate;
    private String type;
    private String name;
    private String issuingAgency;
    private String status;
}