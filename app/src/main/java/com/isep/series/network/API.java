package com.isep.series.network;
import com.isep.series.models.allTvSeries;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface API {

    @GET("Top250TVs/k_o0k4l2d3")
    Call<allTvSeries> getAllTvSeries(@Query("limit") int limit);

    //@GET("http://api.exchangeratesapi.io/v1/latest?access_key=779028d721bbab39cf32a1f511c48c64")
    //Call<CurrencyRates> getCurrencyRates();
}
