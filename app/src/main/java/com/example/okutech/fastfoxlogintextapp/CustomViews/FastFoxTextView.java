package com.example.okutech.fastfoxlogintextapp.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.okutech.fastfoxlogintextapp.R;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/5/17
 */

public class FastFoxTextView extends android.support.v7.widget.AppCompatTextView {

    private String mFontType;
    private final String OPEN_SENS_BOLD = "open_sens_bold";
    private final String OPEN_SENS_LIGHT = "open_sens_light";
    private final String OPEN_SENS_REGULAR = "open_sens_regular";
    private final String OPEN_SENS_SEMI_BOLD = "open_sens_semi_bold";

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
        applyFontType(context);
    }

    private void applyFontType(Context context) {
        switch (mFontType) {
            case OPEN_SENS_BOLD: {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
                setTypeface(face);
                break;
            }
            case OPEN_SENS_LIGHT: {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf");
                setTypeface(face);
                break;
            }
            case OPEN_SENS_REGULAR: {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
                setTypeface(face);
                break;
            }
            case OPEN_SENS_SEMI_BOLD: {
                Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");
                setTypeface(face);
                break;
            }
        }
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
