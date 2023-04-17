package com.example.marketappforsdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketappforsdm.models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout root2;
    ProgressDialog dialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        root2 = findViewById(R.id.rootElementLogin);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        dialog = new ProgressDialog(this);
        dialog.setMessage("Подождите...");
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText email = root2.findViewById(R.id.inputEmail);
                final EditText pass = root2.findViewById(R.id.inputPassword);
                        if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast.makeText(LoginActivity.this, "Введите Логин!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (pass.getText().toString().length() < 6) {
                            Toast.makeText(LoginActivity.this, "Введите пароль!",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        dialog.show();

                        auth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        dialog.dismiss();
                                        if(auth.getCurrentUser().isEmailVerified()){
                                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                            finish();
                                        }
                                        else{
                                            Toast.makeText(LoginActivity.this, "Подтвердите почту!",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialog.dismiss();
                                        Snackbar.make(root2,
                                                "Ошибка авторизации! " + e.getMessage(),
                                                Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });

        TextView btn = findViewById(R.id.SignUpBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });
        TextView btn2 = findViewById(R.id.noAccount);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        TextView btn3 = findViewById(R.id.forgotPassword);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
            }
        });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView btnBack = findViewById(R.id.btnBack2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}