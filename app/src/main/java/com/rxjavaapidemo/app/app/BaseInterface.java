package com.rxjavaapidemo.app.app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

public interface BaseInterface {

    void loadFragment(Fragment fragment, int layoutRes);

    interface ViewInterface {

        void snackBar(View view, String message, String buttonText);

        Toolbar setUpToolBar(Context context, int mLayout, boolean show, String text);
    }


}
