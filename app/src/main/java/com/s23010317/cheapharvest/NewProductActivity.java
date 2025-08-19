package com.s23010317.cheapharvest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class NewProductActivity extends AppCompatActivity {

    TextInputEditText productName, productPrice, productQuantity;
    Button saveButton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_product);

        productName = findViewById(R.id.textInputEditText3);
        productPrice = findViewById(R.id.textInputEditText);
        productQuantity = findViewById(R.id.textInputEditText2);
        saveButton = findViewById(R.id.button10);

        dbHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = productName.getText().toString().trim();
                String priceStr = productPrice.getText().toString().trim();
                String quantityStr = productQuantity.getText().toString().trim();

                if(name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()){
                    Toast.makeText(NewProductActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price;
                int quantity;

                try {
                    price = Double.parseDouble(priceStr);
                    quantity = Integer.parseInt(quantityStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(NewProductActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean inserted = dbHelper.insertProduct(name, price, quantity);

                if(inserted){
                    Toast.makeText(NewProductActivity.this, "Product saved", Toast.LENGTH_SHORT).show();
                    productName.setText("");
                    productPrice.setText("");
                    productQuantity.setText("");

                    // Open the product list activity
                    Intent intent = new Intent(NewProductActivity.this, ProductListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(NewProductActivity.this, "Error saving product", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
