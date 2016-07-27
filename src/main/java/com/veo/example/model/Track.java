package com.veo.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    private String duration;
    private String position;
    private String title;

    public Track() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        if (duration != null && duration.equals("")) {
            duration = "Not Available";
        }
        this.duration = duration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Track { " +
                "title='" + title +
                "' at position " + position +
                " for " + duration + " long";

    }
}
