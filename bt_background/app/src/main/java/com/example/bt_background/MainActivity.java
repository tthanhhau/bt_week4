package com.example.bt_background;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainLayout;
    private Switch switchChangeBackground;
    private List<Integer> backgroundList;
    private int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        switchChangeBackground = findViewById(R.id.switchChangeBackground);

        initBackgroundList();
        changeBackground();

        switchChangeBackground.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                changeBackground();
            }
        });
    }

    private void initBackgroundList() {
        backgroundList = new ArrayList<>();
        backgroundList.add(R.drawable.bg1);
        backgroundList.add(R.drawable.bg2);
        backgroundList.add(R.drawable.bg3);
        backgroundList.add(R.drawable.bg4);
        Collections.shuffle(backgroundList);
    }

    private void changeBackground() {
        currentIndex++;

        if (currentIndex >= backgroundList.size()) {
            Collections.shuffle(backgroundList);
            currentIndex = 0;
        }

        Drawable background = getResources().getDrawable(backgroundList.get(currentIndex));
        mainLayout.setBackground(background);
    }
}
