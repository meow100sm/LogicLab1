package space.drobyshev.logiclab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import space.drobyshev.logiclab.databinding.ActivityLoginBinding;
import space.drobyshev.logiclab.databinding.ActivityLoginedBinding;

public class LoginedActivity extends AppCompatActivity {

    ActivityLoginedBinding binding;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB = new DBHelper(this);

        binding.signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signinEmail.getText().toString();
                String password = binding.signinPassword.getText().toString();

                if (email.equals("") || password.equals(""))
                    Toast.makeText(LoginedActivity.this, "Все поля обязательны для заполнения", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = DB.checkEmailPassword(email, password);
                    if (checkCredentials == true) {
                        Toast.makeText(LoginedActivity.this, "Успешный вход", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginedActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginedActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}