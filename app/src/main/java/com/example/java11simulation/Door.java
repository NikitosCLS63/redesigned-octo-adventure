package com.example.java11simulation;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Door extends AppCompatActivity {

    private Button tween;
    private Button frame;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tween = findViewById(R.id.tween);
        frame = findViewById(R.id.frame);

        tween.setOnClickListener(v -> {
                    Intent intent = new Intent(this, MainActivision.class);
                    startActivity(intent);
            overridePendingTransition(R.anim.slide_inright, R.anim.slide_out_left);
                }


        );

        frame.setOnClickListener(v -> {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                overridePendingTransition(R.anim.slide_inright, R.anim.slide_out_left);
                }


        );
};
}



