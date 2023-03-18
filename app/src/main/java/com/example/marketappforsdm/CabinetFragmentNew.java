package com.example.marketappforsdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CabinetFragmentNew extends Fragment {

    private Button myZakazi, historyOfZakazi, statusZakaza, leaveFromAcc, setting, whattoupd, information;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout rootCabinetNew;

    @SuppressLint("MissingInflatedId")
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cabinet_new, container, false);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Fragment fragment = new CabinetFragment();
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        rootCabinetNew = view.findViewById(R.id.rootCabinetNew);

        myZakazi = rootCabinetNew.findViewById(R.id.myZakazi);
        myZakazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), ZakaziActivity.class);
//                startActivity(intent);
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        historyOfZakazi = rootCabinetNew.findViewById(R.id.historyOfZakazi);
        historyOfZakazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        statusZakaza = rootCabinetNew.findViewById(R.id.statusZakaza);
        statusZakaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        leaveFromAcc = rootCabinetNew.findViewById(R.id.leaveFromAcc);
        leaveFromAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Fragment fragment = new CabinetFragment();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
        });
        setting = rootCabinetNew.findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        whattoupd = rootCabinetNew.findViewById(R.id.whattoupd);
        whattoupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        information = rootCabinetNew.findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}