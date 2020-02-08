package ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinal.R;

import java.util.List;

import db.User;
import db.UserRepository;
import sharedpreferences.PersistentData;
import viewmodels.CityWeatherViewModel;
import viewmodels.UserLoginViewModel;

public class LoginFragment extends Fragment {
    private Button loginButton;
    private Button createUserButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.loginButton = view.findViewById(R.id.loginButton);
        this.usernameEditText = view.findViewById(R.id.usernameEditText);
        this.passwordEditText = view.findViewById(R.id.passwordEditText);
        this.createUserButton = view.findViewById(R.id.createUserButton);
        UserLoginViewModel userLoginViewModel = new ViewModelProvider(this).get(UserLoginViewModel.class);
        userLoginViewModel.getUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (userLoginViewModel.getUser(usernameEditText.getText().toString(), passwordEditText.getText().toString())!= null) {
                            PersistentData.saveUser(usernameEditText.getText().toString(), requireContext());
                            NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_viewCityDetailsFragment);
                        } else {
                            //TODO: Mostrar dialogo error login
                            Context context = getContext();
                            CharSequence text = "Invalid Login";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                        }
                    }
                });
            }
        });
        /*this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogin()) {
                    PersistentData.saveUser(usernameEditText.getText().toString(), requireContext());
                    NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_viewCityDetailsFragment);
                } else {
                    Context context = getContext();
                    CharSequence text = "Invalid Login";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });*/
        String usernamePersistentData = PersistentData.returnedLoggedUser(requireContext());
        if (!usernamePersistentData.isEmpty()) {
            NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_viewCityDetailsFragment);
        }
        this.createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_createUserFragment);
            }
        });
        this.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!usernameEditText.getText().toString().isEmpty()) {
                    loginButton.setEnabled(true);
                }
            }
        });
        return view;
    }

    /*public boolean validateLogin () {
        boolean validLogin = false;
        UserRepository userRepository = new UserRepository(requireActivity().getApplication());
        LiveData<List<User>> attemptedLoginUser = userRepository.validateUserLogin(usernameEditText.getText().toString(), passwordEditText.getText().toString());
        if (attemptedLoginUser.getValue().get(0) != null) {
            validLogin = true;
        }
        return validLogin;
    }*/


}
