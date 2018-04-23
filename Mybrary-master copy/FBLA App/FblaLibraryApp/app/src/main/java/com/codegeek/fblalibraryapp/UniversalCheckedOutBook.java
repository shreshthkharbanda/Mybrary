package com.codegeek.fblalibraryapp;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
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
        String dateDueString = bundle.getString("dateDue");
        String checkedOutId = bundle.getString("checkedOutId");
        String libraryId = bundle.getString("libraryId");
        String fines = bundle.getString("fines");
        String userName = bundle.getString("userName");
        String dateOutString  = bundle.getString("dateOut");
        String title = bundle.getString("title");
        String bookId = bundle.getString("bookId");
        likes = bundle.getString("likes");
        String booleanLiked = bundle.getString("booleanLiked");

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
            bookTitle.setText("");
        }
        try {
            authorLast.setText(lastName);
        } catch (NullPointerException npe) {
            authorLast.setText("");
        }
        try {
            bookCategory.setText(category);
        } catch (NullPointerException npe) {
            bookCategory.setText("");
        }
        try {
            if (callNumber.equals("null")) {
                bookCallNumber.setText("");
            } else {
                bookCallNumber.setText("#" + callNumber);
            }
        } catch (NullPointerException npe) {
            bookCallNumber.setText("");
        }
        try {
            bookLikes.setText("+" + likes);
        } catch (NullPointerException npe) {
            bookLikes.setText("");
        }
        try {
            dateOut.setText(description);
        } catch (NullPointerException npe) {
            bookDescription.setText("");
        }
        try {
            dateOut.setText(dateOutString);
        } catch (NullPointerException npe) {
            dateOut.setText("");
        }
        try {
            dateDue.setText(dateDueString);
        } catch (NullPointerException npe) {
            dateDue.setText("");
        }
        try {
            userTextView.setText(userString);
        } catch (NullPointerException npe) {
            userTextView.setText("");
        }
    }
}
