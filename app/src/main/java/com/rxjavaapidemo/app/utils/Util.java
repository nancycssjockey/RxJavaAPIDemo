package com.rxjavaapidemo.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import javax.inject.Singleton;

@Singleton
public class Util {

    private final boolean DEBUG = true;


    /**
     * This method is  Show toast message like connected or disconnected
     *
     * @param msg
     */
    public static void showToast(@NonNull Context context, @NonNull String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Custom duration toast
     */



    /**
     * Print log
     *
     * @param message
     */
    public void showLog(@NonNull String message) {
        if (DEBUG) {
            System.err.println(message);
        }
    }

    /**
     * Show Popup message
     *
     * @param context
     * @param title
     * @param message
     */
    public void showBuilder(@NonNull Context context, @NonNull String title, @NonNull String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.show();
    }



    public static boolean isNetworkAvailable(Context context) {

        // Add a null check before you proceed
            if (context == null) return false;
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            return info != null && info.isConnected() && info.isAvailable();


    }

    /**
     * To dismiss keyboard
     * @param activity
     */


    public static void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }



}
