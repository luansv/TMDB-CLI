package com.example.TMDB_CLI.controller;

import com.example.TMDB_CLI.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping()
public class TmdbCliController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MovieService tmdbCliService;


}
