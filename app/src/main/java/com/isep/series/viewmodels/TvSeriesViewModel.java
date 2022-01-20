package com.isep.series.viewmodels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.isep.series.models.Entities.Series;
import com.isep.series.repository.SeriesRepository;


import java.util.List;


public class TvSeriesViewModel extends  AndroidViewModel {

    private  SeriesRepository repository;
    public LiveData<List<Series>> allTvSeries;

    public TvSeriesViewModel(@NonNull Application application) {
        super(application);
        repository = new SeriesRepository(application);
        allTvSeries = repository.getAllTvSeries();
    }

    public void insert(List<Series> tvSeries){
        repository.InsertAll(tvSeries);
    }

    public LiveData<List<Series>> getAllTvSeries()
    {
        return allTvSeries;
    }

    public void makeAPICalls()
    {
         repository.getTvSeriesFromAPI();
    }

}
