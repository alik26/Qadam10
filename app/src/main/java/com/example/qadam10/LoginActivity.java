package com.example.qadam10;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity  {


    FragmentTransaction fTrans;
    ImageButton plusBtn;





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;


                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.navigation_done:
                            selectedFragment = new DoneFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectedFragment).commit();

                    return true;
                }
            };




}