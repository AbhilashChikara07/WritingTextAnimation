package com.example.okutech.fastfoxlogintextapp.Utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/8/17
 */

public class UtilClass {

    public static Typeface getTypeFace(Context context, String mFontType) {
        if(!TextUtils.isEmpty(mFontType)){
            final String OPEN_SENS_BOLD = "open_sens_bold";
            final String OPEN_SENS_LIGHT = "open_sens_light";
            final String OPEN_SENS_SEMI_BOLD = "open_sens_semi_bold";

            switch (mFontType) {
                case OPEN_SENS_BOLD: {
                    return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
                }
                case OPEN_SENS_LIGHT: {
                    return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf");
                }
                case OPEN_SENS_SEMI_BOLD: {
                    return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");
                }
            }
            return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
        }
        else{
            return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
        }
    }

    public static Spannable getSelectedColorText(String text, int from, int end, int color) {
        Spannable spanText = new SpannableString(text);
        spanText.setSpan(new ForegroundColorSpan(color), from, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanText;
    }
}
