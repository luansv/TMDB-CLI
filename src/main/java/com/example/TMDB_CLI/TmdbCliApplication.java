package com.example.TMDB_CLI;

import com.example.TMDB_CLI.service.MovieService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmdbCliApplication  {
    public static void main(String[] args) {
        SpringApplication.run(TmdbCliApplication.class, args);
    }
    }
