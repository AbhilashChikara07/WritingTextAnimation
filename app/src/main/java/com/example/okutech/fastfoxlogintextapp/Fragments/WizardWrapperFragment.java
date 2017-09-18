package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.support.v4.app.Fragment;

import com.example.okutech.fastfoxlogintextapp.CustomViews.WizardCircleProgress;
import com.example.okutech.fastfoxlogintextapp.CustomViews.WizardLineView;
import com.example.okutech.fastfoxlogintextapp.R;

import butterknife.BindView;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/15/17
 */

public class WizardWrapperFragment extends Fragment {

    @BindView(R.id.firstWC)
    WizardCircleProgress mFirstWC;
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
    WizardLineView mFourthWL;
    @BindView(R.id.fifthWC)
    WizardCircleProgress mFifthWC;


    public void setWizardProgress(int pageNO) {
        if (pageNO == 1) {
            mFirstWC.setState(1);
        } else if (pageNO == 2) {
            mFirstWC.setState(2);
            mFirstWL.startProgress(100);
            mSecondWC.setState(1);
        } else if (pageNO == 3) {
            mFirstWC.setState(2);
            mFirstWL.startProgress(100);
            mSecondWC.setState(2);
            mSecondWL.startProgress(100);
            mThirdWC.setState(1);
        } else if (pageNO == 4) {
            mFirstWC.setState(2);
            mFirstWL.startProgress(100);
            mSecondWC.setState(2);
            mSecondWL.startProgress(100);
            mThirdWC.setState(2);
            mThirdWL.startProgress(100);
            mFourthWC.setState(1);
        } else if (pageNO == 5) {
            mFirstWC.setState(2);
            mFirstWL.startProgress(100);
            mSecondWC.setState(2);
            mSecondWL.startProgress(100);
            mThirdWC.setState(2);
            mThirdWL.startProgress(100);
            mFourthWC.setState(2);
            mFourthWL.startProgress(100);
            mFifthWC.setState(1);
        } else if (pageNO == 0) {
            mFirstWC.setState(0);
            mFirstWC.setProgressValue(0);
            mFirstWL.setProgress(0);

            mSecondWC.setState(0);
            mSecondWC.setProgressValue(0);
            mSecondWL.setProgress(0);

            mThirdWC.setState(0);
            mThirdWC.setProgressValue(0);
            mThirdWL.setProgress(0);

            mFourthWC.setState(0);
            mFourthWC.setProgressValue(0);
            mFourthWL.setProgress(0);

            mFifthWC.setState(0);
            mFifthWC.setProgressValue(0);
        }
    }
}
