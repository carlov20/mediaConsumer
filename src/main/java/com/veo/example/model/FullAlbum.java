package com.veo.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;


@JsonIgnoreProperties(ignoreUnknown = true)
public class FullAlbum {

    private Collection<Artist> artists;

    private String[] genres;

    private String title;

    @JsonProperty("released_formatted")
    private String released;

    private List<Track> tracklist;

    private String country;

    public FullAlbum() {
    }

    public Collection<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Collection<Artist> artists) {
        this.artists = artists;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public List<Track> getTracklist() {
        return tracklist;
    }

    public void setTracklist(List<Track> tracklist) {
        this.tracklist = tracklist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        Random random = new Random();
        return "Album { " +
                "artists=" + artists +
                ", genres=" + Arrays.toString(genres) +
                ", title='" + title + '\'' +
                ", released=" + released +
                ", has " + tracklist.size() + " tracks including " + tracklist.get(random.nextInt(tracklist.size())) +
                ", country='" + country + '\'' +
                '}';
    }
}
