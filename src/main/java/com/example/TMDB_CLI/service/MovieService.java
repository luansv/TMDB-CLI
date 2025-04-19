package com.example.TMDB_CLI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final WebClient webClient;
    private final String token;

    public MovieService(WebClient webClient, @Value("${tmdb.api.token}")String token){
        this.webClient = webClient;
        this.token = token;
    }

    //Read
    public Mono<String> fetchMovies(String argument){
        String endpoint = getEndpointArgument(argument);

        return webClient.get()
                .uri(endpoint)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ token)
                .retrieve()
                .bodyToMono(String.class);
    }

    private String getEndpointArgument(String argument){
        return switch (argument) {
            case "--popular" -> "movie/popular";
            case "--top-rated" -> "movie/top_rated";
            case "--now-playing" -> "movie/now_playing";
            case "--upcoming" -> "movie/upcoming";
            default -> throw new IllegalArgumentException("Invalid argument: "+argument);
        };
    }
}
