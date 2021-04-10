package com.example.controller;

import com.example.service.ServiceMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

@RestController
public class Controller {

    @Autowired
    private ServiceMovies service;

    @GetMapping(value = "api/movies")
    public Flux<String> title(){
        return service.fromIterable();
    }

    @GetMapping(value = "api/movies/zip")
    public Flux<Tuple3<String, String, String>> zip(){
         return service.zipMethod();
    }


}
