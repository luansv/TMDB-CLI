package com.example.TMDB_CLI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TmdbCliService {

    private final WebClient webClient;

    public TmdbCliService(WebClient webClient){
        this.webClient = webClient;
    }
}
