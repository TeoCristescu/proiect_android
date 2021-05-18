package com.example.proiectandroid3;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
public class Login extends  AppCompatActivity{
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "utilizator";
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Register.database = Room.databaseBuilder(this, UserDataBase.class, "app-database").allowMainThreadQueries().build();
        username = findViewById(R.id.username);
        password = findViewById(R.id.parola);
    }

    public void sendToRegister(View view) {
        Intent it = new Intent(this, Register.class);
        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Am adaugat utilizatorul cu succes!", Toast.LENGTH_SHORT).show();
            }
    }
    public void login(View view) {
        String numeutilizator = username.getText().toString();
        String parola = password.getText().toString();

        UserEntity user = Register.database.userDao().searchForUser(numeutilizator, parola);

        List<UserEntity> usersList = Register.database.userDao().checkUsername(numeutilizator);
        if (usersList.size() == 0) {
            username.requestFocus();
            username.setError("Utilizatorul nu a fost gasit!");
        } else {

            if (user != null) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String x = username.getText().toString();
                editor.putString(TEXT, x);
                editor.apply();
                startActivity( new Intent(Login.this, DupaLogin.class));

            } else {
                Toast.makeText(this, "Nume sau parola gresita!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
