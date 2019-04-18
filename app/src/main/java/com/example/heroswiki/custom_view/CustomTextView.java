package com.example.heroswiki.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.heroswiki.R;

public class CustomTextView extends LinearLayout {
    private TextView headerText;
    private TextView mainText;

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_text_view, this, true);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.DetailTextView);
        String headerText = "";
        String mainText = "";
        try {
            headerText = array.getString(R.styleable.DetailTextView_header_text);
            mainText = array.getString(R.styleable.DetailTextView_main_text);
        } catch (Exception e) {
        } finally {
            array.recycle();
        }
        init(headerText, mainText);
    }

    private void init(String header, String main) {
        headerText = findViewById(R.id.header_text);
        mainText = findViewById(R.id.main_text);
        headerText.setText(header);
        mainText.setText(main);
    }

    public String getMainText() {
        return mainText.getText().toString();
    }

    public void setMainText(String mainText) {
        this.mainText.setText(mainText);
    }
}
