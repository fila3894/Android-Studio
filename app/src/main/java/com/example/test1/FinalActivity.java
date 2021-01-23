package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView bulbtext = findViewById(R.id.textView16);

        Intent bIntent = getIntent();
        String bulb = bIntent.getStringExtra("전구 사용량");
        bulbtext.setText(bulb);

    }
}