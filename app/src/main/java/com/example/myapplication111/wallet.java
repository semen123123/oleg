package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
    }

    public void OnClick(View v) {
        Intent intent = new Intent(wallet.this, home.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(wallet.this, track.class);
        startActivity(intent);
    }

    public void OnClick2(View v) {
        Intent intent = new Intent(wallet.this, profile.class);
        startActivity(intent);
    }
}