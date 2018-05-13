package com.codegeek.fblalibraryapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.like.LikeButton;

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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;
import static android.provider.ContactsContract.Directory.PACKAGE_NAME;

/**
 * This class exists with 3 main functions. The first main function for this class is the login.
 * That is done by retreiving data from the server side and parsing the json that is returned to the website.
 * In the php code, simultaneously, a query is written to check if the user exists with the given username and password.
 * The second main function for this class is sign up where the layout changes and is made visible as well as al the other layouts are made invisible.
 * The third main function for this class is my account which is, once you log in, you can see your fines, books checked out, share your books checked out, change your password.
 * <p>
 * Bugs: - Signing up would pass empty data to the database.
 * - Logging in would always say invalid credentials
 *
 * @author (your name)
 */

@SuppressWarnings("ConstantConditions")
@SuppressLint("StaticFieldLeak")
public class LogInFragment extends Fragment implements SearchView.OnCloseListener, SearchView.OnQueryTextListener {

    //  Defining and declaring variables
    private Menu accountMenu;
    static TextInputEditText mEmailView;
    TextInputEditText mPasswordView;
    View logInView;
    View listItemView;
    View singleBookInfo;
    public Button logInButton;
    public static ListView listAccount;
    String user;
    String password;
    String myJSON;
    TextView userFineText;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_BOOK_NAME = "bookTitle";
    private static final String TAG_USER_FIRST = "userFirstName";
    private static final String TAG_USER_LAST = "userLastName";
    private static final String TAG_LIBRARY_ID = "libraryId";
    private static final String TAG_OUT = "dateCheckedOut";
    private static final String TAG_DUE = "dateDue";
    private static final String TAG_CHECKED_OUT_ID = "checkedOutId";
    private static final String TAG_LIKES = "likes";
    private static final String TAG_BOOLEAN_LIKED = "booleanLiked";
    private static final String TAG_USER_FINE = "userFines";

    JSONArray booksArray;
    ArrayList<HashMap<String, String>> booksList = new ArrayList<>();
    InputStream inputStream;
    String result;
    String dataUrl;
    Button logOutButton;
    RelativeLayout logInLayout;
    RelativeLayout accountLayout;
    String bookName;
    String loggedInUser;
    String dateOut;
    String dateDue;
    String bookId;
    String accountId;
    static String userName;
    static String lastName;
    static String libraryIdDatabase;
    String userFine;

    LikeButton likeButton;
    String booleanLiked;
    InputStream is = null;
    String result2 = null;
    String line = null;
    int code;
    TextView checkedOut;
    public static Boolean loggedIn = false;
    public static SwipeRefreshLayout refreshListAccount;

    ArrayList<String> stringArray = new ArrayList<>();
    SharedPreferences.Editor passwordEditor;
    SharedPreferences.Editor loggedInEditor;
    public static CustomLogInAdapter logInAdapter;
    public static String userEmail;
    String userPass;
    HttpPost httpPost;
    HttpClient httpClient;
    int logInCode;
    Boolean validCredentials;
    ScrollView signUpLayout;
    Button signUp;
    EditText libraryId;
    EditText signUpFirst;
    EditText signUpLast;
    EditText signUpEmail;
    EditText signUpPhone;
    EditText signUpPassword;
    EditText signUpPassword2;
    TextView alreadyMember;
    TextView createAccount;

    TextView bookIdText;
    TextView bookTitleText;
    TextView authorLastText;
    TextView bookCategoryText;
    TextView bookCallNumberText;
    TextView bookLikesText;
    TextView bookDescriptionText;
    TextView dateOutText;
    TextView dateDueText;
    TextView loggedInUserText;

    CheckBox saveUsername;
    CheckBox savePassword;
    CheckBox stayLoggedIn;
    SharedPreferences usernamePreferences;
    SharedPreferences.Editor usernameEditor;
    SharedPreferences passwordPreferences;
    SharedPreferences loggedInPrefs;
    public String savedUsername;
    public String savedPassword;
    public String loggedInString;
    ProgressDialog pdLoading;

    public String TAG_BOOK_ID = "bookId";
    public String TAG_TITLE = "bookTitle";
    //    public String TAG_AUTHOR_FIRST = "authorFirstName";
    public String TAG_AUTHOR_LAST = "authorLastName";
    public String TAG_CATEGORY = "bookCategory";
    public String TAG_CALL_NUMBER = "bookCallNumber";
    public String TAG_DESCRIPTION = "bookDescription";

    String id;
    String title;
    String authorLast;
    String category;
    String callNumber;
    String likes;
    ArrayList<HashMap<String, String>> bookList = new ArrayList<>();
    HashMap<String, String> books;
    private Boolean active = false;
    TextView forgotPassword;
    String forgotPasswordEmail = "";
    final String mybraryEmail = "mybraryHelp@gmail.com";
    final String mybraryPassword = "MybraryPassword";
    StringBuilder newPassword;
    String updatePasswordResult;
    EditText newPasswordEdit;
    EditText oldPasswordEdit;
    EditText confirmPasswordEdit;
    View changePassView;
    View reportBugView;
    EditText explainBug;
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    Button changePass;
    Boolean changePassValid = false;
    AlertDialog reportBug;
    SearchView sv;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

    //  Initializing variables and assigning variables to the UI components
        logInView = inflater.inflate(R.layout.fragment_log_in, container, false);
        mEmailView = logInView.findViewById(R.id.logInEmailEdit);
        mPasswordView = logInView.findViewById(R.id.logInPasswordEdit);
        userFineText = logInView.findViewById(R.id.userFineText);
        listAccount = logInView.findViewById(R.id.accountListView);
        logInButton = logInView.findViewById(R.id.email_sign_in_button);
        logInLayout = logInView.findViewById(R.id.linearLayoutLogIn);
        accountLayout = logInView.findViewById(R.id.accountLayoutLogIn);
        logOutButton = logInView.findViewById(R.id.logOutButton);
        refreshListAccount = logInView.findViewById(R.id.refreshListAccount);

