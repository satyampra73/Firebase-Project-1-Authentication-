package com.satyam.firebaseproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserData extends AppCompatActivity {
    EditText et_name,et_age;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        btn_add=findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> map=new HashMap<String,Object>();
                map.put("name",et_name.getText().toString());
                map.put("age",et_age.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("customer").push().setValue(map);
                Toast.makeText(UserData.this,"Successful",Toast.LENGTH_SHORT).show();


            }
        });
    }
}