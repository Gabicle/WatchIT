package com.isep.series.viewmodels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.isep.series.helpers.APIClient;
import com.isep.series.models.allTvSeries;


public class TvSeriesViewHolder extends  AndroidViewModel {

    private APIClient apiClient;
    private LiveData<allTvSeries> tvSeriesResponseLiveData;
    public TvSeriesViewHolder(@NonNull Application application) {
        super(application);
    }

    public void init() {
         apiClient = new APIClient();

        tvSeriesResponseLiveData = apiClient.getallTvSeriesResponse();
    }

    public LiveData<allTvSeries> getTvSeriesResponseLiveData() {
        return tvSeriesResponseLiveData;
    }

    public void searchTVSeries() {

        apiClient.getTvSeries();
    }

}
