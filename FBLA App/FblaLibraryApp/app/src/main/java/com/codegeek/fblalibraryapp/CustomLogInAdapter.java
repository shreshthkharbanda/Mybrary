package com.codegeek.fblalibraryapp;

/**
 * Created by shreshthkharbanda for FblaLibraryApp.
 */

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

    CustomLogInAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        LayoutInflater.from(context);
        liked = new LogInFragment().booleanLiked;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        LikeButton likeButton = view.findViewById(R.id.like_button);
//        checkedOut = (TextView) view.findViewById(R.id.checkedOutId);
        //Toast.makeText(context, "Before: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();
        liked = arrayList.get(position).get(TAG_BOOLEAN_LIKED);
        //Toast.makeText(context, "After: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();


        if (liked.equals("1")) {
            likeButton.setLiked(true);
        } else {
            likeButton.setLiked(false);
        }


        likeButton.setOnLikeListener(new OnLikeListener() {
            LogInFragment lif = new LogInFragment();

            @Override
            public void liked(final LikeButton likeButton) {
                likeButton.animate();
                liked = "1";
                updateLikes(context, arrayList.get(position).get(TAG_BOOK_ID), "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updateLikes.php");
                updateBooleanLiked(context, arrayList.get(position).get(TAG_BOOK_ID), "1");
                Toast.makeText(context, "After Liked: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();

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

            @Override
            public void unLiked(final LikeButton likeButton) {
                likeButton.animate();
                liked = "0";
                updateLikes(context, arrayList.get(position).get(TAG_BOOK_ID), "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updateLikesNegative.php");
                updateBooleanLiked(context, arrayList.get(position).get(TAG_BOOK_ID), "0");
                Toast.makeText(context, "After UnLiked: " + arrayList.get(position).get(TAG_BOOLEAN_LIKED), Toast.LENGTH_SHORT).show();

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

    public void refresh() {
        //manipulate list
        notifyDataSetChanged();
    }

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
                new LogInFragment().userFineText.setText("Your current fines are: $" + userFine);
                if (!userFine.equals("0")) {
                    new LogInFragment().userFineText.setTextColor(Color.RED);
                    new LogInFragment().userFineText.setTextSize(25);
                }


                final HashMap<String, String> persons = new HashMap<>();

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date currentTime = Calendar.getInstance().getTime();

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

    public String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder result3 = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null)
            result3.append(line);

        inputStream.close();
        return result3.toString();

    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public int getLogInCode() {
        return logInCode;
    }

    public void setLogInCode(int logInCode) {
        this.logInCode = logInCode;
    }
}
