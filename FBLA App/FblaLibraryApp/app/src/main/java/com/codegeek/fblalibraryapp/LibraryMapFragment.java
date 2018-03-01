package com.codegeek.fblalibraryapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;

public class LibraryMapFragment extends Fragment {

    ZoomageView libraryMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library_map, container, false);
        libraryMap = rootView.findViewById(R.id.libraryMapImage);

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.account_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // profile settings icon clicked
            case R.id.reportBug:
                Toast.makeText(getContext(), "Refresh selected", Toast.LENGTH_SHORT)
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
}