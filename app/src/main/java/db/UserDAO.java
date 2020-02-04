package db;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

public interface UserDAO {

    @Insert
    void insertUser (User user);

    @Query("SELECT * FROM user WHERE username LIKE :username AND password LIKE :password")
    LiveData<User> validateUserLogin (String username, String password);
}
