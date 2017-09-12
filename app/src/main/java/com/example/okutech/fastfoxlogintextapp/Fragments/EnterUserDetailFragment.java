package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextInputLayout;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/11/17
 */

public class EnterUserDetailFragment extends Fragment {

    @BindView(R.id.emailIdlInputLayout)
    FastFoxTextInputLayout mEmailIdlInputLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enter_user_detail_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
