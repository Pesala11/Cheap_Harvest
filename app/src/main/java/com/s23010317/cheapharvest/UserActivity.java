package com.s23010317.cheapharvest;

import static com.s23010317.cheapharvest.R.id.button9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    Button farmerButton, consumerButton;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        farmerButton = findViewById(R.id.button8);    // Farmer ImageButton
        consumerButton = findViewById(button9); // Consumer ImageButton

        farmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, FarmerDashboardActivity.class);
                startActivity(intent);
            }
        });

        consumerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, ConsumerDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
