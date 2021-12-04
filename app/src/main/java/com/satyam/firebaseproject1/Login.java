package com.satyam.firebaseproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText et_Email, et_password;
    private Button btn_login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_Email = findViewById(R.id.btnLoginEmail);
        et_password = findViewById(R.id.btnLoginPassword);
        btn_login = findViewById(R.id.btn_login);
        auth = FirebaseAuth.getInstance();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_Email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Field Can't be empty ", Toast.LENGTH_SHORT).show();
                } else {
                    login(email, password);
                }

            }
        });

    }
    private void login(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Login Completed ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,UserData.class));
                }
                else
                {
                    Toast.makeText(Login.this, "Failed to Login", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}