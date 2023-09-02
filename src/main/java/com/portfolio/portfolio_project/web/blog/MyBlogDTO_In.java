package com.portfolio.portfolio_project.web.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MyBlogDTO_In {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class postDTO {
        private String postTitle;
        private String postSubTitle;
        private String postContent;

        private String imageName;
        private String contentType;
        private String imageData;
    }
}
