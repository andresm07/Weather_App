package db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser (User user);

    @Query("SELECT * FROM user WHERE username = :username AND password = :password LIMIT 1")
    LiveData<List<User>> validateUserLogin (String username, String password);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getUsers ();
}
