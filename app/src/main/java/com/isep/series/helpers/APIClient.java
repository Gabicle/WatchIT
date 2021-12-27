package com.isep.series.helpers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {


        private static APIClient client =  null;
        private static String BASE_URL = "https://api.exchangeratesapi.io/v1/";
        private  API myApi;

        private APIClient()
        {
            Gson gson = new GsonBuilder()
                    .setLenient().create();


            Retrofit retrofit =  new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            myApi = retrofit.create(API.class);
        }

        public static synchronized APIClient getInstance()
        {
            if(client ==  null)
            {
                client = new APIClient();
            }
            return client;
        }

        public API getMyApi()
        {
            return myApi;
        }
    }

