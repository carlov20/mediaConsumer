package com.veo.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MovieSearch {
	
	@JsonProperty("Search")
	private List<Movie> search;

	public List<Movie> getSearch() {
		return search;
	}

	public void setSearch(List<Movie> search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "MovieSearch [search=" + search + "]";
	}
	
	

}
