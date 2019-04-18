package com.example.heroswiki.detail_hero;

import android.util.Log;

import com.example.heroswiki.detail_hero.interfaces.IInterector;
import com.example.heroswiki.model.DetailHero;
import com.example.heroswiki.network.RetrofitUtil;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHeroInteractor implements IInterector {
    public final static String TAG = DetailHeroInteractor.class.getSimpleName();

    @Override
    public void loadDetails(ILoadDetailsListener listener, int id) {
        Call<JsonObject> request = RetrofitUtil.getInstance(null).getDetailHeroById(id);
        request.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, response.message());
                    listener.onSuccessLoadDetails(parseDetailJson(response.body()));
                } else {
                    Log.i(TAG, response.message());
                    listener.onErrorLoadDetails(response.message());

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.i(TAG, t.getLocalizedMessage());
                listener.onErrorLoadDetails(t.getLocalizedMessage());

            }
        });
    }

    public DetailHero parseDetailJson(JsonObject obj) {
        /*
        Something gone wrong with HeroDetailDeserializer.class
        It was thinking that i need to parse json which starts with object but system sad that it starts with string
        I decided to make this parser
        */

        int id = obj.getAsJsonPrimitive("id").getAsInt();
        String fullName = obj.getAsJsonPrimitive("name").getAsString();
        String status = obj.getAsJsonPrimitive("status").getAsString();
        String spicies = obj.getAsJsonPrimitive("species").getAsString();
        String gender = obj.getAsJsonPrimitive("gender").getAsString();
        String origin = obj.getAsJsonObject("origin").getAsJsonPrimitive("name").getAsString();
        String location = obj.getAsJsonObject("location").getAsJsonPrimitive("name").getAsString();
        String image = obj.getAsJsonPrimitive("image").getAsString();
        String type = obj.getAsJsonPrimitive("type").getAsString();
        return new DetailHero(id, fullName, status, spicies, type, gender, origin, location, image);
    }
}
