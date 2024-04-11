package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class forgotpassword extends AppCompatActivity {

    private EditText editTextEmailAddress;
    private Button buttonSendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        buttonSendOTP = findViewById(R.id.button);

        buttonSendOTP.setEnabled(false);
        buttonSendOTP.setBackgroundColor(getResources().getColor(R.color.gray));

        editTextEmailAddress.addTextChangedListener(watcher);
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkEmailValidity();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void checkEmailValidity() {
        String emailAddress = editTextEmailAddress.getText().toString();

        boolean isValidEmail = isValidEmail(emailAddress);

        if (isValidEmail) {
            buttonSendOTP.setEnabled(true);
            buttonSendOTP.setBackgroundColor(getResources().getColor(R.color.blue));
        } else {
            buttonSendOTP.setEnabled(false);
            buttonSendOTP.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(forgotpassword.this, signin.class);
        startActivity(intent);

    }
    public void OnClick(View v) {
        Intent intent = new Intent(forgotpassword.this, Otp.class);
        startActivity(intent);
    }
}




