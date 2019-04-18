package com.example.heroswiki.detail_hero.interfaces;

import com.example.heroswiki.model.DetailHero;

public interface IInterector {
    void loadDetails(ILoadDetailsListener listener, int id);

    interface ILoadDetailsListener {
        void onSuccessLoadDetails(DetailHero hero);

        void onErrorLoadDetails(String message);
    }
}
