package com.example.proiectandroid3;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity user);

    @Query("SELECT * from users where mail = :email")
    List<UserEntity> checkEmail(String email);

    @Query("SELECT * from users where username = :username")
    List<UserEntity> checkUsername(String username);

    @Query("SELECT * from users where username = :username and password = :parola")
    UserEntity searchForUser(String username, String parola);

}
