package com.s23010317.cheapharvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FingerprintAccessActivity extends AppCompatActivity {

    Button btnFingerprintLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fingerprint_access); // Your fingerprint_access.xml

        btnFingerprintLogin = findViewById(R.id.button6); // Login button id in fingerprint_access.xml

        btnFingerprintLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to UserActivity after fingerprint authentication
                Intent intent = new Intent(FingerprintAccessActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
