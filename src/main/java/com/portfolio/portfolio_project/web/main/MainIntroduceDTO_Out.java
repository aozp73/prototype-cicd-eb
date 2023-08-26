package com.portfolio.portfolio_project.web.main;

import com.portfolio.portfolio_project.domain.jpa.main.main_introduce.MainIntroduce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MainIntroduceDTO_Out {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class postDTO {
        private String postTitle;
        private String postContent;
        private String imgURL;

        public postDTO(MainIntroduce mainIntroducePS) {
            this.postTitle = mainIntroducePS.getTitle();
            this.postContent = mainIntroducePS.getContent();
            this.imgURL = mainIntroducePS.getIntroduceImgUrl();
        }
    }
}
