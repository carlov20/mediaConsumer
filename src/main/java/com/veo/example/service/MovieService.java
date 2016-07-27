package com.veo.example.service;

import com.veo.example.model.Movie;

import java.util.stream.Stream;

public interface MovieService {

	Stream<Movie> findMoviesByTitle(String title);
	
}
