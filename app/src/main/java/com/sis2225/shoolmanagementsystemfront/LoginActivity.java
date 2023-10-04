package com.sis2225.shoolmanagementsystemfront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import API.SchoolRepository;
import API.StudentData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Инициализация элементов интерфейса
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        loadingProgressBar.setVisibility(View.VISIBLE);

        StudentData studentData = new StudentData();
        studentData.setUsername(username);
        studentData.setPassword(password);

        SchoolRepository.getInstance().login(studentData, new Callback<StudentData>() {
            @Override
            public void onResponse(Call<StudentData> call, Response<StudentData> response) {
                loadingProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Вход выполнен успешно", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SchoolListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Ошибка аутентификации", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StudentData> call, Throwable t) {
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("BAKABAKA", "Ошибка: " + t.getMessage());
            }
        });
    }
}
