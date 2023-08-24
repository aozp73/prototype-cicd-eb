package com.portfolio.portfolio_project.repository_test.mongodb_repository_test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;

import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificate;
import com.portfolio.portfolio_project.domain.mongodb.resume.resume_certificate.ResumeCertificateRepository;

@DataMongoTest
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yml"})
public class ResumeCertificateRepositoryTest {

    @Autowired
    private ResumeCertificateRepository resumeCertificateRepository;

    @BeforeEach
    public void init() {
        resumeCertificateRepository.deleteAll();
        setUp();
    }

    @AfterEach
    public void clean() {
        resumeCertificateRepository.deleteAll();
    }

    @Test
    void findAllTest() {
        List<ResumeCertificate> allCertificates = resumeCertificateRepository.findAll();
        Assertions.assertEquals(2, allCertificates.size());
    }

    @Test
    void findByIdAndUpdateTest() {
        List<ResumeCertificate> allCertificates = resumeCertificateRepository.findAll();
        ResumeCertificate firstCert = allCertificates.get(0);
        
        firstCert.setCertificate_type("update 테스트");
        resumeCertificateRepository.save(firstCert);

        Optional<ResumeCertificate> updatedCertOpt = resumeCertificateRepository.findById(firstCert.getId());
        
        if (updatedCertOpt.isPresent()) {
            ResumeCertificate updatedCert = updatedCertOpt.get();
            Assertions.assertEquals("update 테스트", updatedCert.getCertificate_type());
        } else {
            Assertions.fail("Select 테스트 에러");
        }
    }

    @Test
    void insertAndDeleteTest() {
        ResumeCertificate cert3 = ResumeCertificate.builder()
            .acquisitionDate(LocalDate.of(2021, 7, 1))
            .certificate_type("IT 자격증")
            .certificate_name("정보처리기사")
            .certificateIssuingAgency("한국산업인력공단")
            .certificateStatus("필기합격")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
        
        ResumeCertificate savedCert = resumeCertificateRepository.save(cert3);
        
        Optional<ResumeCertificate> retrievedCert = resumeCertificateRepository.findById(savedCert.getId());
        
        if (retrievedCert.isPresent()) {
            resumeCertificateRepository.deleteById(savedCert.getId());
            Optional<ResumeCertificate> deletedCert = resumeCertificateRepository.findById(savedCert.getId());
            Assertions.assertTrue(deletedCert.isEmpty());
        } else {
            Assertions.fail("Insert 테스트 에러");
        }
    }

    public void setUp() {
        ResumeCertificate cert1 = ResumeCertificate.builder()
            .acquisitionDate(LocalDate.of(2022, 1, 1))
            .certificate_type("IT 자격증")
            .certificate_name("SQLD")
            .certificateIssuingAgency("데이터베이스진흥원")
            .certificateStatus("최종합격")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
        
        ResumeCertificate cert2 = ResumeCertificate.builder()
            .acquisitionDate(LocalDate.of(2021, 3, 1))
            .certificate_type("어학 자격증")
            .certificate_name("TOEIC (830)")
            .certificateIssuingAgency("한국TOEIC위원회")
            .certificateStatus("최종합격")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        resumeCertificateRepository.save(cert1);
        resumeCertificateRepository.save(cert2);
    }
}
