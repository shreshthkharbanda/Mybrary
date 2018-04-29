package com.codegeek.fblalibraryapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.like.LikeButton;
import com.like.OnLikeListener;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static com.codegeek.fblalibraryapp.LogInFragment.logInAdapter;

/**
 * This class is the adapter for the myAccount list
 *
 * @Shreshth Kharbanda
 */
public class CustomLogInAdapter extends SimpleAdapter {
    private Context context;
    private ArrayList<HashMap<String, String>> arrayList;
    private static final String TAG_BOOK_ID = "bookId";
    private static final String TAG_BOOLEAN_LIKED = "booleanLiked";
    private String liked;
    private InputStream is = null;
    private String result2 = null;

    private InputStream is2 = null;
    private String result3 = null;

    private HttpPost httpPost;
    private HttpClient httpClient;
    private int logInCode;
    private String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_BOOK_NAME = "bookTitle";
    private static final String TAG_USER = "userName";
    private static final String TAG_LIBRARY_ID = "libraryId";
    private static final String TAG_OUT = "dateCheckedOut";
    private static final String TAG_DUE = "dateDue";
    private static final String TAG_CHECKED_OUT_ID = "checkedOutId";
    private static final String TAG_LIKES = "likes";
    private static final String TAG_USER_FINE = "userFines";

