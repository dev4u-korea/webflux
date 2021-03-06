package com.demo.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class EchoController {

    @GetMapping("/echo")
    public Flux<String> echo() {        
        return Flux.just("Hello", "World");
    }

    @GetMapping("/stream")
    Flux<Map<String, Integer>> stream() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1); // Java8의 무한Stream

        return Flux.fromStream(stream.limit(1000))
                .map(i -> Collections.singletonMap("value", i));
    }
}
