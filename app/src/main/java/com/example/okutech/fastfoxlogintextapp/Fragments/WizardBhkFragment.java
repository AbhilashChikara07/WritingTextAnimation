package com.example.okutech.fastfoxlogintextapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxButton;
import com.example.okutech.fastfoxlogintextapp.CustomViews.FastFoxCheckedTextView;
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
 * @since 9/15/17
 */

public class WizardBhkFragment extends WizardWrapperFragment implements View.OnClickListener {

    @BindView(R.id.headerTV)
    FastFoxTextView mHeaderTV;
    @BindView(R.id.backIB)
    ImageButton mBackIB;
    @BindView(R.id.closeTV)
    FastFoxButton mCloseTV;

    @BindView(R.id.skipQuestionBTN)
    FastFoxButton mSkipQuestionBTN;
    @BindView(R.id.nextBTN)
    FastFoxButton nextBTN;

    @BindView(R.id.bhkContainerLL)
    LinearLayout mBhkContainerLL;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wizard_bhk_frag_lay, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.setWizardProgress(0);
        super.setWizardProgress(2);
        setListenerForBhk();
    }


    @OnClick(R.id.nextBTN)
    public void onClickNextBtn() {
        super.setWizardProgress(3);
    }


    /*
    * This function is used for set click listener for all FastFoxCheckTextView.
    * */
    private void setListenerForBhk() {
        int count = mBhkContainerLL.getChildCount();
        for (int i = 0; i < count; i++) {
            if (mBhkContainerLL.getChildAt(i) instanceof TableLayout) {
                TableLayout tableLayout = (TableLayout) mBhkContainerLL.getChildAt(i);
                for (int j = 0; j < tableLayout.getChildCount(); j++) {
                    if (tableLayout.getChildAt(j) instanceof TableRow) {
                        TableRow tableRow = (TableRow) tableLayout.getChildAt(j);
                        for (int k = 0; k < tableRow.getChildCount(); k++) {
                            if (tableRow.getChildAt(k) instanceof FastFoxCheckedTextView) {
                                FastFoxCheckedTextView checkedTextView = (FastFoxCheckedTextView)
                                        tableRow.getChildAt(k);
                                checkedTextView.setOnClickListener(this);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                if (view instanceof CheckedTextView) {
                    CheckedTextView checkedTextView = (CheckedTextView) view;
                    if (!checkedTextView.isChecked()) {
                        checkedTextView.setChecked(true);
                    } else {
                        checkedTextView.setChecked(false);
                    }
                }
                break;
            }
        }
    }
}
