package com.example.proiectandroid3;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDataBase extends RoomDatabase {

    private static final String dbName="user";
    private static UserDataBase userDatabase;

    public static synchronized UserDataBase getUserDatabase(Context context) {
        if(userDatabase==null)
        {
            userDatabase= Room.databaseBuilder(context,UserDataBase.class,dbName).fallbackToDestructiveMigration().build();
        }
        return userDatabase;
    }
    public abstract UserDao userDao();

}
