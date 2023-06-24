package com.example.marketappforsdm;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.marketappforsdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private boolean isAuthenticated;

    @SuppressLint("NonConstantResourceId")
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        updateAuthenticationStatus();

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
        return false;
    }
    private void updateAuthenticationStatus() {
        checkAuthentication();
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}