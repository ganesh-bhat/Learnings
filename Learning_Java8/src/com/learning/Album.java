package com.learning;

import java.util.Set;

public class Album {
    private String name;
    private Set<String> tracks;
    private Set<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getTracks() {
        return tracks;
    }

    public void setTracks(Set<String> tracks) {
        this.tracks = tracks;
    }

    public Set<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(Set<Artist> musicians) {
        this.musicians = musicians;
    }
}
