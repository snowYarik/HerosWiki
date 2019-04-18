package com.example.heroswiki.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.heroswiki.R;
import com.example.heroswiki.fragment.SplashScreenFragment;

public class MainActivity extends SingleActivity {


    @Override
    protected Fragment getFragment() {
        return new SplashScreenFragment();
    }
}
