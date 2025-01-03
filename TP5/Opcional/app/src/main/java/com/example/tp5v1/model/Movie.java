package com.example.tp5v1.model;

public class Movie {
    private String title, cover;
    private float stars;

    public Movie(String title, String cover, float stars) {
        this.title = title;
        this.cover = cover;
        this.stars= stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }
}
