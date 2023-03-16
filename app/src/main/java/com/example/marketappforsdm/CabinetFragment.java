package com.example.marketappforsdm;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CabinetFragment extends Fragment {

    private Button buttonLogin, buttonRegistration, myZakazi, historyOfZakazi, statusZakaza;

    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout rootCabinet;

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cabinet, container, false);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        rootCabinet = view.findViewById(R.id.rootCabinet);

        buttonLogin = rootCabinet.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });
        buttonRegistration = rootCabinet.findViewById(R.id.buttonRegistration);
        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RegistrationActivity.class);
                startActivity(myIntent);
            }
        });
        myZakazi = rootCabinet.findViewById(R.id.myZakazi);
        myZakazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Нужно выполнить вход в аккаунт!", Toast.LENGTH_SHORT).show();
            }
        });
        historyOfZakazi = rootCabinet.findViewById(R.id.historyOfZakazi);
        historyOfZakazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Нужно выполнить вход в аккаунт!", Toast.LENGTH_SHORT).show();
            }
        });
        statusZakaza = rootCabinet.findViewById(R.id.statusZakaza);
        statusZakaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}