        signUpLayout = logInView.findViewById(R.id.signUpLayout);
        signUp = logInView.findViewById(R.id.signUpButton);
        libraryId = logInView.findViewById(R.id.libraryIdSignup);
        signUpFirst = logInView.findViewById(R.id.signUpFirst);
        signUpLast = logInView.findViewById(R.id.signUpLast);
        signUpEmail = logInView.findViewById(R.id.signUpEmail);
        signUpPhone = logInView.findViewById(R.id.signUpPhone);
        signUpPassword = logInView.findViewById(R.id.signUpPassword);
        signUpPassword2 = logInView.findViewById(R.id.signUpPassword2);
        alreadyMember = logInView.findViewById(R.id.alreadyMember);
        createAccount = logInView.findViewById(R.id.createAccountText);
        saveUsername = logInView.findViewById(R.id.saveUsername);
        savePassword = logInView.findViewById(R.id.savePassword);
        stayLoggedIn = logInView.findViewById(R.id.stayLoggedIn);
        forgotPassword = logInView.findViewById(R.id.forgotPassword);

        changePassView = inflater.inflate(R.layout.change_password_dialog_layout, container, false);
        oldPasswordEdit = changePassView.findViewById(R.id.oldPassword);
        newPasswordEdit = changePassView.findViewById(R.id.newPassword);
        confirmPasswordEdit = changePassView.findViewById(R.id.confirmPassword);

        reportBugView = inflater.inflate(R.layout.report_bug_layout, container, false);
        explainBug = reportBugView.findViewById(R.id.explainBug);

        pdLoading = new ProgressDialog(getContext());

        if (savedUsername == null) {
            saveUsername.setChecked(false);
        } else {
            saveUsername.setChecked(true);
        }
        if (savedPassword == null) {
            savePassword.setChecked(false);
        } else {
            savePassword.setChecked(true);
        }

        listItemView = inflater.inflate(R.layout.layout_account_list_item, container, false);
        likeButton = listItemView.findViewById(R.id.like_button);
        checkedOut = listItemView.findViewById(R.id.checkedOutId);
        bookIdText = listItemView.findViewById(R.id.bookIdAccount);
        bookTitleText = listItemView.findViewById(R.id.bookName);
        bookCallNumberText = listItemView.findViewById(R.id.bookCallNumber);
        bookLikesText = listItemView.findViewById(R.id.numberOfLikes);
        dateOutText = listItemView.findViewById(R.id.outDate);
        dateDueText = listItemView.findViewById(R.id.dueDate);
        loggedInUserText = listItemView.findViewById(R.id.userName);

        singleBookInfo = inflater.inflate(R.layout.activity_universal_book_info, container, false);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        //  Validating sign up information entered and if it is all valid, register the user into the database.

                if (libraryId.getText().toString().length() == 6 && (signUpPassword.getText().toString().equals(signUpPassword2.getText().toString()) && !(signUpFirst == null)
                        && !(signUpLast == null) && !(signUpEmail == null) && !(signUpPassword == null)
                        && !(signUpPassword2 == null) && !(signUpPhone == null)) &&
                        (Patterns.EMAIL_ADDRESS.matcher(signUpEmail.getText().toString()).matches()) &&
                        (Patterns.PHONE.matcher(signUpPhone.getText().toString()).matches())) {

                    registerUser(libraryId.getText().toString(), signUpFirst.getText().toString(), signUpLast.getText().toString(),
                            signUpEmail.getText().toString(), signUpPassword.getText().toString(), signUpPhone.getText().toString(),
                            "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/signUpLibrary.php");
                    Log.v("dataSignUp", libraryId.getText().toString() + " " + signUpFirst.getText().toString() + " " + signUpLast.getText().toString() + " " +
                            signUpEmail.getText().toString() + " " + signUpPassword.getText().toString() + " " + signUpPhone.getText().toString());

                    logInLayout.setVisibility(View.VISIBLE);
                    accountLayout.setVisibility(View.GONE);
                    logOutButton.setVisibility(View.GONE);
                    signUpLayout.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Account Successfully Created!", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        if (result.equalsIgnoreCase("Failed") || result.equalsIgnoreCase("failure")) {
                            Toast.makeText(getContext(), "That email already exists!", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception ex) {
                        if (libraryId.getText().toString().equals("") || signUpPassword.getText().toString().equals("") || signUpPassword2.getText().toString().equals("") ||
                                signUpFirst.getText().toString().equals("") || signUpLast.getText().toString().equals("") || signUpEmail.getText().toString().equals("") ||
                                signUpPassword.getText().toString().equals("") || signUpPassword2.getText().toString().equals("") ||
                                signUpPhone.getText().toString().equals("")) {
                            Toast.makeText(getContext(), "Please fill out all forms!", Toast.LENGTH_LONG).show();
                        } else if (!(signUpPassword.getText().toString().equals(signUpPassword2.getText().toString()))) {
                            Toast.makeText(getContext(), "Please make sure both the passwords match!", Toast.LENGTH_LONG).show();
                        } else if (!(Patterns.EMAIL_ADDRESS.matcher(signUpEmail.getText().toString()).matches())) {
                            Toast.makeText(getContext(), "Please make sure the email address is valid!", Toast.LENGTH_LONG).show();
                        } else if (!(android.util.Patterns.PHONE.matcher(signUpPhone.getText().toString()).matches())) {
                            Toast.makeText(getContext(), "Please make sure the phone number is valid!", Toast.LENGTH_LONG).show();
                        } else if (!(libraryId.getText().toString().length() == 6)) {
                            Toast.makeText(getContext(), "Please enter a valid library ID!", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });

        // Change screen to sign up screen when user clicks the text "No Account Yet? Create One"
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInLayout.setVisibility(View.GONE);
                accountLayout.setVisibility(View.GONE);
                signUpLayout.setVisibility(View.VISIBLE);
            }
        });

        // Detects user's action of pulling to refresh the list
        refreshListAccount.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshListAccount.setRefreshing(false);
                        checkCredentials(mEmailView.getText().toString(), mPasswordView.getText().toString());
                        getBooksOut();
                        logInLayout.setVisibility(View.GONE);
                        accountLayout.setVisibility(View.VISIBLE);
                    }
                }, 3000);
                booksList = new ArrayList<>();

                logInLayout.setVisibility(View.GONE);
                accountLayout.setVisibility(View.VISIBLE);
            }
        });

        refreshListAccount.setColorSchemeColors(
                Color.RED,
                Color.GREEN,
                Color.CYAN,
                Color.BLACK
        );
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//      Log user out when user clicks the log out button
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
                loggedInPrefs = getContext().getSharedPreferences("StayLoggedIn", MODE_PRIVATE);
                loggedInEditor = loggedInPrefs.edit();
                loggedInEditor.putString("stayLoggedIn", "no");
                loggedInEditor.apply();
                setHasOptionsMenu(true);
                loggedIn = false;
                logInCode = 0;
            }
        });

