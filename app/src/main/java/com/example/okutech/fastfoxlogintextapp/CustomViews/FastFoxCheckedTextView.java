package com.example.okutech.fastfoxlogintextapp.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.util.AttributeSet;

import com.example.okutech.fastfoxlogintextapp.R;
import com.example.okutech.fastfoxlogintextapp.Utilities.UtilClass;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/15/17
 */

public class FastFoxCheckedTextView extends AppCompatCheckedTextView {

    private String mFontType = "open_sens_regular";

    public FastFoxCheckedTextView(Context context, AttributeSet attrs) {
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
}
