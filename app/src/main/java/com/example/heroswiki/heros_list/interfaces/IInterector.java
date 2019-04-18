package com.example.heroswiki.heros_list.interfaces;

import com.example.heroswiki.model.Hero;

import java.util.List;

public interface IInterector {
    void loadHeroes(ILoadListListener listListener);

    interface ILoadListListener {
        void OnSuccessLoadList(List<Hero> list);

        void onErrorLoadList(String message);
    }
}
