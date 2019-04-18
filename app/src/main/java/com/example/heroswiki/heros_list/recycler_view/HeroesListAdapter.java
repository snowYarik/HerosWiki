package com.example.heroswiki.heros_list.recycler_view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.heroswiki.R;
import com.example.heroswiki.detail_hero.DetailHeroFragment;
import com.example.heroswiki.model.DetailHero;
import com.example.heroswiki.model.Hero;
import com.example.heroswiki.network.RetrofitUtil;
import com.example.heroswiki.parser.HeroDetailDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Hero> list;
    private Context context;

    public HeroesListAdapter(List<Hero> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public List<Hero> getList() {
        return list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.heros_recycler_include, viewGroup, false);
        return new HeroesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HeroesViewHolder holder = (HeroesViewHolder) viewHolder;
        holder.fullName.setText(list.get(i).getFullName());
        Glide.with(context).load(list.get(i).getImage())
                .fitCenter()
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(List<Hero> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    private class HeroesViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView fullName;

        public HeroesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hero_image);
            fullName = itemView.findViewById(R.id.hero_name);
            itemView.setOnClickListener(v ->
                    ((AppCompatActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction().replace(R.id.fragment_container, getFragmentWithId(list.get(getAdapterPosition()).getId()), DetailHeroFragment.TAG)
                            .addToBackStack(null)
                            .commit());

        }


        private Fragment getFragmentWithId(int id) {
            Bundle bundle = new Bundle();
            bundle.putInt(DetailHeroFragment.ID_KEY, id);
            Fragment fragment = new DetailHeroFragment();
            fragment.setArguments(bundle);
            return fragment;
        }
    }
}
