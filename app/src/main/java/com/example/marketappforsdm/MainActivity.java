package com.example.marketappforsdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import com.example.marketappforsdm.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    private boolean isAuthenticated;

    @SuppressLint("NonConstantResourceId")
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        updateAuthenticationStatus();

        //Отключение темной темы, если будешь врубать обратно, то закоменти код ниже и
        //пробуй делать что-то не только с темой, но и цветами
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        isAuthenticated = checkAuthentication();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.main:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.catalog:
                    replaceFragment(new CatalogFragment());
                    break;

                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;

                case R.id.favorites:
                    if(isAuthenticated){
                        replaceFragment(new FavoriteFragmentNew());
                    } else {
                        replaceFragment(new FavoriteFragment());
                    }
                    break;

                case R.id.cabinet:
                    if(isAuthenticated){
                        replaceFragment(new CabinetFragmentNew());
                    } else {
                        replaceFragment(new CabinetFragment());
                    }
                    break;
            }
            return true;
        });
    }
    private boolean checkAuthentication() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return (user != null);
    }
    private void updateAuthenticationStatus() {
        FirebaseUser user = auth.getCurrentUser();
        isAuthenticated = user != null;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}