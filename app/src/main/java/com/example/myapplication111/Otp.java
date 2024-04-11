package com.example.myapplication111;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = (EditText) getCurrentFocus();
                if (editText != null && editText.length() == 1) {
                    if (editText == editText1) {
                        editText2.requestFocus();
                    } else if (editText == editText2) {
                        editText3.requestFocus();
                    } else if (editText == editText3) {
                        editText4.requestFocus();
                    } else if (editText == editText4) {
                        editText5.requestFocus();
                    } else if (editText == editText5) {
                        editText6.requestFocus();
                    } else if (editText == editText6) {
                        // Если введены все символы, скрываем клавиатуру
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText6.getWindowToken(), 0);
                    }
                }

                // Проверяем, все ли EditText заполнены
                checkAllEditTextFilled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
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

    private void checkAllEditTextFilled() {
        if (!editText1.getText().toString().isEmpty() &&
                !editText2.getText().toString().isEmpty() &&
                !editText3.getText().toString().isEmpty() &&
                !editText4.getText().toString().isEmpty() &&
                !editText5.getText().toString().isEmpty() &&
                !editText6.getText().toString().isEmpty()) {
            setNewPasswordButton.setEnabled(true);
            setNewPasswordButton.setBackgroundColor(Color.BLUE);
        } else {
            setNewPasswordButton.setEnabled(false);
            setNewPasswordButton.setBackgroundColor(Color.GRAY);
        }
    }

    public void OnClick(View v) {
        Intent intent = new Intent(Otp.this, newpassword.class);
        startActivity(intent);
    }
}
