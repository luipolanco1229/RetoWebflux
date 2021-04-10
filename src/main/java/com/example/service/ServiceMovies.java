package com.example.service;

import com.example.JSoupWeb;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ServiceMovies {

    JSoupWeb dataElements = new JSoupWeb();

    public Flux<String> title () {
        return Flux.fromIterable(dataElements.elementtitle());
    }
}
