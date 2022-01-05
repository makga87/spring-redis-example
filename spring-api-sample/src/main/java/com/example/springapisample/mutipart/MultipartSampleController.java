package com.example.springapisample.mutipart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Slf4j
@RestController
public class MultipartSampleController {

    @PostMapping("/multipart")
    public void multipartSample(@RequestBody MultipartFile multipart) throws IOException {

        String base64 = Base64.getEncoder().encodeToString(multipart.getBytes());
        log.info("{}", base64);

    }
}
