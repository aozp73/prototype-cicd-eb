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
                .introduceImgName(this.imageName)
                .introduceImgUrl("") 
                .title(this.postTitle)
                .content(this.postContent)
                .createdAt(LocalDateTime.now()) 
                .updatedAt(LocalDateTime.now()) 
                .build();
        }
    }
}
