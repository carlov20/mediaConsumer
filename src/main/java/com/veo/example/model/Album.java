package com.veo.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {

    private String[] style;
    private String country;
    private String[] label;
    private String year;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String[] genre;
    private String title;

    public Album() {
    }

    public String[] getStyle() {
        return style;
    }

    public void setStyle(String[] style) {
        this.style = style;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public String toString() {
        return "Album{" +
                "style=" + Arrays.toString(style) +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", genre=" + Arrays.toString(genre) +
                ", title='" + title + '\'' +
                '}';
    }
}
