package com.example.aksampath.reccommendations.api;

import android.view.Window;

import com.example.aksampath.reccommendations.model.ActiveListings;
import com.example.aksampath.reccommendations.api.Api;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.Callback;

/**
 * Created by Akshay on 2015-11-21.
 */
public class Etsy {
    private static final String API_KEY = "ozwxdpek492s7ftwx667mssf";

    private static RequestInterceptor getInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addEncodedQueryParam("api_key", API_KEY);
            }
        };
    }

    private static Api getApi(){
        return new RestAdapter.Builder()
                .setEndpoint("https://openapi.etsy.com/v2")
                .setRequestInterceptor(getInterceptor())
                .build()
                .create(Api.class);
    }

    public static void getActiveListings(Callback<ActiveListings> callback){
        getApi().activeListings("Images,Shop", callback);
    }
}
