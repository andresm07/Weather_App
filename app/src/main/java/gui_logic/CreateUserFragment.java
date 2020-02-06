package gui_logic;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinal.R;

import db.UserRepository;

public class CreateUserFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button createUserButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);
        this.usernameEditText = view.findViewById(R.id.createUserUsernameEditText);
        this.passwordEditText = view.findViewById(R.id.createUserPasswordEditText);
        this.createUserButton = view.findViewById(R.id.createNewUserButton);
        this.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!usernameEditText.getText().toString().isEmpty()) {
                    createUserButton.setEnabled(true);
                }
            }
        });
        this.createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRepository userRepository = new UserRepository(requireActivity().getApplication());
                userRepository.insertUser(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                Bundle arguments = new Bundle();
                arguments.putString("key","");
                NavHostFragment.findNavController(CreateUserFragment.this).navigate(R.id.action_createUserFragment_to_loginFragment, arguments, new NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build());
            }
        });
        return view;
    }
}
