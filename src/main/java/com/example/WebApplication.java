package com.example;

import com.example.service.ServiceMovies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);

        ServiceMovies service = new ServiceMovies();

        service.title();

    }
}
