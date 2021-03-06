package com.example.okutech.fastfoxlogintextapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxButton;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextView;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayWelcomeTextActivity extends AppCompatActivity {

    @BindView(R.id.userName)
    FastFoxTextView mUserName;
    @BindView(R.id.welcomeText)
    FastFoxTextView mWelcomeText;
    @BindView(R.id.separateProgressBar)
    ProgressBar mSeparateProgressBar;
    @BindView(R.id.getExactlyTV)
    FastFoxTextView mGetExactlyTV;
    @BindView(R.id.getStartedBtn)
    FastFoxButton mGetStartedBtn;

    private Handler mHandler;
    private Runnable mRunnable;
    private int mProgressMin = 0;
    private int mProgressMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_text_layiut);
        ButterKnife.bind(this);
        mProgressMax = mSeparateProgressBar.getMax();
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
                mProgressMin = mProgressMin + 2;
                mSeparateProgressBar.setProgress(mProgressMin);
                if (mProgressMin < mProgressMax) {
                    mHandler.postDelayed(mRunnable, 1);
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

    @OnClick(R.id.getStartedBtn)
    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
