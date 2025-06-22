package com.s23010317.cheapharvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText nameInput, emailInput, passwordInput;
    Button btnSignup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Get input fields
        nameInput = findViewById(R.id.editTextText2); // Name
        emailInput = findViewById(R.id.editTextTextEmailAddress); // Email
        passwordInput = findViewById(R.id.editTextTextPassword); // Password
        btnSignup = findViewById(R.id.button2); // Sign Up

        db = new DatabaseHelper(this); // DB instance

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean inserted = db.insertUser(name, email, password);
                    if (inserted) {
                        Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this, UserActivity.class));
                    } else {
                        Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
