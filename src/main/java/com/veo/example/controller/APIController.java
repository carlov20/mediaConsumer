package com.veo.example.controller;

import com.veo.example.error.UnsupportedAPIException;
import com.veo.example.service.MovieService;
import com.veo.example.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class APIController {

    private MusicService musicService;

    private MovieService movieService;

    @Autowired
    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void printResults(String api, String movie, String album) {
        if (api != null) {
            switch (api) {
                case "imdb":
                    movieService.findMoviesByTitle(movie).forEach(System.out::println);
                    break;
                case "discogs":
                    musicService.findByAlbumTitle(album).forEach(System.out::println);
                    break;
                default:
                    throw new UnsupportedAPIException("Currently imdb and discogs are the only supported APIs");
            }
        } else {
            throw new IllegalArgumentException("An api property must be supplied.");
        }
    }
}
