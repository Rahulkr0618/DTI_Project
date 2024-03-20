package com.example.dti_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {

    ImageButton kathibutton;
    ImageButton laundrybutton;
    TextView textlaundry;
    TextView textkathi;
    TextView textemailuser;
    ImageButton drawerbutton;
    TextView navEmailid;
    Button logout;
    FirebaseAuth Auth;
    FirebaseUser User;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    private boolean doubleBackToExitPressedOnce = false;
    private static final int TIME_INTERVAL = 2000;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, TIME_INTERVAL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Auth = FirebaseAuth.getInstance();
        User = Auth.getCurrentUser();
        textemailuser = findViewById(R.id.textuseremail);
        textkathi = findViewById(R.id.textkathi);
        textlaundry = findViewById(R.id.textlaundry);
        kathibutton = findViewById(R.id.kathibutton);
        laundrybutton = findViewById(R.id.laundrybutton);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerbutton = findViewById(R.id.drawerButton);
        navigationView = findViewById(R.id.navigationView);
        logout = findViewById(R.id.logout);

        View headerview = navigationView.getHeaderView(0);
        navEmailid = headerview.findViewById(R.id.navemailid);

        if(User==null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            navEmailid.setText(User.getEmail());
        }

        if(User==null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            textemailuser.setText(User.getEmail());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        laundrybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, LaundryLogin.class);
                startActivity(intent);
                finish();
            }
        });

        kathibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,KathiHomePage.class);
                startActivity(intent);
                finish();
            }
        });

        textlaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, LaundryLogin.class);
                startActivity(intent);
                finish();
            }
        });

        drawerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        textkathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,KathiHomePage.class);
                startActivity(intent);
                finish();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemid = item.getItemId();

                if(itemid==R.id.navfeedback){
                    startActivity(new Intent(HomeScreen.this, FeedbackPage.class));

                }

                if(itemid==R.id.navrush){
                    startActivity(new Intent(HomeScreen.this, RushHourActivity.class));
                }

                if(itemid==R.id.navlogout){
                    //
                }

                drawerLayout.close();

                return false;
            }
        });

    }
}