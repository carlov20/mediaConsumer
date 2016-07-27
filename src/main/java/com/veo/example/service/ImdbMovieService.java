package com.veo.example.service;

import com.veo.example.model.Movie;
import com.veo.example.model.MovieSearch;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.function.Function;
import java.util.stream.Stream;

@Service
public class ImdbMovieService implements MovieService {

	private static final String IMDB_URL = "http://omdbapi.com/";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public Stream<Movie> findMoviesByTitle(String title) {
		if (title != null) {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(IMDB_URL).queryParam("s", title)
					.queryParam("r", "json").queryParam("type", "movie");

			ResponseEntity<MovieSearch> searchResults = restTemplate.exchange(builder.build().encode().toUri(),
					HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), MovieSearch.class);
			return searchResults.getBody().getSearch().parallelStream().filter(movie -> movie.getType().equals("movie"))
					.map(populateDirector());
		} else {
			throw new IllegalArgumentException("A movie property must be supplied when using the imdb API");
		}
	}

	private Function<Movie, Movie> populateDirector() {
		return (movie) -> {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(IMDB_URL).queryParam("i", movie.getImdbID())
					.queryParam("r", "json").queryParam("type", "movie");
			ResponseEntity<Movie> result = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,
					new HttpEntity<>(new HttpHeaders()), Movie.class);
			if (result.hasBody()) {
				return result.getBody();
			}
			return movie;
		};
	}

}
