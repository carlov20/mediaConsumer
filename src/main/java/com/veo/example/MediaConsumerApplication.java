package com.veo.example;

import com.veo.example.controller.APIController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaConsumerApplication implements CommandLineRunner {


    private APIController apiController;

    public static void main(String[] args) {
        SpringApplication.run(MediaConsumerApplication.class, args);
    }

    @Autowired
    public void setApiController(APIController apiController) {
        this.apiController = apiController;
    }

    @Override
    public void run(String... args) throws Exception {
        apiController.printResults(System.getProperty("api"), System.getProperty("movie"), System.getProperty("album"));
    }
}