//      Detect save username checkbox's boolean of checked changed
        saveUsername.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//              If checkbox is checked, save username to to cache
                if (b) {
                    usernamePreferences = getActivity().getSharedPreferences("Username", MODE_PRIVATE);
                    usernameEditor = usernamePreferences.edit();
                    usernameEditor.putString("username", mEmailView.getText().toString());
                    usernameEditor.apply();
                } else {
                    usernameEditor.clear().apply();
                }
            }
        });

//      Detect save password checkbox's boolean of checked changed
        savePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//              If checkbox is checked, save password to to cache
                if (b) {
                    passwordPreferences = getContext().getSharedPreferences("Password", MODE_PRIVATE);
                    passwordEditor = passwordPreferences.edit();
                    passwordEditor.putString("password", mPasswordView.getText().toString());
                    passwordEditor.apply();
                } else {
                    passwordEditor.clear().apply();
                }
            }
        });
//      Detect stay logged in checkbox's boolean of checked changed
        stayLoggedIn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//              If checkbox is checked, save both username and password to cache and add value to make sure that the user is logged in as soon as the app opens up
                if (b) {
                    loggedInPrefs = getContext().getSharedPreferences("StayLoggedIn", MODE_PRIVATE);
                    loggedInEditor = loggedInPrefs.edit();
                    loggedInEditor.putString("stayLoggedIn", "yes");
                    loggedInEditor.apply();

                    passwordPreferences = getContext().getSharedPreferences("Password", MODE_PRIVATE);
                    passwordEditor = passwordPreferences.edit();
                    passwordEditor.putString("password", mPasswordView.getText().toString());
                    passwordEditor.apply();

                    usernamePreferences = getActivity().getSharedPreferences("Username", MODE_PRIVATE);
                    usernameEditor = usernamePreferences.edit();
                    usernameEditor.putString("username", mEmailView.getText().toString());
                    usernameEditor.apply();
                } else {
                    passwordEditor.clear().apply();
                    usernameEditor.clear().apply();
                    loggedInEditor.putString("stayLoggedIn", "no");
                }
            }
        });

//      Detects button click on the log in button
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              If email and password is not empty then check credentials or else open sign up screen
                userEmail = mEmailView.getText().toString();
                userPass = mPasswordView.getText().toString();

                if (!Objects.equals(mEmailView.getText().toString(), "") && !Objects.equals(mPasswordView.getText().toString(), "")) {
                    pdLoading.setMessage("\tLoading...");
                    pdLoading.setCancelable(false);
                    pdLoading.show();
                    checkCredentials(mEmailView.getText().toString(), mPasswordView.getText().toString());
                } else {
                    logInLayout.setVisibility(View.GONE);
                    accountLayout.setVisibility(View.GONE);
                    accountLayout.setVisibility(View.GONE);
                    signUpLayout.setVisibility(View.VISIBLE);
                }

            }
        });

//      Detects click on the text that says "Already a member? Login"
        alreadyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Makes the login screen visible and the other screens invisible and gone
                logInLayout.setVisibility(View.VISIBLE);
                signUpLayout.setVisibility(View.GONE);
                accountLayout.setVisibility(View.GONE);
            }
        });

//      Detects click on the text that says "Forgot Password?"
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create dialog to checkout book
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.custom_dialog_checkout, null);
                dialogBuilder.setView(dialogView);

                // get user's email to send reset password email
                final TextInputEditText forgotPasswordEdit = dialogView.findViewById(R.id.bookIdCheckoutEdit);
                forgotPasswordEdit.setHint("Email");
                forgotPasswordEdit.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

                dialogBuilder.setTitle("Reset Password");
                dialogBuilder.setMessage("Enter your email below");
                dialogBuilder.setPositiveButton("Reset Password", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        forgotPasswordEmail = forgotPasswordEdit.getText().toString();

//                      generate random password in between 3 characters and 10 characters with the characters given in charsForPass
//                      There are extra dashes for an equal probability
                        String charsForPass = "12345678901234567890------------abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        newPassword = new StringBuilder();
                        Random random = new Random();
                        int randomLen = 7 + random.nextInt(3);
                        for (int i = 0; i < randomLen; i++) {
                            char singleChar = charsForPass.charAt(random.nextInt(charsForPass.length() - 1));
                            newPassword.append(singleChar);
                        }

//                      Sends E-mail using the GMailSender Class and the JSSEProvider Class
                        try {
                            GMailSender sender = new GMailSender(mybraryEmail, mybraryPassword);
                            sender.sendMail("Mybrary -- Reset Password",
                                    "Your new password is: \n\"" + newPassword + "\". \n\t" +
                                            "To change your password, please log into your account on our app and then click the change password which appears after clicking the 3 dots in the menu bar of our app. Please reply to this email for any questions.",
                                    mybraryEmail,
                                    forgotPasswordEmail);
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                        }
//                      Updates the password in the database with the right email and the random password
                        updatePassword(forgotPasswordEmail, newPassword.toString());
                        Toast.makeText(getContext(), "An email has been sent to you with your new password. Please check your e-mail.", Toast.LENGTH_LONG).show();
                    }
                });
                // Cancel resetting password
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface forgotPasswordDialog, int whichButton) {
//                      Cancels the dialogbox and closes it
                        forgotPasswordDialog.cancel();
                    }
                })
