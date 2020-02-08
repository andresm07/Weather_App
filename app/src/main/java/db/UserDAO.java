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

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    LiveData<List<User>> validateUserLogin (String username, String password);
}
