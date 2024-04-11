package com.example.myapplication111;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextWatcher;


public class Otp extends AppCompatActivity {

    private EditText editText1, editText2, editText3, editText4, editText5, editText6;
    private Button setNewPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);

        setNewPasswordButton = findViewById(R.id.setNewPasswordButton);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText1.getText().length() == 1 &&
                        editText2.getText().length() == 1 &&
                        editText3.getText().length() == 1 &&
                        editText4.getText().length() == 1 &&
                        editText5.getText().length() == 1 &&
                        editText6.getText().length() == 1) {
                    setNewPasswordButton.setEnabled(true);
                    setNewPasswordButton.setBackgroundColor(Color.BLUE);
                } else {
                    setNewPasswordButton.setEnabled(false);
                    setNewPasswordButton.setBackgroundColor(Color.GRAY);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);
        editText4.addTextChangedListener(textWatcher);
        editText5.addTextChangedListener(textWatcher);
        editText6.addTextChangedListener(textWatcher);

        // Устанавливаем начальный цвет кнопки и ее доступность
        setNewPasswordButton.setBackgroundColor(Color.GRAY);
        setNewPasswordButton.setEnabled(false);
    }
}