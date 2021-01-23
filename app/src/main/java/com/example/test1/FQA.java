package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FQA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fqa);

        Button fqais = findViewById(R.id.fqabutton);
        Button fqaprofile = findViewById(R.id.fqabutton2);
        final Button HowToBoot = findViewById(R.id.fqabutton4);

        fqais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FQA.this, Fqais.class);
                startActivity(intent);
            }
        });

        fqaprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FQA.this, Fqaprofile.class);
                startActivity(intent);
            }
        });

        HowToBoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FQA.this, HowToBoot.class);
                startActivity(intent);
            }
        });

    }
}