package com.example.proiectandroid3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, password, password2, email;
    private TextView data;
    private int zi, luna, an;
    Button register;
    public static UserDataBase database;


    private DatePickerDialog.OnDateSetListener DataSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = Room.databaseBuilder(this, UserDataBase.class, "app-database").allowMainThreadQueries().build();

        username = findViewById(R.id.username);
        password = findViewById(R.id.parola);
        password2 = findViewById(R.id.parola2);
        email = findViewById(R.id.email);
        data = findViewById(R.id.data);
        register = findViewById(R.id.register);
        Calendar cal = Calendar.getInstance();
        zi = cal.get(Calendar.YEAR);
        luna = cal.get(Calendar.MONTH);
        an = cal.get(Calendar.DAY_OF_MONTH);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = zi;
                int month = luna;
                int day = an;

                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        DataSetListener,
                        year, month, day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                zi = dayOfMonth;
                luna = month;
                an = year;
                String dataa = dayOfMonth + " / " + month + " / " + year;
                data.setText(dataa);
            }
        };
    }

    public void register(View view) {
        String username_s = username.getText().toString();
        String password_s = password.getText().toString();
        String password2_s = password2.getText().toString();
        String email_s = email.getText().toString();

        if (username.getText().toString().equals("")) {
            username.requestFocus();
            username.setError("Câmp obligatoriu!");
            return;
        }

        if (password.getText().toString().equals("")) {
            password.requestFocus();
            password.setError("Câmp obligatoriu!");
            return;
        }
        if (password2.getText().toString().equals("")) {
            password2.requestFocus();
            password2.setError("Câmp obligatoriu!");
            return;
        }
        if (email.getText().toString().equals("")) {
            email.requestFocus();
            email.setError("Câmp obligatoriu!");
            return;
        }

        if (password_s.equals(password2_s)) {
            List<UserEntity> usersList = database.userDao().checkEmail(email_s);
            if (usersList.isEmpty()) {
                List<UserEntity> usersList1 = database.userDao().checkUsername(username_s);
                if (usersList1.isEmpty()) {
                    UserEntity user = new UserEntity(username_s, password_s, email_s, zi, luna, an);
                    database.userDao().insert(user);
                    Toast.makeText(this, "Utilizator adaugat cu succes!", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(this, LoginActivity.class);
                    startActivity(it);
                    finish();


                } else {
                    username.setError("Exista deja un cont cu acest username!");
                    Toast.makeText(this, "Numele de utilizator este deja folosit!", Toast.LENGTH_SHORT).show();
                }
            } else {
                email.setError("Exista un cont cu acest email!");



                email.requestFocus();
            }

        } else {
            password.requestFocus();
            password.setError("Parolele nu sunt identice!");
            password2.requestFocus();

        }
    }

    public void sendToLogin(View view) {
        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);
        finish();
    }
}
