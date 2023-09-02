package com.portfolio.portfolio_project.web.blog;

import com.portfolio.portfolio_project.domain.jpa.myblog.my_blog.MyBlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MyBlogDTO_Out {
    
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostDTO {
        private Long id;
        private String postTitle;
        private String postSubTitle;
        private String postContent;
        private String imgURL;

        public static PostDTO fromEntity(MyBlog entity) {
            return new PostDTO(entity.getId(), entity.getMainTitle(), entity.getSubTitle(), entity.getContent(), entity.getBlogImgUrl());
        }
    }
}
