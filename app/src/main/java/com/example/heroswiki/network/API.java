package com.example.heroswiki.network;

import com.example.heroswiki.model.DetailHero;
import com.example.heroswiki.model.Hero;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface API {
    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<List<Hero>> getHeroes();


    @GET("character/{id}")
    Call<JsonObject> getDetailHeroById(@Path("id") int id);

}
