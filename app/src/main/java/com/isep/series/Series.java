package com.isep.series;

public class Series {

    private String title;
    private String description;
    //could also be bg
    private int thumbnail;
    private String seasons;


    //CONSTRUCTOR FOR PROFILE ADAPTER
    public Series(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }


    //CONSTRUCTOR FOR DISCOVER ADAPTER
    public Series(String title, int thumbnail, String seasons) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.seasons = seasons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }
}
