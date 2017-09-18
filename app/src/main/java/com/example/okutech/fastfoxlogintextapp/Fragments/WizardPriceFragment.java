package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxButton;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxTextView;
import com.example.okutech.fastfoxlogintextapp.CustomViews.WizardCircleProgress;
import com.example.okutech.fastfoxlogintextapp.CustomViews.WizardLineView;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/12/17
 */

public class WizardPriceFragment extends Fragment {

    @BindView(R.id.headerTV)
    FastFoxTextView mHeaderTV;
    @BindView(R.id.backIB)
    ImageButton mBackIB;
    @BindView(R.id.closeTV)
    FastFoxButton mCloseTV;

    @BindView(R.id.firstWC)
    WizardCircleProgress mFirstCW;
    @BindView(R.id.firstWL)
    WizardLineView mFirstWL;
    @BindView(R.id.secondWC)
    WizardCircleProgress mSecondWC;
    @BindView(R.id.secondWL)
    WizardLineView mSecondWL;
    @BindView(R.id.thirdWC)
    WizardCircleProgress mThirdWC;
    @BindView(R.id.thirdWL)
    WizardLineView mThirdWL;
    @BindView(R.id.fourthWC)
    WizardCircleProgress mFourthWC;
    @BindView(R.id.fourthWL)
    WizardLineView mSourthWL;
    @BindView(R.id.fifthWC)
    WizardCircleProgress mFifthWC;

    @BindView(R.id.uptoTV)
    FastFoxTextView mUptoTV;
    @BindView(R.id.seekBar)
    SeekBar mSeekBar;
    @BindView(R.id.minPriceTV)
    FastFoxTextView mMinPriceTV;
    @BindView(R.id.maxPriceTV)
    FastFoxTextView mMaxPriceTV;

    @BindView(R.id.skipQuestionBTN)
    FastFoxButton mSkipQuestionBTN;
    @BindView(R.id.nextBTN)
    FastFoxButton nextBTN;

    private final int MAX_SEEK_BAR_VALUE = 100000;
    private final int MIN_SEEK_BAR_VALUE = 12000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wizard_price_frag_lay, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        displayPriceText(mSeekBar.getProgress());
        mSeekBar.setPadding(12, 0, 12, 0);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int priceValue, boolean b) {
                displayPriceText(priceValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @OnClick(R.id.nextBTN)
    public void onClickNextBtn() {
        mFirstCW.setProgressValue(0);
        mSecondWC.setProgressValue(0);
        mThirdWC.setProgressValue(0);
        mFirstWL.setProgress(0);
        mSecondWL.setProgress(0);

        mFirstCW.setState(2);
        mFirstWL.startProgress(100);
        mSecondWC.setState(2);
        mSecondWL.startProgress(100);
        mThirdWC.setState(1);
    }

    /*
    * This function is used to display price value.
    * Also used to display minimum and maximum price.
    *
    * */

    private void displayPriceText(int priceValue) {

        String rupeeText = getResources().getString(R.string.rupee_text);
        String minTextString = rupeeText + " " + getResources().getString(R.string.min_price_text);
        String maxTextString = rupeeText + " " + getResources().getString(R.string.max_price_text);
        mMinPriceTV.setText(minTextString);
        mMaxPriceTV.setText(maxTextString);

        if (priceValue == MAX_SEEK_BAR_VALUE) {
            mUptoTV.setText(maxTextString);
        } else if (priceValue <= MIN_SEEK_BAR_VALUE) {
            mUptoTV.setText(minTextString);
        } else {
            String firstCharacter = String.valueOf(priceValue / 1000);

            priceValue /= 1000;
            priceValue *= 1000;

            String priceStringValue = String.valueOf(priceValue);

            String lastCharacter = priceStringValue.substring(firstCharacter.length(),
                    priceStringValue.length());

            String displayText = firstCharacter + "," + lastCharacter;

            String upToText = getResources().getString(R.string.rupee_text) + " " + displayText;
            mUptoTV.setText(upToText);
        }
    }
}
