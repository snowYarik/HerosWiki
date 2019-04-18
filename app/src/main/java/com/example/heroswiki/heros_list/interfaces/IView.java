package com.example.heroswiki.heros_list.interfaces;

import com.example.heroswiki.IBaseView;
import com.example.heroswiki.model.Hero;

import java.util.List;

public interface IView extends IBaseView {
    void successLoading(List<Hero> list);

    void errorLoading(String message);
}
