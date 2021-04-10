package com.example.service;

import com.example.JSoupWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@Service
public class ServiceMovies {

    private static final Logger Log = LoggerFactory.getLogger(ServiceMovies.class);
    JSoupWeb dataElements = new JSoupWeb();

    public Flux<String> fromIterableReactive() {
        var movieslist = Flux.fromIterable(dataElements.titleList());
        return movieslist;
    }

    public Flux<Tuple3<String, String, String>> zipReactive(){
        var movieslist = Flux.fromIterable(dataElements.titleList());
        var genreList = Flux.fromIterable(dataElements.genreList());
        var noteList = Flux.fromIterable(dataElements.noteList());

       var zip = Flux.zip(movieslist, genreList, noteList);

       return zip;


    }


}
