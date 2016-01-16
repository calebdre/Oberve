package com.observe.Persistence.Models;

import java.util.List;

public class Professionals {
    private User user;
    private Profession profession;
    private List<Video> videos;

    public User getUser() {
        return user;
    }

    public Profession getProfession() {
        return profession;
    }

    public List<Video> getVideos() {
        return videos;
    }
}
