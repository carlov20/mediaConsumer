package com.veo.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie {
	
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	private String year;
	private String imdbID;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Poster")
	private String poster;
	@JsonProperty("Director")
	private String director;
	public String getTitle() {
		
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override
	public String toString() {
		return "Movie {\"title\":" + title + ", year\":" + year + ", director\":" + director + "}";
	}
	
	

}
