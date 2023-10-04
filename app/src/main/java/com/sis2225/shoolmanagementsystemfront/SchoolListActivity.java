package com.sis2225.shoolmanagementsystemfront;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import API.APIService;
import API.SchoolData;
import API.SchoolRepository;
import Adapters.SchoolAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolListActivity extends AppCompatActivity {

    //http://10.0.2.2:8080 для эмулятора

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);

        SchoolRepository schoolRepository = SchoolRepository.getInstance();

        schoolRepository.getSchools(new Callback<List<SchoolData>>() {
            @Override
            public void onResponse(Call<List<SchoolData>> call, Response<List<SchoolData>> response) {
                if (response.isSuccessful()) {
                    List<SchoolData> schools = response.body();
                    if (!schools.isEmpty()) {
                        ListView listView = findViewById(R.id.listView);
                        SchoolAdapter adapter = new SchoolAdapter(SchoolListActivity.this, schools); // dataList - список данных для вашего списка
                        listView.setAdapter(adapter);
                    } else {
                        Toast.makeText(getApplicationContext(), "Список пуст", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<SchoolData>> call, Throwable t) {
                Log.e("BAKABAKA", "Ошибка: " + t.getMessage());
            }
        });
    }
}