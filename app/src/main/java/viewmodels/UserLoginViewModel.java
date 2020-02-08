package viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import db.User;
import db.UserRepository;

public class UserLoginViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserLoginViewModel (Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<List<User>> getUser (String username, String password) {
        return userRepository.validateUserLogin(username, password);
    }

    public LiveData<List<User>> getUsers () {
        return userRepository.getUsers();
    }
}
