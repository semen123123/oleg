package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }


    public void OnClick2(View v) {
        Intent intent = new Intent(notifications.this, home.class);
        startActivity(intent);
    }
}