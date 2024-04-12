package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(home.this, profile.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(home.this, wallet.class);
        startActivity(intent);
    }

    public void OnClick2(View v) {
        Intent intent = new Intent(home.this, track.class);
        startActivity(intent);
    }

    public void OnClick3(View v) {
        Intent intent = new Intent(home.this, notifications.class);
        startActivity(intent);
    }
}