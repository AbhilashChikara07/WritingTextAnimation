package com.example.okutech.fastfoxlogintextapp.Utilities;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/8/17
 */

public class UtilClass {

    public static Typeface getTypeFace(Context context, String mFontType) {
        final String OPEN_SENS_BOLD = "open_sens_bold";
        final String OPEN_SENS_LIGHT = "open_sens_light";
        final String OPEN_SENS_REGULAR = "open_sens_regular";
        final String OPEN_SENS_SEMI_BOLD = "open_sens_semi_bold";

        switch (mFontType) {
            case OPEN_SENS_BOLD: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
            }
            case OPEN_SENS_LIGHT: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf");
            }
            case OPEN_SENS_REGULAR: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
            }
            case OPEN_SENS_SEMI_BOLD: {
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");
            }
        }
        return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
    }
}
