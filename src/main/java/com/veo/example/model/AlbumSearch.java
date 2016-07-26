package com.veo.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AlbumSearch {

	private List<Album> results;
	
	public AlbumSearch() {
	}

	public List<Album> getResults() {
		return results;
	}

	public void setResults(List<Album> results) {
		this.results = results;
	}
	
	
}
