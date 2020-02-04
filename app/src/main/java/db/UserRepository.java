package db;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class UserRepository {

    private UserDAO userDAO;

    public UserRepository (Application application) {
        UsersDB usersDB = UsersDB.getDatabaseInstance(application);
        this.userDAO = usersDB.userDAO();
    }

    public void insertUser (final String username, final String password) {
        UsersDB.databaseWriterExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.insertUser(new User (username, password));
            }
        });
    }

    public LiveData<User> validateUserLogin (String username, String password) {
        return userDAO.validateUserLogin(username, password);
    }
}
