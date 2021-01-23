package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;


public class Main2Activity extends AppCompatActivity
{

    ImageButton bulb;
    ImageButton air;
    ImageButton tv;
    int count = 1;
    int timer_sec = 0;
    AnimatorSet ani4_set;

    private TimerTask second;
    private EditText timer_text;
    private final Handler handler = new Handler();
    public void testStart() {
        timer_text = findViewById(R.id.e2);
        second = new TimerTask() {
            @Override
            public void run() {
                Log.i("Test","Timer start");
                Update();
                timer_sec++;
            }
        };
        Timer timer = new Timer();
        timer.schedule(second,0,1000);
    }
    protected void Update() {
        Runnable updater = new Runnable() {
            @Override
            public void run()
            {
                timer_text.setText(timer_sec*50 + "");
            }
        };
        if (count == 1)
            handler.post(updater);
        if (count == 0)
        {
            handler.postDelayed(updater,1000000);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView left_hand = findViewById(R.id.left_hand);
        ImageButton imageButton = findViewById(R.id.imageButton7);
        ImageButton Setting = findViewById(R.id.imageButton8);
        ImageButton bill = findViewById(R.id.imageButton9);


        bulb = findViewById(R.id.imageButton5);
        air = findViewById(R.id.imageButton6);
        tv = findViewById(R.id.imageButton4);


        bill.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog4();
            }
        });

        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openDialog3();
            }
        });
        air.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openDialog2();
            }
        });
        bulb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openDialog();
            }
        });
        Setting.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }

        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Profile_cn.class);
                startActivity(intent);
            }
        });

        ani4_set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.hand_left);
        ani4_set.setTarget(left_hand);
        ani4_set.start();

        ani4_set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ani4_set.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });



    }
    public void openDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("전구 사용량 확인");
        builder.setMessage("전구를 작동할까요?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bulb.setActivated(true);
                count = 1;
                testStart();
            }
        });
        builder.setNeutralButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bulb.setActivated(false);
                count = 0;
                testStart();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void openDialog2()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("에어컨 사용량 확인");
        builder.setMessage("에어컨을 작동할까요?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                air.setActivated(true);
            }
        });
        builder.setNeutralButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                air.setActivated(false);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void openDialog3()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("TV 사용량 확인");
        builder.setMessage("TV를 작동할까요?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                tv.setActivated(true);
            }
        });
        builder.setNeutralButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                tv.setActivated(false);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void openDialog4()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("한달 요금 확인");
        builder.setMessage("한달 요금을 확인하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                timer_text = findViewById(R.id.e2);
                String info = timer_text.getText().toString();

                Intent myIntent = new Intent(Main2Activity.this, FinalActivity.class);
                myIntent.putExtra("전구 사용량", info);
                startActivity(myIntent);
            }
        });
        builder.setNeutralButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
