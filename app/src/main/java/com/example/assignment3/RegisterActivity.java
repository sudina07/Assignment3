package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.click);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=email.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences sp=getSharedPreferences("abc", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("username",username);
                ed.putString("pass",pass);
                ed.apply();
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}