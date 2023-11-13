package com.sis2225.shoolmanagementsystemfront.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.sis2225.shoolmanagementsystemfront.R;

import java.util.List;

import API.SchoolRepository;
import API.UserData;
import Adapters.UserListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        ListView listView = findViewById(R.id.listView);


        SchoolRepository schoolRepository = SchoolRepository.getInstance();

        schoolRepository.getUsers(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if (response.isSuccessful()) {
                    List<UserData> users = response.body();
                    if (!users.isEmpty()) {
                        ListView listView = findViewById(R.id.listView);
                        UserListAdapter userAdapter = new UserListAdapter(getApplicationContext(),
                                users,getIntent().getIntExtra("schoolId",5));
                        Toast.makeText(getApplicationContext(),String.valueOf(users.get(2).getId()),Toast.LENGTH_LONG).show();
                        listView.setAdapter(userAdapter);
                    } else {
                        Toast.makeText(getApplicationContext(), "Список пуст", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Log.e("BAKABAKA", "Ошибка: " + t.getMessage());
            }
        });
    }
}
