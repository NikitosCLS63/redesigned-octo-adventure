package com.example.java11simulation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivision extends AppCompatActivity {
    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private  Button btnnazad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        Animation slideOutDown = AnimationUtils.loadAnimation(this, R.anim.slide_out_down);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        setContentView(R.layout.tweenactivity);
        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.start_tween);
        pauseBtn = findViewById(R.id.pause_tween);
        btnnazad = findViewById(R.id.btnnazad);

        Animation blinkAnimation= AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.startAnimation(blinkAnimation);

                // Скрываем кнопку Старт с анимацией
                startBtn.startAnimation(slideOutDown);
                startBtn.setVisibility(View.GONE); // Скрываем кнопку после анимации

                // Показать кнопку Пауза с задержкой
                pauseBtn.postDelayed(() -> {
                    pauseBtn.setVisibility(View.VISIBLE);
                    pauseBtn.startAnimation(fadeIn);
                }, 300);
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.clearAnimation();
                // Скрываем кнопку Пауза с анимацией
                pauseBtn.startAnimation(slideOutDown);
                pauseBtn.setVisibility(View.GONE); // Скрываем кнопку после анимации

                // Показать кнопку Старт с задержкой
                startBtn.postDelayed(() -> {
                    startBtn.setVisibility(View.VISIBLE);
                    startBtn.startAnimation(fadeIn);
                }, 300);
            }
        });

        btnnazad.setOnClickListener(v -> {
            Intent intent = new Intent(this, Door.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_inright, R.anim.slide_out_left);
        });


    }


}
