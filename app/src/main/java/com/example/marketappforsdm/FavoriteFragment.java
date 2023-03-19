package com.example.marketappforsdm;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FavoriteFragment extends Fragment {
    private Button btnLoginFavorite;
    ConstraintLayout favorite_fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);

        favorite_fragment = view.findViewById(R.id.favorite_fragment);

        btnLoginFavorite = favorite_fragment.findViewById(R.id.btnLoginFavorite);
        btnLoginFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });
        return view;
    }
}