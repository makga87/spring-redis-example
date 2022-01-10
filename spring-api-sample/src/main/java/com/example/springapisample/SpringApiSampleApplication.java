package com.example.springapisample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringApiSampleApplication {

    @Autowired
    private RequestMappingHandlerMapping mapping;

    private ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        SpringApplication.run(SpringApiSampleApplication.class, args);
    }

    @PostConstruct
    public void getAllController() throws JsonProcessingException {

        Map<String, String> urlMethodMap = new HashMap<>();

        mapping.getHandlerMethods().forEach(((requestMappingInfo, handlerMethod) -> {
            log.info("requestMappingInfo={}, handlerMethod={}", requestMappingInfo, handlerMethod);

            urlMethodMap.put(requestMappingInfo.toString(), handlerMethod.getBean().toString());
        }));

        log.info("{}", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(urlMethodMap));

    }

}
