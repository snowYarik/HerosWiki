package com.example.heroswiki.network;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static Retrofit retrofit;
    private static RetrofitUtil INSTANCE = null;

    private RetrofitUtil(GsonConverterFactory factory) {
        retrofit = new Retrofit.Builder().baseUrl(API.BASE_URL)
                .addConverterFactory(factory)
                .build();
    }

    public static API getInstance(GsonConverterFactory factory) {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitUtil(factory);
        }
        return retrofit.create(API.class);

    }

    public static GsonConverterFactory createFactory(Type type, Object typeAdapter) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(type, typeAdapter);
        return GsonConverterFactory.create(builder.create());
    }
}
