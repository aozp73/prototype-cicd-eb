package com.portfolio.portfolio_project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.portfolio.portfolio_project.core.exception.Exception500;
import com.portfolio.portfolio_project.core.util.s3_utils.BASE64DecodedMultipartFile;
import com.portfolio.portfolio_project.core.util.s3_utils.S3Utils;
import com.portfolio.portfolio_project.domain.jpa.main.main_introduce.MainIntroduceRepository;
import com.portfolio.portfolio_project.web.main.MainIntroduceDTO_In;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainIntroduceService {
    
    private final MainIntroduceRepository mainIntroduceRepository;
    private final AmazonS3Client amazonS3Client;

    @Value("${bucket}")
    private String bucket;
    @Value("${static}")
    private String staticRegion;

    public void main_post(MainIntroduceDTO_In.postDTO postDTO){
        MultipartFile multipartFile2;
        try {
            multipartFile2 = BASE64DecodedMultipartFile
                .convertBase64ToMultipartFile(postDTO.getImageData(), postDTO.getImageName(), postDTO.getContentType());
        } catch (Exception e) {
            throw new Exception500("MultiPartFIle 변환에 실패하였습니다. :" + e.getStackTrace());
        }

        List<String> nameAndUrl = new ArrayList<>();
        try {
            nameAndUrl = S3Utils.uploadFile(multipartFile2, "main_introduce", bucket, amazonS3Client);
        } catch (IOException e) {
            throw new Exception500("S3 File 업로드에 실패하였습니다.");
        }
        System.out.println("name : " + nameAndUrl.get(0));
        System.out.println("Url : " + nameAndUrl.get(1));

    }
}
