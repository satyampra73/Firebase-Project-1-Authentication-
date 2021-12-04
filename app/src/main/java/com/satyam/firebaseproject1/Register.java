package com.satyam.firebaseproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
private EditText et_email,et_password;
private Button btn_register;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        btn_register=findViewById(R.id.btn_register);
        auth=FirebaseAuth.getInstance();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=et_email.getText().toString().trim();
                String password =et_password.getText().toString().trim();
                if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Field Can't be empty ", Toast.LENGTH_SHORT).show();
                }
                else {
                    regis(email,password);
                }
                
            }

        });
    }
    private void regis(String email,String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Registration Completed ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_SHORT).show();
                }

            }
        });
        
    }
}