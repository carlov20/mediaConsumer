package com.veo.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.veo.example.model.Album;
import com.veo.example.model.AlbumSearch;

@Service
public class DiscogsMusicService implements MusicService {

	@Value("${discogs.token}")
	private String apiToken;

	private static final String DISCOGS_SEARCH_URL = "https://api.discogs.com/database/search";

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Album> findByAlbumTitle(String albumTitle) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(DISCOGS_SEARCH_URL)
				.queryParam("release_title", albumTitle).queryParam("token", apiToken);
		
		ResponseEntity<AlbumSearch> searchResults = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,new HttpEntity<>(new HttpHeaders()),AlbumSearch.class);
		
		return searchResults.getBody().getResults().stream().distinct().collect(Collectors.toList());
	}

}
