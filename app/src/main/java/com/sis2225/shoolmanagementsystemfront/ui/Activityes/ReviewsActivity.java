package com.sis2225.shoolmanagementsystemfront.ui.Activityes;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.sis2225.shoolmanagementsystemfront.R;

import Adapters.ReviewAdapter;

public class ReviewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        // Define your data arrays
        String[] usernames = {"John Doe", "Alice Smith", "Bob Johnson"};
        String[] reviewContents = {"This is a great product!", "Excellent service.", "Highly recommended!"};
        String[] reviewDates = {"Posted on 24th October 2023", "Posted on 25th October 2023", "Posted on 26th October 2023"};

        // Find the ListView in your layout
        ListView listView = findViewById(R.id.listView);

        // Create an instance of your custom adapter
        ReviewAdapter customAdapter = new ReviewAdapter(this, usernames, reviewContents, reviewDates);

        // Set the adapter to the ListView
        listView.setAdapter(customAdapter);
    }
}
