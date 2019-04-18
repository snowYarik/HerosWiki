package com.example.heroswiki.detail_hero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.heroswiki.R;
import com.example.heroswiki.Utils.MessageUtil;
import com.example.heroswiki.custom_view.CustomTextView;
import com.example.heroswiki.detail_hero.interfaces.IPresenter;
import com.example.heroswiki.detail_hero.interfaces.IView;
import com.example.heroswiki.model.DetailHero;
import com.github.ybq.android.spinkit.SpinKitView;

public class DetailHeroFragment extends Fragment implements IView {
    public static final String ID_KEY = "id_key";
    public final static String TAG = DetailHero.class.getSimpleName();
    private IPresenter presenter;
    private int id;

    private ImageView backButton;
    private ImageView heroImage;
    private View viewLine;
    private CustomTextView heroName;
    private CustomTextView status;
    private CustomTextView species;
    private CustomTextView type;
    private CustomTextView gender;
    private CustomTextView origin;
    private CustomTextView location;
    private SpinKitView progress;
    private ConstraintLayout content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            id = getArguments().getInt(ID_KEY, 1);
        } catch (Exception e) {

            e.printStackTrace();
        }
        presenter = new DetailHeroPresenter(this, new DetailHeroInteractor());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_hero_fragment, container, false);
        backButton = view.findViewById(R.id.back_btn);
        heroImage = view.findViewById(R.id.hero_image_detail);
        heroName = view.findViewById(R.id.full_name_detail);
        status = view.findViewById(R.id.status_detail);
        species = view.findViewById(R.id.species_detail);
        type = view.findViewById(R.id.type_detail);
        gender = view.findViewById(R.id.gender_detail);
        origin = view.findViewById(R.id.origin_detail);
        location = view.findViewById(R.id.location_detail);
        progress = view.findViewById(R.id.progress_circular);
        viewLine = view.findViewById(R.id.v_line);
        content = view.findViewById(R.id.content);
        backButton.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });
        presenter.LoadDetails(id);
        return view;
    }

    @Override
    public void successLoad(DetailHero hero) {
        Glide.with(getView()).load(hero.getImage()).fitCenter().into(heroImage);
        heroName.setMainText(hero.getFullName());
        status.setMainText(hero.getStatus());
        species.setMainText(hero.getSpicies());
        if (type.getMainText().isEmpty()) {
            type.setVisibility(View.GONE);
            viewLine.setVisibility(View.GONE);
        } else {
            type.setVisibility(View.VISIBLE);
            viewLine.setVisibility(View.VISIBLE);
            type.setMainText(hero.getType());
        }
        gender.setMainText(hero.getGender());
        origin.setMainText(hero.getOrigin());
        location.setMainText(hero.getLocation());
        hideProgress();

    }

    @Override
    public void errorLoad(String message) {
        MessageUtil.makeToast(getContext(), message);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        content.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }
}
