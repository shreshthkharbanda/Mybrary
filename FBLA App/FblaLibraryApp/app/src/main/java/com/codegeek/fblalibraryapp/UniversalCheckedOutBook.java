package com.codegeek.fblalibraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UniversalCheckedOutBook extends AppCompatActivity {

    TextView bookTitle;
    TextView authorFirst;
    TextView authorLast;
    TextView bookCategory;
    TextView bookCallNumber;
    TextView bookLikes;
    TextView bookDescription;
    TextView dateOut;
    TextView dateDue;
    TextView userTextView;
    Bundle bundle;
    String title;
    String firstName;
    String lastName;
    String category;
    String callNumber;
    String likes;
    String description;
    String dateOutString;
    String dateDueString;
    String userString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_checked_out_book);

        bundle = getIntent().getExtras();
//        id = bundle.getString("bookId");
        if (bundle != null) {
            title = bundle.getString("title");
        } else {
            Log.e("UCOBook", "bookTitle is null");
        }
        firstName = bundle.getString("firstName");
        lastName = bundle.getString("lastName");
        category = bundle.getString("category");
        callNumber = bundle.getString("callNumber");
        likes = bundle.getString("likes");
        description = bundle.getString("description");
        dateOutString = bundle.getString("dateCheckedOut");
        dateDueString = bundle.getString("dateCheckedDue");
        userString = bundle.getString("loggedInUser");

        bookTitle = findViewById(R.id.bookTitleUniversal);
        authorFirst = findViewById(R.id.authorFirstNameUniversal);
        authorLast = findViewById(R.id.authorLastNameUniversal);
        bookCategory = findViewById(R.id.bookCategoryUniversal);
        bookCallNumber = findViewById(R.id.bookCallNumberUniversal);
        bookLikes = findViewById(R.id.bookLikesUniversal);
        bookDescription = findViewById(R.id.bookDescription);
        dateOut = findViewById(R.id.dateCheckedOut);
        dateDue = findViewById(R.id.dateCheckedDue);
        userTextView = findViewById(R.id.loggedInUser);
        try {
            bookTitle.setText(title);
        } catch (NullPointerException npe) {
            bookTitle.setText("Null");
        }
        try {
            authorFirst.setText(firstName);
        } catch (NullPointerException npe) {
            authorFirst.setText("Null");
        }
        try {
            authorLast.setText(lastName);
        } catch (NullPointerException npe) {
            authorLast.setText("Null");
        }
        try {
            bookCategory.setText(category);
        } catch (NullPointerException npe) {
            bookCategory.setText("Null");
        }
        try {
            if (callNumber.equals("null")) {
                bookCallNumber.setText("Null");
            } else {
                bookCallNumber.setText("#" + callNumber);
            }
        } catch (NullPointerException npe) {
            bookCallNumber.setText("Null");
        }
        try {
            bookLikes.setText("+" + likes);
        } catch (NullPointerException npe) {
            bookLikes.setText("Null");
        }
        try {
            dateOut.setText(description);
        } catch (NullPointerException npe) {
            bookDescription.setText("Null");
        }
        try {
            dateOut.setText(dateOutString);
        } catch (NullPointerException npe) {
            dateOut.setText("Null");
        }
        try {
            dateDue.setText(dateDueString);
        } catch (NullPointerException npe) {
            dateDue.setText("Null");
        }
        try {
            userTextView.setText(userString);
        } catch (NullPointerException npe) {
            userTextView.setText("Null");
        }
    }
}
