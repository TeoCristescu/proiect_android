package com.example.proiectandroid3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Statistici extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DesenPieChart(this));
    }

}