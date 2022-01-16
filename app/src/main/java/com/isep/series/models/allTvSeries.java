package com.isep.series.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class allTvSeries {


    @SerializedName("items")

    @Expose

    private List<Series> items = null;

    public List<Series> getItems() {
        return items;
    }

    public void setItems(List<Series> items) {
        this.items = items;
    }
}

