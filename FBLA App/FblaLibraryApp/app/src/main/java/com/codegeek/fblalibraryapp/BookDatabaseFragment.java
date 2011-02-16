package com.codegeek.fblalibraryapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

@SuppressWarnings("ConstantConditions")
public class BookDatabaseFragment extends Fragment {

    String myJSON;
    public String TAG_RESULTS = "result";
    public String TAG_BOOK_ID = "bookId";
    public String TAG_TITLE = "bookTitle";
    public String TAG_AUTHOR_LAST = "authorLastName";
    public String TAG_CATEGORY = "bookCategory";
    public String TAG_CALL_NUMBER = "bookCallNumber";
    public String TAG_STATUS = "bookStatus";
    public String TAG_LIKES = "numberOfLikes";
    public String TAG_DESCRIPTION = "bookDescription";
    JSONArray peoples;
    ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
    View rootView;
    FloatingActionButton reserveBook;
    HashMap<String, String> books;
    String id;
    String title;
    String authorLast;
    String category;
    String callNumber;
    String likes;
    String description;
    SwipeRefreshLayout refreshList;
    InputStream inputStream = null;
    String result2;
    String url;
    String bookIdNumber;
    String result = null;
    ListView listView;
    String bookIdCheckout = "";
    Barcode barcodeResult;
    TextInputEditText mEmailView;
    HttpResponse httpResponse;
    HttpClient httpClient;
    HttpPost httpPost;
    HttpEntity entity;
    InputStream is;
    String result3;
    String line;

    android.app.ActionBar actionBar;
    //    EditText userEmailEdit;
//    String userEmail = new LogInFragment().mEmailView.getText().toString();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_book_database, container, false);
        reserveBook = rootView.findViewById(R.id.reserveBook);
//        TODO: add logic
//        setHasOptionsMenu(true);

        listView = rootView.findViewById(R.id.listView);

        View logInView = inflater.inflate(R.layout.fragment_log_in, container, false);
        mEmailView = logInView.findViewById(R.id.logInEmailEdit);

        reserveBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(getContext());
                }
                builder.setTitle("Checkout Book")
                        .setMessage("How would you like to checkout this book?")
                        .setPositiveButton("Scan Book", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // scan book
                                startScan();
                            }
                        })
                        .setNegativeButton("Manually enter ID", new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, int which) {
                                // create dialog to checkout book
                                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                                final LayoutInflater inflater = getActivity().getLayoutInflater();
                                @SuppressLint("InflateParams") final View dialogView = inflater.inflate(R.layout.custom_dialog_checkout, null);
                                dialogBuilder.setView(dialogView);

                                final EditText bookIdEdit = dialogView.findViewById(R.id.bookIdCheckoutEdit);

                                dialogBuilder.setTitle("Checkout Book");
                                dialogBuilder.setMessage("Enter Book ID below");
                                dialogBuilder.setPositiveButton("Checkout Book", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        bookIdCheckout = bookIdEdit.getText().toString();
                                        scanToBook(bookIdCheckout);
                                        if (LogInFragment.sendLoggedIn()) {
                                            String checkoutResult = checkoutBook(bookIdNumber, LogInFragment.sendUserName(), bookList.get(Integer.parseInt(bookIdNumber) - 1).get(TAG_TITLE), LogInFragment.sendUserEmail(), LogInFragment.sendLibraryId(), authorLast, category, callNumber, likes, description);
//                                            Toast.makeText(getContext(), checkoutResult, Toast.LENGTH_SHORT).show();
                                            if (checkoutResult.trim().equalsIgnoreCase("Book already checked out")) {
                                                Toast.makeText(getContext(), "The book you are trying to checkout is already checked out!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(getContext(), "Book has successfully been checked out!", Toast.LENGTH_SHORT).show();
                                            }
                                        } else {
                                            Toast.makeText(getContext(), "Please login before checking out a book!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface bookIdDialog, int whichButton) {
                                        bookIdDialog.cancel();
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alertDialog = dialogBuilder.create();
                                alertDialog.show();
                            }
                        })
                        .setIcon(R.drawable.mybrary_logo)
                        .show();
            }
        });
        refreshList = rootView.findViewById(R.id.refreshListDatabase);
        refreshList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshList.setRefreshing(false);
                    }
                }, 5000);
                getAllBooks();
            }
        });
        refreshList.setColorSchemeColors(
                Color.RED,
                Color.GREEN,
                Color.CYAN,
                Color.YELLOW,
                Color.BLACK,
                Color.MAGENTA
        );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Checkout \"" + title + "\" on Mybrary!");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        getAllBooks();
        return rootView;
    }

    protected void showBookList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                id = c.getString(TAG_BOOK_ID);
                title = c.getString(TAG_TITLE);
                authorLast = c.getString(TAG_AUTHOR_LAST);
                category = c.getString(TAG_CATEGORY);
                callNumber = c.getString(TAG_CALL_NUMBER);
                likes = c.getString(TAG_LIKES);

                books = new HashMap<>();
                books.put(TAG_BOOK_ID, id);
                books.put(TAG_TITLE, capitalLowercase(title));
                books.put(TAG_AUTHOR_LAST, authorLast);
                books.put(TAG_CATEGORY, category);
                books.put(TAG_CALL_NUMBER, "#" + callNumber);
                books.put(TAG_LIKES, "+" + likes);

                bookList.add(books);
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        if (getActivity() != null) {
            ListAdapter adapter = new SimpleAdapter(
                    getActivity(), bookList, R.layout.book_database_title,
                    new String[]{TAG_TITLE, TAG_AUTHOR_LAST, TAG_CATEGORY, TAG_CALL_NUMBER, TAG_BOOK_ID, TAG_LIKES},
                    new int[]{R.id.bookTitle, R.id.authorLastName, R.id.bookCategory, R.id.bookCallNumber, R.id.bookId, R.id.numberOfLikes}
            );
            listView.setAdapter(adapter);
        }
    }

    public void getAllBooks() {
        @SuppressLint("StaticFieldLeak")
        class GetAllBooksClass extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpClient = new DefaultHttpClient(new BasicHttpParams());
                HttpPost httppost = new HttpPost("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/getAllBooks.php");
                httppost.setHeader("BookDatabase Books", "BookDatabase JSON");

                try {
                    HttpResponse httpResonse = httpClient.execute(httppost);
                    HttpEntity httpEntity = httpResonse.getEntity();

                    inputStream = httpEntity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result = stringBuilder.toString();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Couldn't retrieve information from database", Toast.LENGTH_SHORT).show();
                } finally {
                    if (inputStream != null) try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showBookList();
            }
        }
        GetAllBooksClass g = new GetAllBooksClass();
        g.execute();
    }

    public void scanToBook(String scanResult) {
        inputStream = null;
        result2 = "";
        url = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/barcodeScan.php";
        bookIdNumber = scanResult;

        try {

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);
            String json1;

            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("bookId", bookIdNumber);

            json1 = jsonObject.toString();

            StringEntity stringEntity = new StringEntity(json1);

            httpPost.setEntity(stringEntity);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpClient.execute(httpPost);

            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null) {
                result2 = new LogInFragment().convertInputStreamToString(inputStream);
                myJSON = result2;
            } else {
                result2 = "Failed";
            }
        } catch (Exception e) {
            Log.d("BookDatabaseFragment", e.getLocalizedMessage());
        }
        JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                bookIdNumber = c.getString(TAG_BOOK_ID);
                title = c.getString(TAG_TITLE);
                authorLast = c.getString(TAG_AUTHOR_LAST);
                category = c.getString(TAG_CATEGORY);
                callNumber = c.getString(TAG_CALL_NUMBER);
                likes = c.getString(TAG_LIKES);
                description = c.getString(TAG_DESCRIPTION);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String bookIdCheckout = intent.getStringExtra("SCAN_RESULT");
                scanToBook(bookIdCheckout);
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast.makeText(getContext(), "cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startScan() {
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(getActivity())
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        Toast.makeText(getContext(), barcode.rawValue, Toast.LENGTH_SHORT).show();
                        barcodeResult = barcode;
                        scanToBook(barcodeResult.rawValue);
                        if (LogInFragment.sendLoggedIn()) {
                            description = getString(R.string.book_description);

                            Toast.makeText(getContext(), "Book ID: " + bookIdNumber +
                                    "\n" + "Book Title: " + bookList.get(Integer.parseInt(bookIdNumber) - 1).get(TAG_TITLE) +
                                    "\n" + "User E-mail: " + LogInFragment.sendUserEmail() +
                                    "\n" + "Library ID: " + LogInFragment.sendLibraryId() +
                                    "\n" + "Author Last Name: " + authorLast +
                                    "\n" + "Book Category: " + category +
                                    "\n" + "Book Call Number: " + callNumber +
                                    "\n" + "Book Likes: " + likes +
                                    "\n" + "Book Description: " + description, Toast.LENGTH_LONG).show();
                            checkoutBook(bookIdNumber, LogInFragment.sendUserName(), bookList.get(Integer.parseInt(bookIdNumber) - 1).get(TAG_TITLE), LogInFragment.sendUserEmail(), LogInFragment.sendLibraryId(), authorLast, category, callNumber, likes, description);
                        } else {
                            Toast.makeText(getContext(), "Please login before checking out a book!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .build();
        materialBarcodeScanner.startScan();
    }

    public String capitalLowercase(String string) {
        String letter = string.substring(0, 1);
        String uppercaseLetter = letter.toUpperCase();

        return uppercaseLetter + string.substring(1).toLowerCase();
    }

    private String checkoutBook(final String bookId, final String userName, final String bookTitle, final String email, final String libraryId, final String author, final String category, final String callNum, final String likes, final String description) {
        List<NameValuePair> signUpPair = new ArrayList<>();
        signUpPair.add(new BasicNameValuePair("bookId", bookId));
        signUpPair.add(new BasicNameValuePair("userName", userName));
        signUpPair.add(new BasicNameValuePair("bookTitle", bookTitle));
        signUpPair.add(new BasicNameValuePair("userEmail", email));
        signUpPair.add(new BasicNameValuePair("libraryId", libraryId));
        signUpPair.add(new BasicNameValuePair("authorLast", author));
        signUpPair.add(new BasicNameValuePair("bookCategory", category));
        signUpPair.add(new BasicNameValuePair("bookCallNumber", callNum));
        signUpPair.add(new BasicNameValuePair("bookLikes", likes));
        signUpPair.add(new BasicNameValuePair("bookDescription", description));

        try {
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/checkoutBook.php");
            httpPost.setEntity(new UrlEncodedFormEntity(signUpPair));
            httpResponse = httpClient.execute(httpPost);
            entity = httpResponse.getEntity();
            is = entity.getContent();

            try {
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result3 = sb.toString();
                Log.e("pass 2", "connection success ");
                Log.v("Result3------", "result should be in method:- " + result3);

            } catch (Exception e) {
                Log.e("Fail 2", e.toString());
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result3;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.account_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // profile settings icon clicked
            case R.id.reportBug:
                Toast.makeText(getContext(), "Report Bug", Toast.LENGTH_SHORT)
                        .show();
                break;
            // change password option clicked under settings
            case R.id.changePassword:
                Toast.makeText(getContext(), "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }

    public static String[] convertToString(Object[] objectArray) {
        String[] strArray = new String[objectArray.length];
        for (int i = 0; i < objectArray.length; i++) {
            strArray[i] = (String) objectArray[i];
        }
        return strArray;
    }
}