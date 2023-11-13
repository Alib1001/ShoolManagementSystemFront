package com.sis2225.shoolmanagementsystemfront.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sis2225.shoolmanagementsystemfront.R;
import com.sis2225.shoolmanagementsystemfront.databinding.ActivitySchoolBinding;
import com.sis2225.shoolmanagementsystemfront.ui.Activities.UserListActivity;
import com.squareup.picasso.Picasso;

import API.SchoolData;

public class SchoolActivity extends AppCompatActivity {

    private ActivitySchoolBinding binding;
    private NestedScrollView nestedScrollView;
    private TextView textView;
    private ImageButton backBtn;
    private FloatingActionButton reviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySchoolBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_school);

        nestedScrollView = findViewById(R.id.nestedScrollView);
        ImageView imageView = findViewById(R.id.schoolImage);
        textView = findViewById(R.id.schoolDescriptionTV);
        backBtn = findViewById(R.id.backBtn);
        reviewBtn = findViewById(R.id.reviewBtn);

        SchoolData schoolData = (SchoolData) getIntent().getSerializableExtra("schoolData");
        String shoolImgUri = getIntent().getStringExtra("shoolImgUri");
        Picasso.get().load(shoolImgUri).into(imageView);
        textView.setText(schoolData.getDescription());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchoolActivity.super.finish();
            }
        });

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
                intent.putExtra("schoolData", schoolData);
                intent.putExtra("schoolId",schoolData.getId());
                startActivity(intent);
            }
        });


    }
}