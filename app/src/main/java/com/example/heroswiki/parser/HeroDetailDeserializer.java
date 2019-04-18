package com.example.heroswiki.parser;

import com.example.heroswiki.model.DetailHero;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class HeroDetailDeserializer implements JsonDeserializer<DetailHero> {

    @Override
    public DetailHero deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
