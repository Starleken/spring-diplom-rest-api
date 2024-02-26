package com.example.DiplomRestApi;

import com.example.DiplomRestApi.repository.StudentRepository;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DiplomRestApiApplication {
public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(DiplomRestApiApplication.class)
                .run(args);
    }
}
