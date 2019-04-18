package com.example.heroswiki.parser;

import android.util.Log;

import com.example.heroswiki.BuildConfig;
import com.example.heroswiki.model.Hero;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HeroesDeserializer implements JsonDeserializer<List<Hero>> {
    private final static String TAG = HeroesDeserializer.class.getSimpleName();

    @Override
    public List<Hero> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<Hero> list = new ArrayList<>();
        try {
            for (JsonElement element : json.getAsJsonObject().get("results").getAsJsonArray()) {
                JsonObject object = element.getAsJsonObject();
                int id = object.getAsJsonPrimitive("id").getAsInt();
                String fullName = object.getAsJsonPrimitive("name").getAsString();
                String image = object.getAsJsonPrimitive("image").getAsString();
                Hero hero = new Hero();
                hero.setId(id);
                hero.setFullName(fullName);
                hero.setImage(image);
                list.add(hero);
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
        return list;
    }
}
