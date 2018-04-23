package com.codegeek.fblalibraryapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UniversalBookInfo extends AppCompatActivity {

    TextView bookTitle;
    TextView authorFirst;
    TextView authorLast;
    TextView bookCategory;
    TextView bookCallNumber;
    TextView bookLikes;
    TextView bookDescription;
    Bundle bundle;
    String id;
    String title;
//    String firstName;
//    String lastName;
//    String category;
//    String callNumber;
    String likes;
    String description;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_book_info);


        bundle = getIntent().getExtras();
//        id = bundle.getString("bookId");
        if (bundle != null) {
            title = bundle.getString("title");
        } else {
            Log.e("UniversalBookInfo", "bookTitle is null");
        }
        id = bundle.getString("bookId");
        title = bundle.getString("bookTitle");
//        firstName = bundle.getString("firstName");
//        lastName = bundle.getString("lastName");
//        category = bundle.getString("category");
//        callNumber = bundle.getString("callNumber");
        likes = bundle.getString("bookLikes");
        description = bundle.getString("description");

        bookTitle = findViewById(R.id.bookTitleUniversal);
        authorFirst = findViewById(R.id.authorFirstNameUniversal);
        authorLast = findViewById(R.id.authorLastNameUniversal);
        bookCategory = findViewById(R.id.bookCategoryUniversal);
        bookCallNumber = findViewById(R.id.bookCallNumberUniversal);
        bookLikes = findViewById(R.id.bookLikesUniversal);
        bookDescription = findViewById(R.id.bookDescription);
        try {
            bookTitle.setText(title);
        } catch (NullPointerException npe) {
            bookTitle.setText("");
        }
        try {
            bookLikes.setText("+" + likes);
        } catch (NullPointerException npe) {
            bookLikes.setText("");
        }
        try {
            bookDescription.setText(description);
        } catch (NullPointerException npe) {
            bookDescription.setText("");
        }
    }
}