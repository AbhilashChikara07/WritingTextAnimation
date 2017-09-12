package com.example.okutech.fastfoxlogintextapp.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.okutech.fastfoxlogintextapp.R;
import com.example.okutech.fastfoxlogintextapp.Utilities.UtilClass;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/5/17
 */

public class FastFoxTextView extends android.support.v7.widget.AppCompatTextView {

    private String mFontType;

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 30;
    private Handler mHandler;
    private Runnable progressRunnable;

    public FastFoxTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TextViewFontType,
                0, 0);
        mFontType = typedArray.getString(R.styleable.TextViewFontType_font_type);
        setTypeface(UtilClass.getTypeFace(context, mFontType));
    }

    public void startTextAnimation(CharSequence text, final FinishAnimation finishAnimation) {
        this.mText = text;
        mIndex = 0;

        mHandler = new Handler();
        progressRunnable = new Runnable() {
            @Override
            public void run() {
                setText(mText.subSequence(0, mIndex++));
                if (mIndex <= mText.length()) {
                    mHandler.postDelayed(progressRunnable, mDelay);
                } else {
                    mHandler.removeCallbacks(progressRunnable);
                    finishAnimation.finishAnimationCallBack();
                }
            }
        };
        mHandler.post(progressRunnable);
    }

    public interface FinishAnimation {
        void finishAnimationCallBack();
    }
}
