package com.example.okutech.fastfoxlogintextapp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.okutech.fastfoxlogintextapp.Fragments.EnterMobileNoFragment;
import com.example.okutech.fastfoxlogintextapp.Fragments.EnterOtpFragment;
import com.example.okutech.fastfoxlogintextapp.Fragments.EnterUserDetailFragment;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/7/17
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.containerFL)
    FrameLayout containerFL;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        ButterKnife.bind(this);
        openFragment(new EnterMobileNoFragment());
    }

    public void openFragment(Fragment targetFragment) {
        mFragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.containerFL, targetFragment, "");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void sendMobileNoToServer(){

    }
}
