package com.veo.example.service;

import com.veo.example.model.Album;
import com.veo.example.model.AlbumSearch;
import com.veo.example.model.FullAlbum;

import org.springframework.beans.factory.annotation.Value;
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
public class DiscogsMusicService implements MusicService {


    private static final String DISCOGS_SEARCH_URL = "https://api.discogs.com/database/search";
    private final RestTemplate restTemplate = new RestTemplate();
    private String apiToken;

    @Value("${discogs.token}")
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public Stream<FullAlbum> findByAlbumTitle(String albumTitle) {
        if (albumTitle != null) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(DISCOGS_SEARCH_URL)
                    .queryParam("release_title", albumTitle).queryParam("token", apiToken).queryParam("type", "release");

            ResponseEntity<AlbumSearch> searchResults = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), AlbumSearch.class);

            return searchResults.getBody().getResults().parallelStream().filter(album ->
                    album.getStyle() != null &&
                            album.getCountry() != null &&
                            album.getYear() != null &&
                            album.getGenre() != null)
                    .map(populateTrackInformation());
        } else {
            throw new IllegalArgumentException("An album property must be supplied when using the discogs api");
        }
    }

    private Function<Album, FullAlbum> populateTrackInformation() {
        return album -> restTemplate.getForObject(album.getResourceUrl(), FullAlbum.class);
    }

}
