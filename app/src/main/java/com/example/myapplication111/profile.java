package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(profile.this, signin.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(profile.this, home.class);
        startActivity(intent);
    }

    public void OnClick2(View v) {
        Intent intent = new Intent(profile.this, wallet.class);
        startActivity(intent);
    }

    public void OnClick3(View v) {
        Intent intent = new Intent(profile.this, track.class);
        startActivity(intent);
    }
}