package com.example.proiectandroid3;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
@Entity(tableName="users")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id_unic;

    @ColumnInfo(name = "username")
    String userName;


    @ColumnInfo(name = "password")
    String password;


    @ColumnInfo(name = "mail")
    String mail;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int day;
    private int month;
    private int year;

    public Integer getId_unic() {
        return id_unic;
    }

    public void setId_unic(Integer id_unic) {
        this.id_unic = id_unic;
    }

    public String getUserName() {
        return userName;
    }



    public String getUserId() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public UserEntity(String userName, String password, String mail, int day, int month, int year) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
