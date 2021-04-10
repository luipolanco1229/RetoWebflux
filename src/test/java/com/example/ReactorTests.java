package com.example;

import com.example.service.ServiceMovies;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple3;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReactorTests {


    ServiceMovies serviceMovies = new ServiceMovies();

    @Test
    public void fromIterable() {
        var moviesFromIterable = serviceMovies.fromIterableReactive();
        //Assertions.assertEquals(1,1);
        StepVerifier.create(moviesFromIterable.take(1)).expectNext("El padrino").verifyComplete();
    }

    @Test
    public void zip(){
        Flux<Tuple3<String, String, String>> joinForZip = serviceMovies.zipReactive();

        var title = joinForZip.blockFirst().getT1();
        var genre = joinForZip.blockFirst().getT2();
        var note = joinForZip.blockFirst().getT3();

        Assertions.assertEquals("El padrino", title);
        Assertions.assertEquals("Crimen, Drama", genre);
        Assertions.assertEquals("4,6", note);

    }
}