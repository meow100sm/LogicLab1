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

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB = new DBHelper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword = binding.signupConfirm.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                    Toast.makeText(LoginActivity.this, "Все поля обязательны для заполнения", Toast.LENGTH_SHORT).show();
                else {
                    if (email.matches(emailPattern)) {
                        if (password.length() >= 6) {
                            if (password.equals(confirmPassword)) {
                                Boolean checkUserEmail = DB.checkEmail(email);

                                if (checkUserEmail == false) {
                                    Boolean insert = DB.insertData(email, password);

                                    if (insert == true) {
                                        Toast.makeText(LoginActivity.this, "Успешная регистрация", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginedActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "Такой пользователь уже существует", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Вы ввели разные пароли", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "Длина пароля должна быть не менее 6 символов", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Введите корректный email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginedActivity.class);
                startActivity(intent);
            }
        });

    }
}