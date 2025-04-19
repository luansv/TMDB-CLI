package com.example.TMDB_CLI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpHeaders;

@Configuration
public class WebClientConfig {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }
}
