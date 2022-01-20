package com.isep.series.repository;
import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.isep.series.Database.SeriesRoomDatabase;
import com.isep.series.models.Entities.Series;
import com.isep.series.network.APIClient;
import com.isep.series.interfaces.SeriesDAO;
import com.isep.series.models.allTvSeries;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesRepository {

    public SeriesDAO seriesDAO;
    public LiveData<List<Series>> allTvSeries;
    private SeriesRoomDatabase database;
    private APIClient apiClient =  new APIClient();
    public SeriesRepository(Application application){
        database= SeriesRoomDatabase.getDatabase(application);
        seriesDAO=database.seriesDAO();
        allTvSeries =  seriesDAO.getAllTvSeries();

    }

    public void InsertAll(List<Series> seriesEntities){
        new InsertAsyncTask(seriesDAO).execute(seriesEntities);

    }

    public LiveData<List<Series>> getAllTvSeries(){
        return allTvSeries;
    }


    public void getTvSeriesFromAPI() {

        apiClient.getMyApi().getAllTvSeries(10)
                .enqueue(new Callback<allTvSeries>() {
                    @Override
                    public void onResponse(Call<allTvSeries> call, Response<allTvSeries> response) {
                        if(response.body() != null)
                        {
                            Log.d("getAllTvSeries", "About to Insert items to db: ");
                            InsertAll(response.body().getItems());
                            Log.d("getAllTvSeries", "Done inserting data to db: ");
                        }
                    }

                    @Override
                    public void onFailure(Call<allTvSeries> call, Throwable t) {
                        Log.d("main", "onFailure: "+t.getMessage());
                    }
                });
    }

    private static class InsertAsyncTask extends AsyncTask<List<Series>,Void,Void> {
        private SeriesDAO seriesDAO;

        public InsertAsyncTask(SeriesDAO seriesDao)
        {
            this.seriesDAO = seriesDao;
        }
        @Override
        protected Void doInBackground(List<Series>... lists) {
            seriesDAO.InsertAll(lists[0]);
            return null;
        }
    }

    }


