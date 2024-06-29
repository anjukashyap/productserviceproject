package org.example.productserviceevepackage.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
    }
    //whatever object it is returning it will create a bean in inside
    // application.context container. so that we can reuse whenever we needed.
    //@Configuration : this class is containing bean method ,
    // spring will go to this class when application start and it will store the beans in application.context

}