//                      Sets properties for the dialogbox
                        .setIcon(R.drawable.mybrary_logo)
                        .setCancelable(false)
                        .show();
            }
        });

//      Detects click on any item in the my account list of books checked out
        listAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//              Gets details of the book from the json encoded data
                String item = listAccount.getItemAtPosition(i).toString().replace("{", "").replace("}", "");
                Log.v("Login", item);
                String[] bookDetailsArray = item.split(",");

                String dateDue = bookDetailsArray[0];
                String title = bookDetailsArray[6];
                String likes = bookDetailsArray[8];

//              Uses the default, built-in intent for sharing with social media
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Checkout \"" + title + "\" on Mybrary! I checked this book out and would definitely recommend this great book! It has " + likes + " likes! I should return the book by " + dateDue + " if you would like to check it out.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        return logInView;
    }

    /*
    * This method is used to retreive the books that are checked out from the MySQL database and is done through a php code hosted on AWS
    * and this helps make it secure since only our IP addresses can access the php code and the website.
    * Author: Shreshth Kharbanda
    */
    public void getBooksOut() {
//      Suppress StaticFieldLeaks
        @SuppressLint("StaticFieldLeak")

//      AsyncTask Class of Type String, Void, String

        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

//              Defining local variables and initializing the url of the php code
                InputStream inputStream;
                String result;
                String dataUrl = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/booksCheckedOut.php";

//              Uses HttpPost to send the email over to the php code as an input to get the books checked out
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    httpPost = new HttpPost(dataUrl);
                    String json1;

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.accumulate("user", mEmailView.getText().toString());

                    json1 = jsonObject.toString();
                    StringEntity se = new StringEntity(json1);
                    httpPost.setEntity(se);
                    httpPost.setHeader("Accept", "application/json");
                    httpPost.setHeader("Content-type", "application/json");

//                  Retrieves the result and what is returned from the php code and stores the string in MyJSON
                    HttpResponse httpResponse = httpclient.execute(httpPost);
                    inputStream = httpResponse.getEntity().getContent();
                    result = convertInputStreamToString(inputStream);
                    myJSON = result;
                } catch (Exception e) {
//                  Exception and logged in debug portion of logcat
                    Log.d("InputStream", e.getLocalizedMessage());
                }
//              Set header for the HttpPost process
                httpPost.setHeader("Content-type", "application/json");

                inputStream = null;
                String result2 = null;

