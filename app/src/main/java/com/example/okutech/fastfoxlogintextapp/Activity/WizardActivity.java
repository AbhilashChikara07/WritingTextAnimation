package com.example.okutech.fastfoxlogintextapp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.okutech.fastfoxlogintextapp.Fragments.WizardBhkFragment;
import com.example.okutech.fastfoxlogintextapp.Fragments.WizardPriceFragment;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/12/17
 */

public class WizardActivity extends AppCompatActivity {

    @BindView(R.id.containerFL)
    FrameLayout mContainerFL;

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_activity);
        ButterKnife.bind(this);
        openSelectedFragment(new WizardBhkFragment());
    }

    private void openSelectedFragment(Fragment targetFragment) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.containerFL, targetFragment, "");
        ft.commit();
    }
}
