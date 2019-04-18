package com.example.heroswiki.detail_hero;

import com.example.heroswiki.detail_hero.interfaces.IInterector;
import com.example.heroswiki.detail_hero.interfaces.IPresenter;
import com.example.heroswiki.detail_hero.interfaces.IView;
import com.example.heroswiki.model.DetailHero;

public class DetailHeroPresenter implements IPresenter, IInterector.ILoadDetailsListener {
    private IView view;
    private IInterector interector;

    public DetailHeroPresenter(IView view, IInterector interector) {
        this.view = view;
        this.interector = interector;
    }

    @Override
    public void onSuccessLoadDetails(DetailHero hero) {
        view.successLoad(hero);
    }

    @Override
    public void onErrorLoadDetails(String message) {
        view.errorLoad(message);
    }

    @Override
    public void LoadDetails(int id) {

        view.showProgress();
        interector.loadDetails(this, id);
    }
}
