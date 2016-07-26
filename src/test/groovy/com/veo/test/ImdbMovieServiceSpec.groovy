package com.veo.test

import org.apache.commons.lang3.StringUtils;

import com.veo.example.model.Movie;
import com.veo.example.service.ImdbMovieService;

import spock.lang.Specification

class ImdbMovieServiceSpec extends Specification {

	private ImdbMovieService movieService = new ImdbMovieService();

	def "find all films that contain star wars" () {
		given: "star wars title"
		String title = "star wars";
		when: "find Movies by title is called"
		List<Movie> starWarsMovies = movieService.findMoviesByTitle(title);
		then: "list isn't empty"
		!starWarsMovies.isEmpty();
		then: "all films contain star wars in title"
		starWarsMovies.stream().allMatch({movie -> StringUtils.containsIgnoreCase(movie.getTitle(),title)});
	}
}
