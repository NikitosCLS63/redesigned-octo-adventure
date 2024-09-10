package com.example.java11simulation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button startBTN;
    private Button pauseBTN;
    private  Button btnperehod;

    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frameanumation);

        final Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        animationIV = findViewById(R.id.animImageView);
        startBTN = findViewById(R.id.startButton);
        pauseBTN = findViewById(R.id.pauseButton);
        btnperehod = findViewById(R.id.btnperehod);


        frameAnimation = (AnimationDrawable) animationIV.getDrawable();
        startBTN.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();

                // Анимация исчезновения кнопки Старт
                startBTN.startAnimation(fadeOut);

                // Скрываем кнопку после анимации
                startBTN.setVisibility(View.GONE);


                pauseBTN.postDelayed(() -> {
                    pauseBTN.setVisibility(View.VISIBLE);
                    pauseBTN.startAnimation(fadeIn);
                }, 500); // Время анимации
            }
        });
        pauseBTN.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();

                // Анимация исчезновения кнопки Пауза
                pauseBTN.startAnimation(fadeOut);

                // Скрываем кнопку после анимации
                pauseBTN.setVisibility(View.GONE);


                startBTN.postDelayed(() -> {
                    startBTN.setVisibility(View.VISIBLE);
                    startBTN.startAnimation(fadeIn);
                }, 500); // Время анимации
            }
        });

        btnperehod.setOnClickListener(v -> {
            Intent intent = new Intent(this, Door.class);
            startActivity(intent);
           overridePendingTransition(R.anim.slide_inright, R.anim.slide_out_left);

                }


        );
//        btnperehod.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MainActivision.class));
//            }
//        });




    }
}

