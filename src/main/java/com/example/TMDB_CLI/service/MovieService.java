package com.example.TMDB_CLI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    private final WebClient webClient;

    public MovieService(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<String> fetchMovies(String argument){
        String endpoint = getEndpointArgument(argument);
        String url =  "https://api.themoviedb.org/3/" + endpoint + "?api_key=YOUR_API_KEY";

        return webClient.get()
                .uri(url)
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
