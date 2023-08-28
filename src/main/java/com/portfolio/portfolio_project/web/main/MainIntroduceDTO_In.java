package com.portfolio.portfolio_project.web.main;

import java.time.LocalDateTime;

import com.portfolio.portfolio_project.domain.jpa.main.main_introduce.MainIntroduce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MainIntroduceDTO_In {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class postDTO {
        private String postTitle;
        private String postContent;
        private String imageName;
        private String contentType;
        private String imageData;

        public MainIntroduce toEntity() {
            return MainIntroduce.builder()
                .title(this.postTitle)
                .content(this.postContent)
                .createdAt(LocalDateTime.now()) 
                .updatedAt(LocalDateTime.now()) 
                .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class putDTO {
        private Long id;
        private String postTitle;
        private String postContent;
        private String imageName;
        private String contentType;
        private String imageData;
        private Boolean imgChangeCheck;

        public void putEntity(MainIntroduce mainIntroduce, putDTO putDTO) {
            mainIntroduce.setTitle(putDTO.getPostTitle());
            mainIntroduce.setContent(putDTO.getPostContent());
            mainIntroduce.setUpdatedAt(LocalDateTime.now());
        }   
    }
}