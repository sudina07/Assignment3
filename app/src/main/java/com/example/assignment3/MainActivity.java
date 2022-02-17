package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLoginStatus();

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.click);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("abc", Context.MODE_PRIVATE);
                String fusername=sp.getString("username","email");
                String fpassword=sp.getString("pass","password");
                String Uusername=email.getText().toString();
                String Upassword=password.getText().toString();
                if (fusername.equals(Uusername)&&fpassword.equals(Upassword)){
                    Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    SharedPreferences lp=getSharedPreferences("state",MODE_PRIVATE);
                    SharedPreferences.Editor et=lp.edit();
                    et.putBoolean("loginstate",true);
                    et.apply();
                    Intent i=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Incorrect email or password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(MainActivity.this,RegisterActivity.class);
               startActivity(i);
            }
        });
    }

    private void checkLoginStatus(){
        SharedPreferences sp=getSharedPreferences("state",MODE_PRIVATE);
        boolean state=sp.getBoolean("loginstate",false);
        if (state){
            Intent i=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(i);
        }
    }
}

