package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class onboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(onboard.this, onboard2.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(onboard.this, onboard3.class);
        startActivity(intent);
    }
}