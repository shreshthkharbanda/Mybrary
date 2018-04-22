package com.codegeek.fblalibraryapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;

import java.util.Objects;

public class LibraryMapFragment extends Fragment {

    ZoomageView libraryMap;

    EditText newPasswordEdit;
    EditText oldPasswordEdit;
    EditText confirmPasswordEdit;
    View changePassView;
    View reportBugView;
    EditText explainBug;
    final String mybraryEmail = "mybraryHelp@gmail.com";
    final String mybraryPassword = "MybraryPassword";
    AlertDialog reportBug;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library_map, container, false);
        libraryMap = rootView.findViewById(R.id.libraryMapImage);

        changePassView = inflater.inflate(R.layout.change_password_dialog_layout, container, false);
        oldPasswordEdit = changePassView.findViewById(R.id.oldPassword);
        newPasswordEdit = changePassView.findViewById(R.id.newPassword);
        confirmPasswordEdit = changePassView.findViewById(R.id.confirmPassword);

        reportBugView = inflater.inflate(R.layout.report_bug_layout, container, false);
        explainBug = reportBugView.findViewById(R.id.explainBug);
        new LogInFragment();
        if (LogInFragment.loggedIn) {
            setHasOptionsMenu(true);
        } else {
            setHasOptionsMenu(true);
        }

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.general_menu, menu);
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
                                            "A user has found a bug. : \n" + explainBug.getText().toString() + ". \n\t",
                                            mybraryEmail,
                                            mybraryEmail);
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
            default:
                break;
        }
        return true;
    }
}