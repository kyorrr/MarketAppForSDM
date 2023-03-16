package com.example.marketappforsdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketappforsdm.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    Button btnReg;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnReg = findViewById(R.id.btnReg);
        root = findViewById(R.id.rootElement);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText login = root.findViewById(R.id.inputUsername);
                final EditText email = root.findViewById(R.id.inputEmail);
                final EditText phone = root.findViewById(R.id.inputMobile);
                final EditText pass = root.findViewById(R.id.inputPassword);
                final EditText pass2 = root.findViewById(R.id.inputPassword2);

                        if(TextUtils.isEmpty(login.getText().toString())){
                            Toast.makeText(RegistrationActivity.this, "Введите логин!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(TextUtils.isEmpty(email.getText().toString())){
                            Toast.makeText(RegistrationActivity.this, "Введите почту!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(TextUtils.isEmpty(phone.getText().toString())){
                            Toast.makeText(RegistrationActivity.this, "Введите телефон!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(TextUtils.isEmpty(pass.getText().toString())) {
                            Toast.makeText(RegistrationActivity.this, "Введите пароль!",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(pass.getText().toString().length() < 6) {
                            Toast.makeText(RegistrationActivity.this, "Пароль меньше 6 символов! ",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(!pass2.getText().toString().equals(pass.getText().toString())) {
                            Toast.makeText(RegistrationActivity.this, "Пароли не совпадают!",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //Регистрация пользователя
                        auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        User user = new User();
                                        user.setLogin(login.getText().toString());
                                        user.setEmail(email.getText().toString());
                                        user.setPhone(phone.getText().toString());
                                        user.setPass(pass.getText().toString());
                                        user.setPass2(pass2.getText().toString());

                                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {

                                                        auth.getCurrentUser().sendEmailVerification()
                                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if(task.isSuccessful()){
                                                                    Toast.makeText(RegistrationActivity.this,
                                                                            "Регистрация успешна! " +
                                                                                    "Подтвердите вашу электронную почту!",
                                                                            Toast.LENGTH_SHORT).show();
                                                                    startActivity(new Intent(RegistrationActivity.this,
                                                                            LoginActivity.class));
                                                                    finish();
                                                                }
                                                                else{
                                                                    Snackbar.make(root,
                                                                            "Регистрация не удалась! " + task
                                                                                    .getException().getMessage(),
                                                                            Snackbar.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });
                                                    }
                                                });
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root,
                                "Регистрация не удалась! " + e.getMessage(),
                                Snackbar.LENGTH_SHORT).show();
                    }
                });
                    }
                });
        TextView btn2 = findViewById(R.id.noAccount);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });
        TextView btn3 = findViewById(R.id.loginActivity);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,  LoginActivity.class));
            }
        });
    }
}