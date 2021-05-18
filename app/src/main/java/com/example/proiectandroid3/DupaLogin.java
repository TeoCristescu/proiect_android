package com.example.proiectandroid3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DupaLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dupalogin);

        SharedPreferences sharedPreferences = this.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        String text = sharedPreferences.getString("utilizator", "");
        Toast.makeText(this, "Bine ai venit "+text + " !", Toast.LENGTH_SHORT).show();

    }

    public void go_to_cursuri(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void go_to_desprenoi(View view) {
        Intent it = new Intent(this, Maps.class);
        startActivity(it);
    }
    public void go_to_statistici(View view) {
        Intent it = new Intent(this, Statistici.class);
        startActivity(it);
    }
    public void go_to_logout(View view) {
        SharedPreferences preferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        preferences.edit().remove("utilizator").commit();
        Intent it = new Intent(this, Login.class);
        startActivity(it);
    }
}
