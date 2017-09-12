package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.okutech.fastfoxlogintextapp.Activity.LoginActivity;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxButton;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxEditTextView;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextInputLayout;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextView;
import com.example.okutech.fastfoxlogintextapp.R;
import com.example.okutech.fastfoxlogintextapp.Utilities.UtilClass;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/8/17
 */

public class EnterOtpFragment extends Fragment {

    @BindView(R.id.verificationCodeTV)
    FastFoxTextView mVerificationCodeTV;
    @BindView(R.id.actionBtn)
    FastFoxButton mVerifyBtn;
    @BindView(R.id.resendBtn)
    FastFoxButton mResendBtn;
    @BindView(R.id.enterOtpETV)
    FastFoxEditTextView mEnterOtpETV;
    @BindView(R.id.enterOtpTIL)
    FastFoxTextInputLayout mEnterOtpTIL;
    @BindView(R.id.showTimerTV)
    FastFoxTextView mShowTimerTV;

    private String demoMobileNo = "  +91 9953040685";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enter_otp_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showTimer();
        String text = getResources().getString(R.string.verification_code_text) + demoMobileNo;
        Spannable spannableString = UtilClass.getSelectedColorText(text,
                getResources().getString(R.string.verification_code_text).length(),
                text.length(), ContextCompat.getColor(getActivity(), R.color.color_20AC76));
        mVerificationCodeTV.setText(spannableString);
        mVerifyBtn.setText(getResources().getString(R.string.verify_btn_text));
        mEnterOtpETV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    mEnterOtpTIL.setError(null);
                    mResendBtn.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),
                            R.drawable.button_unselect));
                    mResendBtn.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_b7b8b9));
                } else {
                    mResendBtn.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),
                            R.drawable.button_select));
                    mResendBtn.setTextColor(ContextCompat.getColor(getActivity(), R.color.color_20AC76));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void showTimer() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                mShowTimerTV.setText(String.format("%d sec",
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                mShowTimerTV.setVisibility(View.GONE);
            }
        }.start();
    }

    @OnClick(R.id.actionBtn)
    public void openUserDetailFragment() {
        if (checkValidate()) {
            if (checkValidate()) {
                ((LoginActivity) getActivity()).openFragment(new EnterUserDetailFragment());
            }
        }
    }

    private boolean checkValidate() {
        if (mEnterOtpETV.getText().length() < 4) {
            mEnterOtpTIL.setError("sdsdsdsdsd");
            return false;
        }
        return true;
    }

    @OnClick(R.id.resendBtn)
    public void requestForOTP() {

    }

}
