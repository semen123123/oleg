package com.example.myapplication111;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class onboard2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboard2);
        };

    public void OnClick(View v) {
        Intent intent = new Intent(onboard2.this, onboard3.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(onboard2.this, onboard3.class);
        startActivity(intent);
    }
}