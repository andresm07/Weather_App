package gui_logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinal.R;

import db.User;
import db.UserRepository;

public class LoginFragment extends Fragment {
    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.loginButton = view.findViewById(R.id.loginButton);
        this.usernameEditText = view.findViewById(R.id.usernameEditText);
        this.passwordEditText = view.findViewById(R.id.passwordEditText);
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogin()) {
                    NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_mainScreen);
                } else {
                    //TODO: Mostrar dialogo error login
                }

            }
        });
        return view;
    }

    public boolean validateLogin () {
        boolean validLogin = false;
        UserRepository userRepository = new UserRepository(this);
        LiveData<User> attemptedLoginUser = userRepository.validateUserLogin(usernameEditText.getText().toString(), passwordEditText.getText().toString());
        if (attemptedLoginUser != null) {
            validLogin = true;
        }
        return validLogin;
    }


}
