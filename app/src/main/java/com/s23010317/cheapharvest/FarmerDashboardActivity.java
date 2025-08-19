package com.s23010317.cheapharvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class FarmerDashboardActivity extends AppCompatActivity {

    Button btnAddProduct, btnViewOrders, btnShareLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_dashboard);

        btnAddProduct = findViewById(R.id.button);      // "Add New Products"
        btnViewOrders = findViewById(R.id.button3);     // "View Orders"
        btnShareLocation = findViewById(R.id.button14); // "Share Location"

        // Navigate to NewProductActivity
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FarmerDashboardActivity.this, NewProductActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to OrdersActivity
        btnViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FarmerDashboardActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to LocationActivity
        btnShareLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FarmerDashboardActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
