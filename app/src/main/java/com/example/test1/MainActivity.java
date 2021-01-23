package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimatorSet ani_set;
    AnimatorSet ani2_set, ani3_set;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ele = findViewById(R.id.ele);
        ImageView elebulb = findViewById(R.id.elebulb);
        ImageView eletv = findViewById(R.id.eletv);

        ani_set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fisrt_animation);
        ani_set.setTarget(ele);
        ani_set.start();

        ani_set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ani_set.start();


            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ani2_set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.alpha);
        ani2_set.setTarget(elebulb);
        ani2_set.start();


        ani2_set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ani2_set.start();
                ani3_set.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        ani3_set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.alpha);
        ani3_set.setTarget(eletv);
        ani3_set.start();

        ani3_set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ani3_set.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }

        });
    }
}
