package com.example.heroswiki.detail_hero.interfaces;

import com.example.heroswiki.IBaseView;
import com.example.heroswiki.model.DetailHero;

public interface IView extends IBaseView {
    void successLoad(DetailHero hero);

    void errorLoad(String message);
}
