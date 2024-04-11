package com.example.myapplication111;

import android.os.Bundle;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class newpassword extends AppCompatActivity {

    private EditText editTextPassword, editTextConfirmPassword;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);

        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        logInButton = findViewById(R.id.logInButton);

        // Устанавливаем начальный цвет кнопки и ее доступность
        logInButton.setEnabled(false);
        logInButton.setBackgroundColor(Color.GRAY);

        // Добавляем слушатели текста для каждого EditText
        editTextPassword.addTextChangedListener(textWatcher);
        editTextConfirmPassword.addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkFields();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    private void checkFields() {
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        // Проверяем, заполнены ли оба EditText и совпадают ли их значения
        if (!password.isEmpty() && !confirmPassword.isEmpty() && password.equals(confirmPassword)) {
            // Если условия выполняются, делаем кнопку "Log In" кликабельной и синей
            logInButton.setEnabled(true);
            logInButton.setBackgroundColor(Color.BLUE);
        } else {
            // В противном случае делаем кнопку "Log In" некликабельной и серой
            logInButton.setEnabled(false);
            logInButton.setBackgroundColor(Color.GRAY);
        }
    }
}