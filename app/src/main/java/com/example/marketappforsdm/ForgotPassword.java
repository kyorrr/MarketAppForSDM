package com.example.marketappforsdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ForgotPassword extends AppCompatActivity {

    Button btn_forgotPass;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout root3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        btn_forgotPass = findViewById(R.id.btn_forgotPass);
        root3 = findViewById(R.id.root3);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btn_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText email = findViewById(R.id.inputEmail);
                if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(ForgotPassword.this, "Введите почту!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    auth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Пожалуйста, проверьте вашу почту!"
                                        ,Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgotPassword.this, LoginActivity.class));
                                finish();
                            }
                            else{
                                Snackbar.make(root3, "Ошибка! " + task.getException().getMessage(),
                                        Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView btnBack = findViewById(R.id.btnBack3);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}