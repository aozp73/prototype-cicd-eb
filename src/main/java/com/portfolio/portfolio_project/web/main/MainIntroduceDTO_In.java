package com.portfolio.portfolio_project.web.main;

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
    }
}
