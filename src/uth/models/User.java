package uth.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class User {
    protected double id;
    protected String name;

    protected List<Video> videos;

    public User(double id, String name) {
        this.id = id;
        this.name = name;
        videos = new ArrayList<>();
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Video> getVideos() {
        return videos;
    }

}
