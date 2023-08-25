package com.portfolio.portfolio_project.web.s3_sample_test;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class S3SampleController {

    private final S3SampleService s3SampleService;

    @PostMapping("/s3/test")
    public String s3test(@RequestBody UpdateInDTO updateInDTO) throws IOException {

        s3SampleService.S3SampleTest(updateInDTO);
        return "a";
    }
}
