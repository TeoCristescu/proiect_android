package com.example.proiectandroid3;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaginaCurs extends  AppCompatActivity{
    private TextView titlu;
    private TextView continut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginacurs);
        titlu = findViewById(R.id.titlu);
        continut = findViewById(R.id.continut);
        String text1=getIntent().getStringExtra("titlu");
        String text2=getIntent().getStringExtra("continut");




        titlu.setText(text1);
        continut.setText(text2);


    }
}