//              Retrieves the data from the php code to get all the information about the books checked out by the user
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
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                    logInCode = 0;
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "Input-Output Exception", Toast.LENGTH_LONG).show();
                        }
                    });
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

            //  Calls the method showBooksCheckedOut and gives an input of the JSON data
            @Override
            protected void onPostExecute(String result) {
                showBooksCheckedOut(myJSON);
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    /**
     * This method shows the data gotten and populates the listview with the data
     *
     * @param jsonData
     * @return
     */
    public void showBooksCheckedOut(String jsonData) {
        user = userEmail;
        inputStream = null;
        result = "";
        try {
            JSONObject jsonObj = new JSONObject(jsonData);

            booksArray = jsonObj.getJSONArray(TAG_RESULTS);
            booksList = new ArrayList<>();

//          for loop to get the string values from the json object
            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject c = booksArray.getJSONObject(i);

                bookName = c.getString(TAG_BOOK_NAME);
                bookId = c.getString(TAG_BOOK_ID);
                userName = c.getString(TAG_USER_FIRST);
                lastName = c.getString(TAG_USER_LAST);
                libraryIdDatabase = c.getString(TAG_LIBRARY_ID);
                dateOut = c.getString(TAG_OUT);
                dateDue = c.getString(TAG_DUE);
                id = c.getString(TAG_CHECKED_OUT_ID);
                likes = c.getString(TAG_LIKES);
                booleanLiked = c.getString(TAG_BOOLEAN_LIKED);
                userFine = c.getString(TAG_USER_FINE);

                if (bookName.equals(null) || bookName.isEmpty() || bookName.equalsIgnoreCase("null")) {
                    continue;
                }

                if (Objects.equals(userFine, "")) {
                    userFine = "0.00";
                }
                userFineText.setText("Your current fines are: $" + userFine);
                if (!userFine.equals("0.00")) {
                    userFineText.setTextColor(Color.RED);
                    userFineText.setTextSize(25);
                }

                final HashMap<String, String> persons = new HashMap<>();

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date currentTime = Calendar.getInstance().getTime();

                persons.put(TAG_BOOK_NAME, bookName);
                persons.put(TAG_BOOK_ID, "Book ID: " + bookId);
                persons.put(TAG_USER_FIRST, userName + " " + lastName);
                persons.put(TAG_LIBRARY_ID, libraryIdDatabase);
                persons.put(TAG_OUT, dateOut);
                persons.put(TAG_DUE, dateDue);
                persons.put(TAG_CHECKED_OUT_ID, id);
                persons.put(TAG_LIKES, "+" + likes);
                persons.put(TAG_BOOLEAN_LIKED, booleanLiked);
                persons.put(TAG_USER_FINE, userFine);

                booksList.add(persons);
            }
//          Use Custom Log In Adapter to setup the variable logInAdapter
            logInAdapter = new CustomLogInAdapter(getContext(), booksList, R.layout.layout_account_list_item,
                    new String[]{TAG_BOOK_NAME, TAG_USER_FIRST, TAG_OUT, TAG_DUE, TAG_CHECKED_OUT_ID, TAG_BOOK_ID, TAG_LIKES, TAG_BOOLEAN_LIKED},
                    new int[]{R.id.bookName, R.id.userName, R.id.outDate, R.id.dueDate, R.id.checkedOutId, R.id.bookId, R.id.numberOfLikes, R.id.booleanLiked}
            );

//          Set Adapter for books checked out list
            try {
                listAccount.setAdapter(logInAdapter);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts input stream to retrieve data from any kind of stream, in our case, a webpage
     *
     * @param inputStream
     * @return the input stream type value as a string
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
     * Used to encapsulate the user email
     *
     * @return the email of the user
     */
    public static String sendUserEmail() {
        return mEmailView.getText().toString();
    }

    /**
     * Used to encapsulate the user email
     *
     * @return the library id of the user
     */
    public static String sendLibraryId() {
        return libraryIdDatabase;
    }

    /**
     * Used to encapsulate the user email
     *
     * @return if the user is logged in or not as a boolean
     */
    public static Boolean sendLoggedIn() {
        return loggedIn;
    }

    /**
     * Used to encapsulate the user email
     *
     * @return the name of the user
     */
    public static String sendUserName() {
        return userName;
    }

    /**
     * This method logs out the user from his/her account
     */
    public void logOut() {
        accountLayout.setVisibility(View.GONE);
        logInLayout.setVisibility(View.VISIBLE);

        password = "";
        passwordEditor = null;
        mPasswordView.setText("");
        loggedIn = false;

        Fragment currentFragment = getFragmentManager().findFragmentByTag(this.getTag());
        FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.detach(currentFragment);
        fragTransaction.attach(currentFragment);
        fragTransaction.commit();
    }

    /**
     * This method checks the credentials of the user that is attempting to log in
     *
     * @param email
     * @param password
     */
    public void checkCredentials(String email, String password) {
        new Login().execute(email, password);
    }


    /**
     * This class is used in the checkCredentials method for LogIn and uses AsyncTask of type String, String, String
     */
    @SuppressLint("StaticFieldLeak")
    private class Login extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL dataUrl = null;

        @Override
        protected String doInBackground(String... params) {
            try {
                dataUrl = new URL("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/checkUsernamePassword.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Malformed URL Exception", Toast.LENGTH_LONG).show();
                return "exception";
            }
            try {
                conn = (HttpURLConnection) dataUrl.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", params[0])
                        .appendQueryParameter("password", params[1]);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                e1.printStackTrace();
                Toast.makeText(getContext(), "Input-Output Exception", Toast.LENGTH_LONG).show();
                return "exception";
            }

            try {
                int response_code = conn.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {

                    InputStream input = conn.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                    return (result.toString());
                } else {
                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "IOException";
            } finally {
                conn.disconnect();
            }
        }
//      After doInBackground, this executes and updates the user interface layer with the result

        /**
         * After doInBackground, this method is executed and updates the user interface layer with the result
         *
         * @param insideResult
         */
        @Override
        protected void onPostExecute(final String insideResult) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pdLoading.dismiss();
                            if (mEmailView.getText().toString().equals("") || mPasswordView.getText().toString().equals("")) {
                                Toast.makeText(getContext(), "Invalid credentials... Please try again", Toast.LENGTH_LONG).show();
                                logInLayout.setVisibility(View.VISIBLE);
                                accountLayout.setVisibility(View.GONE);
                                logOutButton.setVisibility(View.GONE);
                                validCredentials = false;
                                loggedIn = false;
                            } else if (insideResult.equalsIgnoreCase("true")) {
                                logInLayout.setVisibility(View.GONE);
                                accountLayout.setVisibility(View.VISIBLE);
                                logOutButton.setVisibility(View.VISIBLE);
                                validCredentials = true;
                                loggedIn = true;
                                getBooksOut();
                                SharedPreferences pref = getContext().getSharedPreferences("myPrefs", 0); // 0 represents that this data is private and only the app can access this shared preference data
                                String tokenPrefString = pref.getString("tokenKey", null);
                                String registrationIdPref = pref.getString("registrationKey", null);
                                insertToken(tokenPrefString, registrationIdPref, "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/insertToken.php");

                                try {
                                    MenuItem menuItem = null;
                                    menuItem = accountMenu.findItem(R.id.changePassword);
                                    menuItem.setVisible(true);
                                } catch (NullPointerException ignored) {
                                    Log.d("No Change Password Item", "The change password icon in the action bar does not exist. Please restart the app and try again");
                                }
                                setHasOptionsMenu(true);

                            } else if (insideResult.equalsIgnoreCase("false")) {
                                Toast.makeText(getContext(), "Invalid credentials... Please try again", Toast.LENGTH_LONG).show();
                                logInLayout.setVisibility(View.VISIBLE);
                                accountLayout.setVisibility(View.GONE);
                                logOutButton.setVisibility(View.GONE);
                                validCredentials = false;
                                loggedIn = false;
                            } else if (insideResult.equalsIgnoreCase("exception") || insideResult.equalsIgnoreCase("unsuccessful")) {
                                Toast.makeText(getContext(), "Oops! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();
                                logInLayout.setVisibility(View.VISIBLE);
                                accountLayout.setVisibility(View.GONE);
                                logOutButton.setVisibility(View.GONE);
                                validCredentials = false;
                                loggedIn = false;
                            } else {
                                Toast.makeText(getContext(), "Invalid credentials... Please try again", Toast.LENGTH_LONG).show();
                                logInLayout.setVisibility(View.VISIBLE);
                                accountLayout.setVisibility(View.GONE);
                                validCredentials = false;
                                loggedIn = false;
                            }
                        }
                    }, 1500);
                }
            });
        }
    }


    /**
     * This method is executed when the android OS tells the app that it has been started. In this method, the app retrieves the cached data about the saved
     */
    @Override
    public void onStart() {
        super.onStart();
        active = true;

        SharedPreferences getSavedUsername = getActivity().getSharedPreferences("Username", MODE_PRIVATE);
        savedUsername = getSavedUsername.getString("username", null);
        SharedPreferences getSavedPassword = getActivity().getSharedPreferences("Password", MODE_PRIVATE);
        savedPassword = getSavedPassword.getString("password", null);
        SharedPreferences getLoggedPrefs = getActivity().getSharedPreferences("StayLoggedIn", MODE_PRIVATE);
        loggedInString = getLoggedPrefs.getString("stayLoggedIn", null);

        try {
            if (loggedInString.equalsIgnoreCase("yes")) {
                mEmailView.setText(savedUsername);
                mPasswordView.setText(savedPassword);
                checkCredentials(savedUsername, savedPassword);
                logInLayout.setVisibility(View.GONE);
                accountLayout.setVisibility(View.VISIBLE);
                signUpLayout.setVisibility(View.GONE);
                logOutButton.setVisibility(View.VISIBLE);
            } else {
                if (savedUsername == null) {
                    saveUsername.setChecked(false);
                } else {
                    saveUsername.setChecked(true);
                }
                if (savedPassword == null) {
                    savePassword.setChecked(false);
                } else {
                    savePassword.setChecked(true);
                }
                if (loggedInString == null) {
                    stayLoggedIn.setChecked(false);
                } else {
                    stayLoggedIn.setChecked(true);
                }

                mEmailView.setText(savedUsername);
                mPasswordView.setText(savedPassword);
            }
        } catch (NullPointerException npe) {
            if (savedUsername == null) {
                saveUsername.setChecked(false);
            } else {
                saveUsername.setChecked(true);
            }
            if (savedPassword == null) {
                savePassword.setChecked(false);
            } else {
                savePassword.setChecked(true);
            }
            if (loggedInString == null) {
                stayLoggedIn.setChecked(false);
            } else {
                stayLoggedIn.setChecked(true);
            }

            mEmailView.setText(savedUsername);
            mPasswordView.setText(savedPassword);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        active = true;

        SharedPreferences getSavedUsername = getActivity().getSharedPreferences("Username", MODE_PRIVATE);
        savedUsername = getSavedUsername.getString("username", null);
        SharedPreferences getSavedPassword = getActivity().getSharedPreferences("Password", MODE_PRIVATE);
        savedPassword = getSavedPassword.getString("password", null);
        SharedPreferences getLoggedPrefs = getActivity().getSharedPreferences("StayLoggedIn", MODE_PRIVATE);
        loggedInString = getLoggedPrefs.getString("stayLoggedIn", null);

        try {
            if (loggedInString.equalsIgnoreCase("yes")) {
                mEmailView.setText(savedUsername);
                mPasswordView.setText(savedPassword);
                checkCredentials(savedUsername, savedPassword);
                logInLayout.setVisibility(View.GONE);
                accountLayout.setVisibility(View.VISIBLE);
                signUpLayout.setVisibility(View.GONE);
                logOutButton.setVisibility(View.VISIBLE);
            } else {
                if (savedUsername == null) {
                    saveUsername.setChecked(false);
                } else {
                    saveUsername.setChecked(true);
                }
                if (savedPassword == null) {
                    savePassword.setChecked(false);
                } else {
                    savePassword.setChecked(true);
                }
                if (loggedInString == null) {
                    stayLoggedIn.setChecked(false);
                } else {
                    stayLoggedIn.setChecked(true);
                }
                mEmailView.setText(savedUsername);
                mPasswordView.setText(savedPassword);
            }
        } catch (NullPointerException npe) {
            if (savedUsername == null) {
                saveUsername.setChecked(false);
            } else {
                saveUsername.setChecked(true);
            }
            if (savedPassword == null) {
                savePassword.setChecked(false);
            } else {
                savePassword.setChecked(true);
            }
            if (loggedInString == null) {
                stayLoggedIn.setChecked(false);
            } else {
                stayLoggedIn.setChecked(true);
            }

            mEmailView.setText(savedUsername);
            mPasswordView.setText(savedPassword);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        active = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        active = false;
    }

    private void registerUser(final String... args) {
        @SuppressLint("StaticFieldLeak")
        class SignUpAsync extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                List<NameValuePair> signUpPair = new ArrayList<>();
                signUpPair.add(new BasicNameValuePair("libraryIdSignup", args[0]));
                signUpPair.add(new BasicNameValuePair("userFirstName", args[1]));
                signUpPair.add(new BasicNameValuePair("userLastName", args[2]));
                signUpPair.add(new BasicNameValuePair("userEmail", args[3]));
                signUpPair.add(new BasicNameValuePair("userPassword", args[4]));
                signUpPair.add(new BasicNameValuePair("userPhoneNumber", args[5]));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(args[args.length - 1]);
                    httpPost.setEntity(new UrlEncodedFormEntity(signUpPair));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity entity = httpResponse.getEntity();


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        }
        SignUpAsync signUpAsync = new SignUpAsync();
        signUpAsync.execute();
    }

    private void insertToken(final String token, final String registrationId, final String url) {
        @SuppressLint("StaticFieldLeak")
        class SignUpAsync extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                List<NameValuePair> signUpPair = new ArrayList<>();
                signUpPair.add(new BasicNameValuePair("token", token));
                signUpPair.add(new BasicNameValuePair("registrationId", registrationId));
                signUpPair.add(new BasicNameValuePair("userEmail", mEmailView.getText().toString()));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(url);
                    httpPost.setEntity(new UrlEncodedFormEntity(signUpPair));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity entity = httpResponse.getEntity();


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        }
        SignUpAsync signUpAsync = new SignUpAsync();
        signUpAsync.execute();
    }

    public void updatePassword(String email, String updatePassword) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("email", email));
        nameValuePairs.add(new BasicNameValuePair("password", updatePassword));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/updatePassword.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
            Toast.makeText(getContext(), "Invalid IP Address", Toast.LENGTH_LONG).show();
        }

        try {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("pass 2", "connection success ");
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {
            JSONObject json_data = new JSONObject(result);
            code = (json_data.getInt("code"));

            if (!(code == 1)) {
                Toast.makeText(getContext(), "Please Try Again", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }


    public void updatePasswordCheck(String email, String password) {
        new UpdatePassword().execute(email, password);
    }

    @SuppressLint("StaticFieldLeak")
    private class UpdatePassword extends AsyncTask<String, String, String> {
        HttpURLConnection conn;
        URL dataUrl = null;

        @Override
        protected String doInBackground(String... params) {
            try {

                dataUrl = new URL("http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/checkUsernamePassword.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Malformed URL Exception", Toast.LENGTH_LONG).show();
                return "exception";
            }
            try {
                conn = (HttpURLConnection) dataUrl.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", params[0])
                        .appendQueryParameter("password", params[1]);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                e1.printStackTrace();
                Toast.makeText(getContext(), "Input-Output Exception", Toast.LENGTH_LONG).show();
                return "exception";
            }

            try {
                int response_code = conn.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {

                    InputStream input = conn.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        result.append(line);
                    }
                    return (result.toString());
                } else {
                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "IOException";
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(final String insideResult) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Handler mHandler = new Handler();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pdLoading.dismiss();
                                if (mEmailView.getText().toString().equals("") || mPasswordView.getText().toString().equals("")) {
                                    Toast.makeText(getContext(), "Invalid credentials... Please try again", Toast.LENGTH_LONG).show();
                                    changePassValid = false;
                                } else if (insideResult.equalsIgnoreCase("true")) {
                                    Log.v("onPostExecuteLine-1458", insideResult);
                                    updatePassword(mEmailView.getText().toString(), newPasswordEdit.getText().toString());
                                    changePassValid = true;
                                    try {
                                        loggedInEditor.clear().commit();
                                    } catch (NullPointerException ignored) {
                                    }
                                    saveUsername.setChecked(false);
                                    savePassword.setChecked(false);
                                    stayLoggedIn.setChecked(false);
                                } else if (insideResult.equalsIgnoreCase("false")) {
                                    Toast.makeText(getContext(), "Invalid password... Please try again", Toast.LENGTH_LONG).show();
                                    changePassValid = false;

                                } else if (insideResult.equalsIgnoreCase("exception") || insideResult.equalsIgnoreCase("unsuccessful")) {
                                    Toast.makeText(getContext(), "Please check your internet then try again.", Toast.LENGTH_LONG).show();
                                    changePassValid = false;
                                } else {
                                    changePassValid = false;
                                }
                            }
                        }, 1500);
                    }
                });
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.account_menu, menu);
        accountMenu = menu;
        sv = (SearchView) menu.findItem(R.id.item_search_account).getActionView();
        setupSearchView();

        if (!loggedIn) {
            menu.getItem(0).setVisible(false);
        } else {
            menu.getItem(0).setVisible(true);
            menu.getItem(1).setVisible(true);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // profile settings icon clicked
            case R.id.reportBug:
                reportBug = new AlertDialog.Builder(getContext())
                        .setView(reportBugView)
                        .setTitle("Report Bug")
                        .setIcon(R.drawable.mybrary_icon)
                        .setCancelable(false)
                        .setMessage("Please explain the bug you have found in the application in as much detail as possible. We appreciate this gesture of yours!")
                        .setPositiveButton("Report Bug", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    GMailSender sender = new GMailSender(mybraryEmail, mybraryPassword);
                                    sender.sendMail("Received Bug Report",
                                            userEmail + " has found a bug. : \n" + explainBug.getText().toString() + ". \n\t",
                                            mybraryEmail,
                                            mybraryEmail);
                                    Toast.makeText(getContext(), "You're bug has been received. Thank you!", Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    Log.e("SendMail", e.getMessage(), e);
                                }
                            }
                        }) //Overridden in the onclick within show listener
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                reportBug.dismiss();
                                reportBug.cancel();
                            }
                        })
                        .create();
                if (reportBugView.getParent() != null) {
                    ((ViewGroup) reportBugView.getParent()).removeView(reportBugView);
                }
                reportBug.show();
                break;
            // change password option clicked under settings
            case R.id.changePassword:
                final AlertDialog changePassDialog = new AlertDialog.Builder(getContext())
                        .setView(changePassView)
                        .setTitle("Change Password")
                        .setIcon(R.drawable.mybrary_icon)
                        .setCancelable(false)
                        .setMessage("Please enter your current password and your new password. Then enter your new password again to confirm it.")
                        .setPositiveButton(R.string.change_password, null) //Overridden in the onclick within show listener
                        .setNegativeButton(android.R.string.cancel, null)
                        .create();

                changePassDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(final DialogInterface dialog) {

                        Button changePass = changePassDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        changePass.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                if (newPasswordEdit.getText().toString().equals(confirmPasswordEdit.getText().toString()) && !(oldPasswordEdit.getText().toString().isEmpty()) &&
                                        !(newPasswordEdit.getText().toString().isEmpty()) && !(confirmPasswordEdit.getText().toString().isEmpty())) {
                                    updatePasswordCheck(mEmailView.getText().toString(), oldPasswordEdit.getText().toString());
                                    Toast.makeText(getContext(), "Password changed.", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getActivity(), SwipeViewActivity.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                } else if (oldPasswordEdit.getText().toString().isEmpty() ||
                                        newPasswordEdit.getText().toString().isEmpty() || confirmPasswordEdit.getText().toString().isEmpty() ||
                                        !(Objects.equals(newPasswordEdit.getText().toString(), confirmPasswordEdit.getText().toString()))) {
                                    Toast.makeText(getContext(), "Please make sure the new password and confirm password is the same.", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getContext(), "Incorrect password. Please try again.", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
                if (changePassView.getParent() != null) {
                    ((ViewGroup) changePassView.getParent()).removeView(changePassView);
                }
                changePassDialog.show();
                break;
            case R.id.item_search_account:
                setupSearchView();
            default:
                break;
        }
        return true;
    }


    private void setupSearchView() {

        sv.setIconifiedByDefault(true);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        if (searchManager != null) {
            List<SearchableInfo> searchables = searchManager.getSearchablesInGlobalSearch();

            // Try to use the "applications" global search provider
            SearchableInfo info = searchManager.getSearchableInfo(getActivity().getComponentName());
            for (SearchableInfo inf : searchables) {
                if (inf.getSuggestAuthority() != null
                        && inf.getSuggestAuthority().startsWith("applications")) {
                    info = inf;
                }
            }
            sv.setSearchableInfo(info);
        }

        sv.setOnQueryTextListener(this);
        sv.setOnCloseListener(this);
    }

    public boolean onQueryTextChange(String newText) {
        getSearchedBooksOut(newText);
        return false;
    }

    public boolean onQueryTextSubmit(String query) {
        getSearchedBooksOut(query);
        return false;
    }

    public boolean onClose() {
        return false;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem register = menu.findItem(R.id.changePassword);
        if (!loggedIn) {
            register.setVisible(false);
        } else {
            register.setVisible(true);
        }
        super.onPrepareOptionsMenu(menu);
    }

    public void getSearchedBooksOut(final String queryWord) {
        @SuppressLint("StaticFieldLeak")
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                InputStream inputStream;
                String result;
                String dataUrl = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/getSearchedBooksOut.php";

                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    httpPost = new HttpPost(dataUrl);
                    String json1;

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.accumulate("user", mEmailView.getText().toString());
                    jsonObject.accumulate("queryWord", queryWord);

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
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                    logInCode = 0;
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "Input-Output Exception", Toast.LENGTH_LONG).show();
                        }
                    });
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
                showSearchedBooksOut(myJSON);
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    public void showSearchedBooksOut(String jsonData) {
        user = userEmail;
        inputStream = null;
        result = "";
        dataUrl = "http://ec2-52-41-161-91.us-west-2.compute.amazonaws.com/getSearchedBooksOut.php";

        try {
            JSONObject jsonObj = new JSONObject(jsonData);

            booksArray = jsonObj.getJSONArray(TAG_RESULTS);
            booksList = new ArrayList<>();

            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject c = booksArray.getJSONObject(i);

                bookName = c.getString(TAG_BOOK_NAME);
                bookId = c.getString(TAG_BOOK_ID);
                userName = c.getString(TAG_USER_FIRST);
                lastName = c.getString(TAG_USER_LAST);
                libraryIdDatabase = c.getString(TAG_LIBRARY_ID);
                dateOut = c.getString(TAG_OUT);
                dateDue = c.getString(TAG_DUE);
                id = c.getString(TAG_CHECKED_OUT_ID);
                likes = c.getString(TAG_LIKES);
                booleanLiked = c.getString(TAG_BOOLEAN_LIKED);
                userFine = c.getString(TAG_USER_FINE);

                if (bookName.equals(null) || bookName.isEmpty() || bookName.equalsIgnoreCase("null")) {
                    continue;
                }

                if (Objects.equals(userFine, "")) {
                    userFine = "0.00";
                }
                userFineText.setText("Your current fines are: $" + userFine);
                if (!userFine.equals("0.00")) {
                    userFineText.setTextColor(Color.RED);
                    userFineText.setTextSize(25);
                }


                final HashMap<String, String> persons = new HashMap<>();

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date currentTime = Calendar.getInstance().getTime();

                persons.put(TAG_BOOK_NAME, bookName);
                persons.put(TAG_BOOK_ID, bookId);
                persons.put(TAG_USER_FIRST, userName + " " + lastName);
                persons.put(TAG_LIBRARY_ID, libraryIdDatabase);
                persons.put(TAG_OUT, dateOut);
                persons.put(TAG_DUE, dateDue);
                persons.put(TAG_CHECKED_OUT_ID, id);
                persons.put(TAG_LIKES, "+" + likes);
                persons.put(TAG_BOOLEAN_LIKED, booleanLiked);
                persons.put(TAG_USER_FINE, userFine);

                booksList.add(persons);
            }
            logInAdapter = new CustomLogInAdapter(getContext(), booksList, R.layout.layout_account_list_item,
                    new String[]{TAG_BOOK_NAME, TAG_USER_FIRST, TAG_OUT, TAG_DUE, TAG_CHECKED_OUT_ID, TAG_BOOK_ID, TAG_LIKES, TAG_BOOLEAN_LIKED},
                    new int[]{R.id.bookName, R.id.userName, R.id.outDate, R.id.dueDate, R.id.checkedOutId, R.id.bookId, R.id.numberOfLikes, R.id.booleanLiked}
            );

            try {
                listAccount.setAdapter(logInAdapter);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}