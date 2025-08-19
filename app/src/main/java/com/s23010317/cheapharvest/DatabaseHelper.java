package com.s23010317.cheapharvest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database info
    public static final String DATABASE_NAME = "CheapHarvest.db";
    public static final int DATABASE_VERSION = 1;

    // Users table
    public static final String USERS_TABLE = "users";
    public static final String USER_COL_ID = "ID";
    public static final String USER_COL_NAME = "name";
    public static final String USER_COL_EMAIL = "email";
    public static final String USER_COL_PASSWORD = "password";

    // Products table
    public static final String PRODUCTS_TABLE = "products";
    public static final String PRODUCT_COL_ID = "ID";
    public static final String PRODUCT_COL_NAME = "name";
    public static final String PRODUCT_COL_PRICE = "price";
    public static final String PRODUCT_COL_QUANTITY = "quantity";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Users table
        db.execSQL("CREATE TABLE " + USERS_TABLE + " (" +
                USER_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_COL_NAME + " TEXT, " +
                USER_COL_EMAIL + " TEXT, " +
                USER_COL_PASSWORD + " TEXT)");

        // Create Products table
        db.execSQL("CREATE TABLE " + PRODUCTS_TABLE + " (" +
                PRODUCT_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PRODUCT_COL_NAME + " TEXT, " +
                PRODUCT_COL_PRICE + " REAL, " +
                PRODUCT_COL_QUANTITY + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCTS_TABLE);
        onCreate(db);
    }

    // Insert a new user
    public boolean insertUser(String name, String email, String password) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(USER_COL_NAME, name);
            values.put(USER_COL_EMAIL, email);
            values.put(USER_COL_PASSWORD, password);
            long result = db.insert(USERS_TABLE, null, values);
            Log.d("DB_INSERT", "User Inserted: " + name + ", " + email);
            return result != -1;
        } catch (Exception e) {
            Log.e("DB_ERROR", "User insert failed", e);
            return false;
        }
    }

    // Insert a new product
    public boolean insertProduct(String name, double price, int quantity) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(PRODUCT_COL_NAME, name);
            values.put(PRODUCT_COL_PRICE, price);
            values.put(PRODUCT_COL_QUANTITY, quantity);
            long result = db.insert(PRODUCTS_TABLE, null, values);
            Log.d("DB_INSERT", "Product Inserted: " + name + ", " + price + ", " + quantity);
            return result != -1;
        } catch (Exception e) {
            Log.e("DB_ERROR", "Product insert failed", e);
            return false;
        }
    }

    // Get all products
    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(PRODUCTS_TABLE, null, null, null, null, null, null);
    }

    // Optional: Get a single product by ID
    public Cursor getProductById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(PRODUCTS_TABLE, null, PRODUCT_COL_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);
    }

    // Optional: Delete a product
    public boolean deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(PRODUCTS_TABLE, PRODUCT_COL_ID + "=?",
                new String[]{String.valueOf(id)});
        return result > 0;
    }

    // Optional: Update a product
    public boolean updateProduct(int id, String name, double price, int quantity) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(PRODUCT_COL_NAME, name);
            values.put(PRODUCT_COL_PRICE, price);
            values.put(PRODUCT_COL_QUANTITY, quantity);
            int result = db.update(PRODUCTS_TABLE, values, PRODUCT_COL_ID + "=?",
                    new String[]{String.valueOf(id)});
            return result > 0;
        } catch (Exception e) {
            Log.e("DB_ERROR", "Product update failed", e);
            return false;
        }
    }
}
