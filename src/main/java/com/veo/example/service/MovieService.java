package com.veo.example.service;

import java.util.List;

import com.veo.example.model.Movie;

public interface MovieService {

	List<Movie> findMoviesByTitle(String title);
	
}
