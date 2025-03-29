package com.example.TMDB_CLI.runner;

import com.example.TMDB_CLI.service.MovieService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieCliRunner implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(MovieCliRunner.class);

    private final MovieService movieService;

    public MovieCliRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length < 1) {
            LOG.error("Unavailable input!");
            LOG.error("Usage:\n" +
                    "  --popular       Show popular movies\n" +
                    "  --top-rated     Show top rated movies\n" +
                    "  --now-playing   Show movies now playing\n" +
                    "  --upcoming      Show upcoming movies\n");
        }
        String argument = args[0];
        try {
            String jsonResponse = movieService.fetchMovies(argument).block();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode results = rootNode.path("results");

            System.out.println("\n🎬 Movie List (" + argument + "):\n");
            for (JsonNode movie : results) {
                String title = movie.path("title").asText();
                double rating = movie.path("vote_average").asDouble();
                String releaseDate = movie.path("release_date").asText();

                System.out.println("📌 " + title);
                System.out.println("   ⭐ Rating: " + rating + "/10");
                System.out.println("   🗓️ Release Date: " + releaseDate);
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            LOG.error("Failed to fetch movies" + e.getMessage());
        }

    }

}
