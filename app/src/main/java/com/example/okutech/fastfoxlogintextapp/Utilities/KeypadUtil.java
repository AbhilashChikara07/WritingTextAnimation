package com.example.okutech.fastfoxlogintextapp.Utilities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Description
 *
 * @author Abhilash Chikara
 * @version 1.0
 * @since 9/11/17
 */

public class KeypadUtil {
    /**
     * Show keypad and focus to given EditText
     */
    public static void showKeypad(Context context, EditText target) {
        if (context == null || target == null) {
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager(context);
        inputMethodManager.showSoftInput(target, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * Show keypad
     */
    public static void showKeypad(Activity activity) {
        try {
            InputMethodManager inputMethodManager = getInputMethodManager(activity);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
        }
    }

    /**
     * Show keypad and focus to given EditText.
     * Use this method if target EditText is in Dialog.
     */
    public static void showKeypadInDialog(Dialog dialog, EditText target) {
        if (dialog == null || target == null) {
            return;
        }
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        target.requestFocus();
    }

    /**
     * hide keypad
     *
     * @param target View that currently has focus
     */
    public static void hideKeypad(Context context, View target) {
        if (context == null || target == null) {
            return;
        }
        InputMethodManager inputMethodManager = getInputMethodManager(context);
        inputMethodManager.hideSoftInputFromWindow(target.getWindowToken(), 0);
    }

    /**
     * hide keypad
     *
     * @param activity Activity
     */
    public static void hideKeypad(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            hideKeypad(activity, view);
        }
    }

    private static InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    /**
     * @param activity Activity
     * @param listener KeypadVisibilityListener
     */
    public static void setOkuKeypadListener(@NonNull final Activity activity, @NonNull final KeypadVisibilityListener listener) {
        final View activityRoot = getActivityRoot(activity);
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    private final Rect r = new Rect();
                    private boolean wasOpened = false;

                    @Override
                    public void onGlobalLayout() {
                        activityRoot.getWindowVisibleDisplayFrame(r);
                        int screenHeight = activityRoot.getRootView().getHeight();
                        // r.bottom is the position above soft keypad or device button.
                        // if keypad is shown, the r.bottom is smaller than that before.
                        int keypadHeight = screenHeight - r.bottom;
                        boolean isOpen = keypadHeight > screenHeight * 0.15; // 0.15 ratio is perhaps enough to determine keypad height.
                        if (isOpen == wasOpened) {
                            return;
                        }
                        wasOpened = isOpen;
                        listener.onVisibilityChanged(isOpen);
                    }
                });
    }

    private static View getActivityRoot(Activity activity) {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }

    public interface KeypadVisibilityListener {
        void onVisibilityChanged(boolean isOpen);
    }
}
