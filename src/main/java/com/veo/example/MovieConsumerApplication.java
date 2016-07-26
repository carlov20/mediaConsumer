package com.veo.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.veo.example.service.MovieService;
import com.veo.example.service.MusicService;

@SpringBootApplication
public class MovieConsumerApplication implements CommandLineRunner {

	private MovieService movieService;
	private Boolean propertiesPresent;

	private MusicService musicService;
	
	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@Autowired
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Optional<String> movieApi = Optional.ofNullable(System.getProperty("api"))
				.filter(apiValue -> apiValue.equals("imdb"));
		propertiesPresent = movieApi.isPresent();

		movieApi.ifPresent(apiValue -> {
			Optional<String> movie = Optional.ofNullable(System.getProperty("movie"));
			propertiesPresent = movie.isPresent();
			movie.ifPresent(movieTitle -> {
				movieService.findMoviesByTitle(movieTitle).stream().forEach(System.out::println);
			});
		});
		if (!propertiesPresent) {

		}
		*/
		musicService.findByAlbumTitle("25").stream().forEach(System.out::println);
	}
}
