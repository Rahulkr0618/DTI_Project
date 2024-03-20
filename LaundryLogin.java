package com.example.dti_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LaundryLogin extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry_login);
    }
}