package com.isep.series.helpers;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isep.series.models.allTvSeries;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {


        private static APIClient client =  null;
        private static String BASE_URL = "https://imdb-api.com/en/API/";
        private  API myApi;

        private MutableLiveData<allTvSeries>tvSeriesMutableLiveData;


        public APIClient()
        {
            tvSeriesMutableLiveData =  new MutableLiveData<>();

            httpInterceptor interceptor =  new httpInterceptor();
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            myApi = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(API.class);
        }

            public void getTvSeries() {

                    myApi.getAllTvSeries()
                            .enqueue(new Callback<allTvSeries>() {
                                @Override
                                public void onResponse(Call<allTvSeries> call, Response<allTvSeries> response) {
                                    if(response.body() != null)
                                    {
                                        tvSeriesMutableLiveData.postValue(response.body());
                                    }
                                }

                                @Override
                                public void onFailure(Call<allTvSeries> call, Throwable t) {
                                    tvSeriesMutableLiveData.postValue(null);
                                }
                            });
        }

        public LiveData<allTvSeries>getallTvSeriesResponse()
        {
            return tvSeriesMutableLiveData;
        }

        public API getMyApi()
        {
            return myApi;
        }

    }