    /**
     * sets up the login adapter.
     *
     * @param context
     * @param data
     * @param resource
     * @param from
     * @param to
     */
    CustomLogInAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        LayoutInflater.from(context);
        liked = new LogInFragment().booleanLiked;
    }

    /**
     * loads and returns the current view for the app.
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        LikeButton likeButton = view.findViewById(R.id.like_button);
//        checkedOut = (TextView) view.findViewById(R.id.checkedOutId);
        //Toast.makeText(context, "Before: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();
        liked = arrayList.get(position).get(TAG_BOOLEAN_LIKED);
        //Toast.makeText(context, "After: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();

        // if the user has liked a book, change the like icon accordingly
        if (liked.equals("1")) {
            likeButton.setLiked(true);
        } else {
            likeButton.setLiked(false);
        }


        likeButton.setOnLikeListener(new OnLikeListener() {
            LogInFragment lif = new LogInFragment();

            // add a like and refresh the database
            @Override
            public void liked(final LikeButton likeButton) {
                likeButton.animate();
                liked = "1";
                updateLikes(context, arrayList.get(position).get(TAG_BOOK_ID), "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updateLikes.php");
                updateBooleanLiked(context, arrayList.get(position).get(TAG_BOOK_ID), "1");

                new LogInFragment().refreshListAccount.post(new Runnable() {
                    @Override
                    public void run() {
                        new LogInFragment().refreshListAccount.setEnabled(true);
                        new LogInFragment().refreshListAccount.setRefreshing(true);
                        new LogInFragment().refreshListAccount.setRefreshing(false);
                        new LogInFragment().refreshListAccount.invalidate();
                        new LogInFragment().refreshListAccount.requestLayout();
                        new LogInFragment().refreshListAccount.forceLayout();
                    }

                });


            }

            //remove a like and refresh the database
            @Override
            public void unLiked(final LikeButton likeButton) {
                likeButton.animate();
                liked = "0";
                updateLikes(context, arrayList.get(position).get(TAG_BOOK_ID), "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updateLikesNegative.php");
                updateBooleanLiked(context, arrayList.get(position).get(TAG_BOOK_ID), "0");

                new LogInFragment().refreshListAccount.post(new Runnable() {
                    @Override
                    public void run() {
                        new LogInFragment().refreshListAccount.setEnabled(true);
                        new LogInFragment().refreshListAccount.setRefreshing(true);
                        new LogInFragment().refreshListAccount.setRefreshing(false);
                        new LogInFragment().refreshListAccount.invalidate();
                        new LogInFragment().refreshListAccount.requestLayout();
                        new LogInFragment().refreshListAccount.forceLayout();
                    }
                });

            }


        });
        return view;
    }

    /**
     * updates if a book has been liked by the user.
     *
     * @param context
     * @param idValue
     * @param booleanLiked
     */
    public void updateBooleanLiked(Context context, String idValue, String booleanLiked) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("bookId", idValue));
        nameValuePairs.add(new BasicNameValuePair("booleanLiked", booleanLiked));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updateBooleanLiked.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = httpclient.execute(httppost);
            HttpEntity entity = httpResponse.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success");
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
        }

        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            is.close();
            result2 = stringBuilder.toString();
            Log.e("pass 2", "connection success");
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {
            JSONObject json_data = new JSONObject(result2);
            int code = (json_data.getInt("code"));
            if (code == 1) {
                Log.e("pass 3", "Update Successful");
            } else {
                Toast.makeText(context, "Sorry, Please Try Again", Toast.LENGTH_LONG).show();
                Log.e("fail 3", "Update NOT Successful");
            }
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }

    /**
     * refreshes the app.
     */
    public void refresh() {
        //manipulate list
        notifyDataSetChanged();
    }

    /**
     * updates the number of likes for a book when the user chooses to like a given book.
     *
     * @param context
     * @param idValue
     * @param dataUrl
     */
    public void updateLikes(Context context, String idValue, String dataUrl) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("bookId", idValue));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(dataUrl);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = httpclient.execute(httppost);
            HttpEntity entity = httpResponse.getEntity();
            is2 = entity.getContent();
            Log.e("pass 1", "connection success");
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
        }

        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(is2, "iso-8859-1"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            is2.close();
            result3 = stringBuilder.toString();
            Log.e("pass 2", "connection success");
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {
            JSONObject json_data = new JSONObject(result3);
            int code = (json_data.getInt("code"));
            if (code == 1) {
                Log.e("pass 3", "Update Successful");
            } else {
                Toast.makeText(context, "Sorry, Please Try Again", Toast.LENGTH_LONG).show();
                Log.e("fail 3", "Update NOT Successful");
            }
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }

    /**
     * retrieves the books that have been checked out by the user.
     */
    public void getBooksOut() {
        @SuppressLint("StaticFieldLeak")
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                InputStream inputStream;
                String result;
                String dataUrl = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/booksCheckedOut.php";

                try {

                    HttpClient httpclient = new DefaultHttpClient();
                    httpPost = new HttpPost(dataUrl);
                    String json1;

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.accumulate("user", new LogInFragment().mEmailView.getText().toString());

                    json1 = jsonObject.toString();
                    StringEntity se = new StringEntity(json1);
                    httpPost.setEntity(se);
                    httpPost.setHeader("Accept", "application/json");
                    httpPost.setHeader("Content-type", "application/json");

                    HttpResponse httpResponse = httpclient.execute(httpPost);
                    inputStream = httpResponse.getEntity().getContent();
                    result = convertInputStreamToString(inputStream);
                    myJSON = result;
                } catch (Exception e) {
                    Log.d("InputStream", e.getLocalizedMessage());
                }
                httpPost.setHeader("Content-type", "application/json");

                inputStream = null;
                String result2 = null;
                try {
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity entity = httpResponse.getEntity();

                    inputStream = entity.getContent();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result2 = stringBuilder.toString();
                } catch (NullPointerException | IOException npe) {
                    npe.printStackTrace();
                    logInCode = 0;
                } finally {
                    if (inputStream != null) try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logInCode = 0;
                    }
                }

                return result2;
            }

            @Override
            protected void onPostExecute(String result) {
                showBooksCheckedOut(myJSON);
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    /**
     * displays all of the checked out books under the my account tab.
     * @param jsonData recieves the jsonData for the checkedout books.
     */
    public void showBooksCheckedOut(String jsonData) {
        InputStream inputStream = null;
        String result = "";
        String dataUrl = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/booksCheckedOut.php";

        try {
            JSONObject jsonObj = new JSONObject(jsonData);

            JSONArray booksArray = jsonObj.getJSONArray(TAG_RESULTS);
            ArrayList<HashMap<String, String>> booksList = new ArrayList<>();

            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject c = booksArray.getJSONObject(i);

                // get all the book details in String format
                String bookName = c.getString(TAG_BOOK_NAME);
                String bookId = c.getString(TAG_BOOK_ID);
                String userName = c.getString(TAG_USER);
                String libraryIdDatabase = c.getString(TAG_LIBRARY_ID);
                String dateOut = c.getString(TAG_OUT);
                String dateDue = c.getString(TAG_DUE);
                String id = c.getString(TAG_CHECKED_OUT_ID);
                String likes = c.getString(TAG_LIKES);
                String booleanLiked = c.getString(TAG_BOOLEAN_LIKED);
                String userFine = c.getString(TAG_USER_FINE);
//                Toast.makeText(getContext(), "userFines: " + userFine, Toast.LENGTH_SHORT).show();
                // display the total fines for the yser
                new LogInFragment().userFineText.setText("Your current fines are: $" + userFine);
                // change font size and color if the user has any outstanding fines
                if (!userFine.equals("0")) {
                    new LogInFragment().userFineText.setTextColor(Color.RED);
                    new LogInFragment().userFineText.setTextSize(25);
                }


                final HashMap<String, String> persons = new HashMap<>();

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date currentTime = Calendar.getInstance().getTime();

                // add all the book details into persons
                persons.put(TAG_BOOK_NAME, bookName);
                persons.put(TAG_BOOK_ID, bookId);
                persons.put(TAG_USER, userName);
                persons.put(TAG_LIBRARY_ID, libraryIdDatabase);
                persons.put(TAG_OUT, dateOut);
                persons.put(TAG_DUE, dateDue);
                persons.put(TAG_CHECKED_OUT_ID, id);
                persons.put(TAG_LIKES, "+" + likes);
                persons.put(TAG_BOOLEAN_LIKED, booleanLiked);
                persons.put(TAG_USER_FINE, userFine);

                // add the book to the booklist
                booksList.add(persons);
            }
            logInAdapter = new CustomLogInAdapter(context, booksList, R.layout.layout_account_list_item,
                    new String[]{TAG_BOOK_NAME, TAG_USER, TAG_OUT, TAG_DUE, TAG_CHECKED_OUT_ID, TAG_BOOK_ID, TAG_LIKES, TAG_BOOLEAN_LIKED},
                    new int[]{R.id.bookName, R.id.userName, R.id.outDate, R.id.dueDate, R.id.checkedOutId, R.id.bookId, R.id.numberOfLikes, R.id.booleanLiked}
            );

            try {
                LogInFragment.listAccount.setAdapter(logInAdapter);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * converts the inputStream into a String and returns the String format of the
     * inputStream.
     * @param inputStream the input stream that needs to be converted into a String.
     * @return returns the String format of the inputStream.
     * @throws IOException
     */
    public String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder result3 = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
            result3.append(line);

        inputStream.close();
        return result3.toString();

    }

    /**
     * sets the httpClient to the fiven httpClient.
     * @param httpClient recives the httpClient.
     */
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * returns the login code.
     * @return returns the login code.
     */
    public int getLogInCode() {
        return logInCode;
    }

    /**
     * sets the login code to the given code.
     * @param logInCode recieves the login code.
     */
    public void setLogInCode(int logInCode) {
        this.logInCode = logInCode;
    }
}
