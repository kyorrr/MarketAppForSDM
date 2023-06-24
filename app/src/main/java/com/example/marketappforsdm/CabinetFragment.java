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
public class CabinetFragment extends Fragment {
    ConstraintLayout rootCabinet;
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cabinet, container, false);

        rootCabinet = view.findViewById(R.id.rootCabinet);

        Button buttonLogin = rootCabinet.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }
        });

        Button buttonRegistration = rootCabinet.findViewById(R.id.buttonRegistration);
        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RegistrationActivity.class);
                startActivity(myIntent);
            }
        });

        Button myOrders = rootCabinet.findViewById(R.id.myZakazi);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Нужно выполнить вход в аккаунт!", Toast.LENGTH_SHORT).show();
            }
        });

        Button historyOfOrders = rootCabinet.findViewById(R.id.historyOfZakazi);
        historyOfOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Нужно выполнить вход в аккаунт!", Toast.LENGTH_SHORT).show();
            }
        });

        Button statusOfOrders = rootCabinet.findViewById(R.id.statusZakaza);
        statusOfOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button settings = rootCabinet.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button whatToUpd = rootCabinet.findViewById(R.id.whattoupd);
        whatToUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button information = rootCabinet.findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}