package com.portfolio.portfolio_project.web.blog;

import java.time.LocalDateTime;

import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlog;

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
        private String mainTitle;
        private String content;
        private String subTitle;

        private String imageName;
        private String contentType;
        private String imageData;

        public MyBlog toEntity(){
            return MyBlog.builder()
                .mainTitle(this.mainTitle)
                .content(this.content)
                .subTitle(this.subTitle)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        }
    }
}
