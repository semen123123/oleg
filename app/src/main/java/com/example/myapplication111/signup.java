package com.example.myapplication111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.text.method.PasswordTransformationMethod;

public class signup extends AppCompatActivity {

    private EditText editTextFullName, editTextPhoneNumber, editTextEmailAddress, editTextPassword, editTextConfirmPassword;
    private CheckBox checkBox, checkBoxShowPassword, checkBoxShowConfirmPassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextTextConfirmPassword);
        checkBox = findViewById(R.id.checkBox);
        checkBoxShowPassword = findViewById(R.id.checkBoxShowPassword);
        checkBoxShowConfirmPassword = findViewById(R.id.checkBoxShowConfirmPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonSignUp.setEnabled(isChecked);
                if (isChecked) {
                    buttonSignUp.setBackgroundColor(getResources().getColor(R.color.buttonColor));
                } else {
                    buttonSignUp.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });

        editTextFullName.addTextChangedListener(watcher);
        editTextPhoneNumber.addTextChangedListener(watcher);
        editTextEmailAddress.addTextChangedListener(watcher);
        editTextPassword.addTextChangedListener(watcher);
        editTextConfirmPassword.addTextChangedListener(watcher);

        buttonSignUp.setEnabled(false);
        buttonSignUp.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

        buttonSignUp.setOnClickListener(v -> signUp());

        checkBoxShowPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editTextPassword.setTransformationMethod(null); // Показать символы
            } else {
                editTextPassword.setTransformationMethod(new PasswordTransformationMethod()); // Скрыть символы
            }
        });

        checkBoxShowConfirmPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                editTextConfirmPassword.setTransformationMethod(null); // Показать символы
            } else {
                editTextConfirmPassword.setTransformationMethod(new PasswordTransformationMethod()); // Скрыть символы
            }
        });
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkSignUpConditions();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void checkSignUpConditions() {
        String fullName = editTextFullName.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String emailAddress = editTextEmailAddress.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        boolean isFullNameValid = fullName.matches("[A-Za-z]+\\s[A-Za-z]+");
        boolean isPhoneNumberValid = Patterns.PHONE.matcher(phoneNumber).matches();
        boolean isEmailAddressValid = Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches();
        boolean isPasswordValid = !password.isEmpty() && password.equals(confirmPassword);
        boolean isAgreedToTerms = checkBox.isChecked();

        if (isFullNameValid && isPhoneNumberValid && isEmailAddressValid && isPasswordValid && isAgreedToTerms) {
            buttonSignUp.setEnabled(true);
            buttonSignUp.setBackgroundColor(getResources().getColor(R.color.blue));
        } else {
            buttonSignUp.setEnabled(false);
            buttonSignUp.setBackgroundColor(getResources().getColor(R.color.gray));
        }
    }

    private void signUp() {
        String fullName = editTextFullName.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String emailAddress = editTextEmailAddress.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        if (!fullName.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty() &&
                !password.isEmpty() && !confirmPassword.isEmpty()) {
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(signup.this, signin.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void OnClick (View v){
        Intent intent = new Intent(signup.this, signin.class);
        startActivity(intent);
    }
}