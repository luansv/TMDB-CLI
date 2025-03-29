package com.example.TMDB_CLI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TmdbCliRunner implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(TmdbCliRunner.class);

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Inside TmdbCliRunner");
        if (args.length == 0) {
            LOG.error("Unavailable input!");
            LOG.error("Usage:\n" +
                    "  --popular       Show popular movies\n" +
                    "  --top-rated     Show top rated movies\n" +
                    "  --now-playing   Show movies now playing\n" +
                    "  --upcoming      Show upcoming movies\n");

        } else if (args[0].equals("--popular")){
            LOG.info("Fetching popular movies...");
        } else if (args[0].equals("--top-rated")) {
            LOG.info("Fetching top rated movies...");
        } else if (args[0].equals("--now-playing")){
            LOG.info("Fetching now playing movies...");

        } else if (args[0].equals("--upcoming")) {
            LOG.info("Fetching upcoming movies...");
        }
    }
}
