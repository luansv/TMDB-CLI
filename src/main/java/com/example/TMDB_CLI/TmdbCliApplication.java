package com.example.TMDB_CLI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TmdbCliApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(TmdbCliApplication.class);

    @Bean
    public WebClient.Builder getWebClientBuilder(){
       return WebClient.builder();
    }

    public static void main(String[] args) {
        //LOG.info("Starting");
        SpringApplication.run(TmdbCliApplication.class, args);
        //LOG.info("Finishing");
    }

    @Override
    public void run(String... args) throws Exception {
//        LOG.info("EXECUTING : command line runner");
//        for (int i = 0; i < args.length; ++i) {
//            LOG.info("args[{}]: {}", i, args[i]);
//        }
    }
}
