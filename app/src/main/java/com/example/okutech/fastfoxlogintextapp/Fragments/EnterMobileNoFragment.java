package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxButton;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxEditTextView;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextInputLayout;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/7/17
 */

public class EnterMobileNoFragment extends Fragment {

    @BindView(R.id.enterMobileNo)
    FastFoxEditTextView mEnterMobileNo;
    @BindView(R.id.actionBtn)
    FastFoxButton continueBtn;
    @BindView(R.id.textInputLayout)
    FastFoxTextInputLayout mTextInputLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enter_mobile_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        continueBtn.setText(getResources().getString(R.string.continue_btn_text));
        mEnterMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 0) {
                    mTextInputLayout.setError("");
                }
            }
        });

        mEnterMobileNo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    KeypadUtil.hideKeypad(getActivity());
                    return true;
                }
                return false;
            }
        });

    }

    @OnClick(R.id.actionBtn)
    public void onContinueBtnClick() {
        if (checkValidate()) {
        }
    }


    private boolean checkValidate() {
        if (mEnterMobileNo.getText().length() < 10) {
            mTextInputLayout.setError("ssasasasa");
            return false;
        }
        return true;
    }
}
