package com.codegeek.fblalibraryapp;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class sets up the tabs and the view pager for the app.
 *
 * @Shreshth Kharbanda
 */
@SuppressWarnings("deprecation")
public class SwipeViewActivity extends AppCompatActivity implements
        ActionBar.TabListener {

    public ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public String[] tabs = {"Book Catalogue", "My Account", "Library Map"};

    ProgressBar progressBar;
    private Handler handler = new Handler();
    Boolean opened = false;
    ImageView splashLogo;
    int progressStatus = 0;

    /**
     * This method is called on the creation of this class and sets up the
     * view pager, action bar, progress bar, and splash logo.
     *
     * @param (savedInstanceState)
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view);

        splashLogo = findViewById(R.id.splashLogo);
        progressBar = findViewById(R.id.progressBar);

        viewPager = findViewById(R.id.pager);
        actionBar = getSupportActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        opened = true;
        setUpTabs();
    }


    @Override
    protected void onResume() {
        super.onResume();
        opened = true;
    }

    /**
     * displays the spashscreen when the application is first opened
     */
    @Override
    protected void onStart() {
        super.onStart();
        splashScreen();
        opened = true;
    }

    /**
     * displays the splashscreen when the application
     */
    public void splashScreen() {
        while (progressBar.getProgress() < 100) {
            progressBar.setProgress(progressBar.getProgress() + new Random().nextInt(4) + 1);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus <= 100) {
                    progressStatus += new Random().nextInt(12) + 2;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
//                            textView.setText(progressStatus+"/"+progressBar.getMax());
                            if (progressStatus >= 100) {
                                splashLogo.bringToFront();
                                progressBar.setVisibility(View.INVISIBLE);
                                splashLogo.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));


                                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_animation);
                                splashLogo.startAnimation(animation);
                                animation.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                        new BookDatabaseFragment().bookList = new ArrayList<>();
                                        new BookDatabaseFragment().getAllBooks();

                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                splashLogo.setVisibility(View.GONE);
                                                viewPager.setVisibility(View.VISIBLE);
                                            }
                                        }, 3500);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {
                                        // never happens
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        // animation ended
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                            }
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds.
                        Thread.sleep(new Random().nextInt(310) + 68);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * sets up the tabs for the app
     */
    public void setUpTabs() {
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * sets the current tab for the app on the view pager.
     *
     * @param tab
     * @param ft
     */
    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}