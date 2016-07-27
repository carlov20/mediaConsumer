package com.veo.test

import com.veo.example.model.Movie
import com.veo.example.service.ImdbMovieService
import org.apache.commons.lang3.StringUtils
import spock.lang.Specification

import java.util.stream.Stream

class ImdbMovieServiceSpec extends Specification {

	private ImdbMovieService movieService = new ImdbMovieService();

	def "all movies returned have no null values"() {
		given: "Indiana Jones title"
		String title = "Indiana Jones"
		when: "find Movies by title is called"
		Stream<Movie> movieResults = movieService.findMoviesByTitle(title);
		then: "all films have no null values"
		movieResults.allMatch({ movie -> movie.getTitle() != null && movie.getYear() != null && movie.getDirector() != null });
	}

	def "find all films that contain star wars" () {
		given: "star wars title"
		String title = "star wars";
		when: "find Movies by title is called"
		Stream<Movie> starWarsMovies = movieService.findMoviesByTitle(title);
		then: "all films contain star wars in title"
		starWarsMovies.allMatch({ movie -> StringUtils.containsIgnoreCase(movie.getTitle(), title) });
	}
}
