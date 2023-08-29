package com.portfolio.portfolio_project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio_project.core.util.s3_utils.S3Utils;
import com.portfolio.portfolio_project.web.myproject.MyProjectDTO_In;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyProjectService {
    
    private final S3Utils s3Utils;

    @Transactional
    public String main_post(MyProjectDTO_In.postDTO postDTO_In){
        List<String> projectImg_nameAndUrl = s3Utils.uploadImageToS3(postDTO_In.getProjectImgBase64(), 
                                                                     postDTO_In.getProjectImageName(), 
                                                                     postDTO_In.getProjectImageType(),
                                                                     "my_project");
        List<String> individualPerformanceImg_nameAndUrl = s3Utils.uploadImageToS3(postDTO_In.getIndividualPerformanceBase64(), 
                                                                                   postDTO_In.getIndividualPerformanceImageName(), 
                                                                                   postDTO_In.getIndividualPerformanceImageType(),
                                                                                   "my_project_performance");
        postDTO_In.toEntity(projectImg_nameAndUrl, individualPerformanceImg_nameAndUrl);

        return "";
    }
}
