package com.example.okutech.fastfoxlogintextapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private ScrollView mScrollView;
    private FastFoxTextView mUserName;
    private FastFoxTextView mWelcomeText;
    private ProgressBar mSeparateProgressBar;
    private FastFoxTextView mGetExactlyTV;
    private Handler mHandler ;
    private Runnable mRunnable;
    private int mProgressMin = 0;
    private int mProgressMax = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mUserName = (FastFoxTextView) findViewById(R.id.userName);
        mWelcomeText = (FastFoxTextView) findViewById(R.id.welcomeText);
        mSeparateProgressBar = (ProgressBar) findViewById(R.id.separateProgressBar);
        mGetExactlyTV = (FastFoxTextView) findViewById(R.id.getExactlyTV);
        displayAnimatedUserName();
    }

    private void displayAnimatedUserName() {
        mUserName.startTextAnimation(getResources().getString(R.string.user_name),
                new FastFoxTextView.FinishAnimation() {
                    @Override
                    public void finishAnimationCallBack() {
                        displayAnimatedWelcomeText();
                    }
                });

    }

    private void displayAnimatedWelcomeText() {
        mWelcomeText.startTextAnimation(getResources().getString(R.string.welcome_text),
                new FastFoxTextView.FinishAnimation() {
                    @Override
                    public void finishAnimationCallBack() {
                        showSeparateProgressBar();
                    }
                });

    }


    private void showSeparateProgressBar() {
        mSeparateProgressBar.setVisibility(View.VISIBLE);
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSeparateProgressBar.setProgress(mProgressMin++);
                if (mProgressMin < mProgressMax) {
                    mHandler.postDelayed(mRunnable, 0);
                } else {
                    mHandler.removeCallbacks(mRunnable);
                    displayExactlyText();
                }
            }
        };
        mHandler.post(mRunnable);
    }

    private void displayExactlyText() {
        mGetExactlyTV.startTextAnimation(getResources().getString(R.string.welcome_text),
                new FastFoxTextView.FinishAnimation() {
                    @Override
                    public void finishAnimationCallBack() {
                    }
                });
    }
}
