package com.unibuc.itemsservice;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ItemsServiceApplication {

    @Bean
    public GroupedOpenApi openApiDocumentation(){
        return GroupedOpenApi.builder()
                .group("Api")
                .packagesToScan("com.unibuc.itemsservice")
                .pathsToMatch("/**")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ItemsServiceApplication.class, args);
    }

}
