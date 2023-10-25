package com.sis2225.shoolmanagementsystemfront.ui.ShoolList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.sis2225.shoolmanagementsystemfront.R;

import java.util.List;

import API.SchoolData;
import API.SchoolRepository;
import Adapters.SchoolAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school_list, container, false);

        SchoolRepository schoolRepository = SchoolRepository.getInstance();

        schoolRepository.getSchools(new Callback<List<SchoolData>>() {
            @Override
            public void onResponse(Call<List<SchoolData>> call, Response<List<SchoolData>> response) {
                if (response.isSuccessful()) {
                    List<SchoolData> schools = response.body();
                    if (!schools.isEmpty()) {
                        ListView listView = view.findViewById(R.id.listView);
                        SchoolAdapter adapter = new SchoolAdapter(requireContext(), schools);
                        listView.setAdapter(adapter);
                    } else {
                        Toast.makeText(requireContext(), "Список пуст", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<SchoolData>> call, Throwable t) {
                Log.e("BAKABAKA", "Ошибка: " + t.getMessage());
            }
        });

        return view;
    }
}
