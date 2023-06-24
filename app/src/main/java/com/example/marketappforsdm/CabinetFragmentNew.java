package com.example.marketappforsdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
public class CabinetFragmentNew extends Fragment {
    ConstraintLayout rootCabinetNew;
    @SuppressLint("MissingInflatedId")
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cabinet_new, container, false);

        rootCabinetNew = view.findViewById(R.id.rootCabinetNew);

        Button myOrders = rootCabinetNew.findViewById(R.id.myZakazi);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ZakaziActivity.class);
                startActivity(intent);
            }
        });

        Button historyOfOrders = rootCabinetNew.findViewById(R.id.historyOfZakazi);
        historyOfOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button statusOfOrders = rootCabinetNew.findViewById(R.id.statusZakaza);
        statusOfOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button leaveFromAcc = rootCabinetNew.findViewById(R.id.leaveFromAcc);
        leaveFromAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        Button settings = rootCabinetNew.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button whatToUpd = rootCabinetNew.findViewById(R.id.whattoupd);
        whatToUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        Button information = rootCabinetNew.findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "В разработке!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}