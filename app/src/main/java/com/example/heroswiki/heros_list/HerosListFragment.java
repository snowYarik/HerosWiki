package com.example.heroswiki.heros_list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.heroswiki.R;
import com.example.heroswiki.Utils.MessageUtil;
import com.example.heroswiki.heros_list.interfaces.IPresenter;
import com.example.heroswiki.heros_list.interfaces.IView;
import com.example.heroswiki.heros_list.recycler_view.HeroesListAdapter;
import com.example.heroswiki.model.Hero;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.Collections;
import java.util.List;

public class HerosListFragment extends Fragment implements IView {
    private IPresenter presenter;
    private RecyclerView recyclerView;
    private AppCompatSpinner sortSpinner;
    private HeroesListAdapter recyclerAdapter;
    private List<Hero> heroes;
    private SpinKitView progressBar;
    private LinearLayout content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HerosListPresenter(this, new HeroesListInteractor());


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.heros_list_fragment, container, false);
        sortSpinner = view.findViewById(R.id.sort_spinner);
        progressBar = view.findViewById(R.id.progress_circular);
        content = view.findViewById(R.id.content);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,
                new String[]{"All", "By name"});
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sortSpinner.setAdapter(spinnerAdapter);
        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    presenter.loadHeroes();
                } else if (position == 1) {
                    Collections.sort(heroes, (hero1, hero2) ->
                            hero1.getFullName().compareToIgnoreCase(hero2.getFullName())
                    );
                    ((HeroesListAdapter) recyclerView.getAdapter()).updateList(heroes);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        recyclerView = view.findViewById(R.id.heros_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        presenter.loadHeroes();
        return view;
    }

    @Override
    public void successLoading(List<Hero> list) {
        heroes = list;
        recyclerView.setAdapter(new HeroesListAdapter(list, getContext()));
        hideProgress();
    }

    @Override
    public void errorLoading(String message) {
        MessageUtil.makeToast(getContext(), message);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
    }
}
