package com.example.heroswiki.heros_list;

import android.util.Log;

import com.example.heroswiki.heros_list.interfaces.IInterector;
import com.example.heroswiki.model.Hero;
import com.example.heroswiki.network.RetrofitUtil;
import com.example.heroswiki.parser.HeroesDeserializer;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesListInteractor implements IInterector {
    @Override
    public void loadHeroes(final ILoadListListener listListener) {
        Call<List<Hero>> request = RetrofitUtil.getInstance(getFactory()).getHeroes();
        request.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (response.isSuccessful()) {
                    Log.i("Load", response.message());
                    listListener.OnSuccessLoadList(response.body());
                } else {
                    Log.i("Load", response.message());
                    listListener.onErrorLoadList(response.message());

                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.i("Load", t.getLocalizedMessage());
                listListener.onErrorLoadList(t.getLocalizedMessage());

            }
        });

    }

    private GsonConverterFactory getFactory() {
        return RetrofitUtil.createFactory(new TypeToken<List<Hero>>() {
        }.getType(), new HeroesDeserializer());
    }
}
