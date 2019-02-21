package com.example.moviewood.rest;

import com.example.moviewood.model.Cine;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CineApi {
    /**
     * Call a webservice with a static path
     */
    @GET("cine.json")
    Call<Cine> getFile();
}
