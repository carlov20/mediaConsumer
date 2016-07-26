package com.veo.example.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Album {

	private String[] style;
	private String country;
	private String[] label;
	private String year;
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

	@Override
	public String toString() {
		return "Album [style=" + Arrays.toString(style) + ", country=" + country + ", label=" + Arrays.toString(label)
				+ ", year=" + year + ", genre=" + Arrays.toString(genre) + ", title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
