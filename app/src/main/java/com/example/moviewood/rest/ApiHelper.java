package com.example.moviewood.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private CineApi cineApi;

    public CineApi getCineApi() {
        return cineApi;
    }

    private ApiHelper() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://etudiants.openium.fr/pam/").addConverterFactory(GsonConverterFactory.create()).build();
        cineApi = retrofit.create(CineApi.class);
    }

    private static volatile ApiHelper instance;


    public static synchronized ApiHelper getInstance() {
        if (instance == null) {
            instance = new ApiHelper();
        }
        return instance;
    }
}
