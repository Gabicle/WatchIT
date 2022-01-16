package com.isep.series.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Series {

    private String description;
    //could also be bg
    private String thumbnail;
    private String seasons;


    //CONSTRUCTOR FOR PROFILE ADAPTER
    public Series(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }


    //CONSTRUCTOR FOR DISCOVER ADAPTER
    public Series(String title, String thumbnail, String seasons) {
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rank")
    @Expose
    private String rank;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("fullTitle")
    @Expose
    private String fullTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String year;
    private String image;
    private String imDbRating;
    private String imDbRatingCount;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

    public void setImDbRatingCount(String imDbRatingCount) {
        this.imDbRatingCount = imDbRatingCount;
    }
}
