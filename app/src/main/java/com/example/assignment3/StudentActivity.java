package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class StudentActivity extends AppCompatActivity {
    private RecyclerView rv;

    private String[] name={"Ram","Shyam","Hari","Gita",
            "Ram","Shyam","Hari","Gita",
            "Ram","Shyam","Hari","Gita",
            "Ram","Shyam","Hari","Gita",
            "Ram","Shyam","Hari","Gita"};

    private String[] address={"Koteshwor","Baneshwor","Thimi","Lalitpur",
            "Koteshwor","Baneshwor","Thimi","Lalitpur",
            "Koteshwor","Baneshwor","Thimi","Lalitpur",
            "Koteshwor","Baneshwor","Thimi","Lalitpur",
            "Koteshwor","Baneshwor","Thimi","Lalitpur"};

    private String[] faculty={"BCA","BIM","BBA","BBS",
            "BCA","BIM","BBA","BBS",
            "BCA","BIM","BBA","BBS",
            "BCA","BIM","BBA","BBS",
            "BCA","BIM","BBA","BBS"};

    private int[] semester={1,2,3,4,
            1,2,3,4,
            1,2,3,4,
            1,2,3,4,
            1,2,3,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CustomAdapter(this,name,address,faculty,semester));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.logout){
            SharedPreferences sp=getSharedPreferences("state",MODE_PRIVATE);
            SharedPreferences.Editor et=sp.edit();
            et.putBoolean("loginstate",false);
            et.apply();
            Intent i=new Intent(StudentActivity.this,MainActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}