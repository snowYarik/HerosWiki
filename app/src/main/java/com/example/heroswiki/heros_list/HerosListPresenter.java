package com.example.heroswiki.heros_list;

import com.example.heroswiki.heros_list.interfaces.IInterector;
import com.example.heroswiki.heros_list.interfaces.IPresenter;
import com.example.heroswiki.heros_list.interfaces.IView;
import com.example.heroswiki.model.Hero;

import java.util.List;

public class HerosListPresenter implements IPresenter, IInterector.ILoadListListener {
    private IView view;
    private IInterector interector;

    public HerosListPresenter(IView view, IInterector interector) {
        this.view = view;
        this.interector = interector;
    }

    @Override
    public void OnSuccessLoadList(List<Hero> list) {
        view.successLoading(list);
    }

    @Override
    public void onErrorLoadList(String message) {
        view.errorLoading(message);
    }

    @Override
    public void loadHeroes() {
        view.showProgress();
        interector.loadHeroes(this);
    }
}
