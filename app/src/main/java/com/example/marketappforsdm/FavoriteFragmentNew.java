package com.example.marketappforsdm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoriteFragmentNew extends Fragment {
    ConstraintLayout favorite_fragment_new;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_new, container, false);

        favorite_fragment_new = view.findViewById(R.id.favorite_fragment_new);

        Button startBuying = view.findViewById(R.id.startBuying);
        startBuying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, new CatalogFragment())
                        .addToBackStack(null)
                        .commit();
                BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_view);
                bottomNavigationView.setSelectedItemId(R.id.catalog);
            }
        });
        return view;
    }
}