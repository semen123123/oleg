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
import android.widget.Toast;

public class signin extends AppCompatActivity {

    private EditText editTextEmailAddressSignIn, editTextPasswordSignIn;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextEmailAddressSignIn = findViewById(R.id.editTextEmailAddressSignIn);
        editTextPasswordSignIn = findViewById(R.id.editTextPasswordSignIn);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        buttonSignIn.setEnabled(false);
        buttonSignIn.setBackgroundColor(getResources().getColor(R.color.gray));

        editTextPasswordSignIn.addTextChangedListener(watcher);
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkSignInConditions();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void checkSignInConditions() {
        String emailAddress = editTextEmailAddressSignIn.getText().toString();
        String password = editTextPasswordSignIn.getText().toString();

        boolean isEmailAddressValid = isValidEmail(emailAddress);
        boolean isPasswordValid = !password.isEmpty();

        if (isEmailAddressValid && isPasswordValid) {
            buttonSignIn.setEnabled(true);
            buttonSignIn.setBackgroundColor(getResources().getColor(R.color.blue));
        } else {
            buttonSignIn.setEnabled(false);
            buttonSignIn.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }

    public void signIn(View view) {
        String emailAddress = editTextEmailAddressSignIn.getText().toString();
        String password = editTextPasswordSignIn.getText().toString();

        if (isValidEmail(emailAddress) && !password.isEmpty()) {
            Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();


    }

    public void OnClick(View v) {
        Intent intent = new Intent(signin.this, signup.class);
        startActivity(intent);
    }

    public void OnClick1(View v) {
        Intent intent = new Intent(signin.this, forgotpassword.class);
        startActivity(intent);
    }

    public void OnClick2(View v) {
        Intent intent = new Intent(signin.this, home.class);
        startActivity(intent);
    }
}
