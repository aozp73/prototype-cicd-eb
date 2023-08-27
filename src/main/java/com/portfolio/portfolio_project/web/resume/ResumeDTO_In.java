package com.portfolio.portfolio_project.web.resume;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResumeDTO_In {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class schooledu_postDTO {
        private List<String> values;
    }
    @Getter
    @Setter
    public static class academyedu_postDTO {
        private List<String> values;
    }
    @Getter
    @Setter
    public static class certificate_postDTO {
        private List<String> values;
    }
    @Getter
    @Setter
    public static class selfstudy_postDTO {
        private List<String> values;
    }
}