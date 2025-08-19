package com.s23010317.cheapharvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConsumerDashboardActivity extends AppCompatActivity {

    Button fruitsBtn, vegetablesBtn, dairyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_dashboard);

        // Buttons from consumer_dashboard.xml
        fruitsBtn = findViewById(R.id.button11);      // Fruits
        vegetablesBtn = findViewById(R.id.button12);  // Vegetables
        dairyBtn = findViewById(R.id.button13);       // Dairy

        // Navigate to Fruits
        fruitsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsumerDashboardActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Vegetables
        vegetablesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsumerDashboardActivity.this, VegetablesActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Dairy
        dairyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsumerDashboardActivity.this, DairyActivity.class);
                startActivity(intent);
            }
        });
    }
}
