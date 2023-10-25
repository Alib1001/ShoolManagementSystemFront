package com.sis2225.shoolmanagementsystemfront.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sis2225.shoolmanagementsystemfront.R;
import com.sis2225.shoolmanagementsystemfront.databinding.ActivitySchoolBinding;
import com.sis2225.shoolmanagementsystemfront.ui.Activityes.ReviewsActivity;
import com.squareup.picasso.Picasso;

import API.SchoolRepository;

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

        Intent getDataIntent = getIntent();
        int schoolID = getDataIntent.getIntExtra("school_id",0);
        String imgUri = getDataIntent.getStringExtra("imgUri");
        String schoolName = getDataIntent.getStringExtra("school_name");
        String schoolAddr = getDataIntent.getStringExtra("school_addr");
        int rating = getDataIntent.getIntExtra("rating",0);
        String schoolReview = getDataIntent.getStringExtra("school_review");
        String schoolDescription = getDataIntent.getStringExtra("school_description");

        Picasso.get().load(imgUri).into(imageView);
        textView.setText(schoolDescription);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SchoolActivity.super.finish();
            }
        });

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewsActivity.class);
                startActivity(intent);
            }
        });


    }
}