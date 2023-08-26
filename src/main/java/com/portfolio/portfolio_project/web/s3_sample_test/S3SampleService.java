package com.portfolio.portfolio_project.web.s3_sample_test;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.portfolio.portfolio_project.core.util.s3_utils.BASE64DecodedMultipartFile;
import com.portfolio.portfolio_project.core.util.s3_utils.S3Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class S3SampleService {

    private final AmazonS3Client amazonS3Client;

    @Value("${bucket}")
    private String bucket;
    @Value("${static}")
    private String staticRegion;

    public void S3SampleTest(UpdateInDTO updateInDTO) throws Exception{
        MultipartFile multipartFile2 = BASE64DecodedMultipartFile
                .convertBase64ToMultipartFile(updateInDTO.getImgBase64(), updateInDTO.fileName, updateInDTO.fileContentType);

        List<String> nameAndUrl = S3Utils.uploadFile(multipartFile2, "main_introduce", bucket, amazonS3Client);
        System.out.println("name : " + nameAndUrl.get(0));
        System.out.println("Url : " + nameAndUrl.get(1));
    }
}
