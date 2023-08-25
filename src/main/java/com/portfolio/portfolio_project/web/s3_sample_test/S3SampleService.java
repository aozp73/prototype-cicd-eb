package com.portfolio.portfolio_project.web.s3_sample_test;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class S3SampleService {

    private final AmazonS3Client amazonS3Client;

    @Value("${bucket}")
    private String bucket;
    @Value("${static}")
    private String staticRegion;

    public void S3SampleTest(UpdateInDTO updateInDTO) throws IOException{
        MultipartFile multipartFile2 = BASE64DecodedMultipartFile
                .convertBase64ToMultipartFile(updateInDTO.getImgBase64());

        List<String> nameAndUrl = S3Utils.uploadFile(multipartFile2, "CompanyProfile", bucket, amazonS3Client);
        System.out.println("테스트 : " + nameAndUrl.get(0));
        System.out.println("테스트 : " + nameAndUrl.get(1));
    }
}
