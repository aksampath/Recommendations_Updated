package com.example.aksampath.reccommendations.api;

import com.example.aksampath.reccommendations.model.ActiveListings;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Akshay on 2015-11-21.
 */
public interface Api {
    @GET("/listings/active")
    void activeListings(@Query("includes") String includes,
                        Callback<ActiveListings> callback);
}
