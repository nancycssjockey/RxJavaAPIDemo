package com.rxjavaapidemo.app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.rxjavaapidemo.app.app.BaseInterface;

import butterknife.ButterKnife;
import timber.log.Timber;


public class BaseActivity extends AppCompatActivity implements BaseInterface{

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("OnStart () &&& Starting timer");
    }
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        Timber.d("User interacting with screen");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ButterKnife.bind(this);
    }
    @Override
    public void loadFragment(Fragment fragment, int layoutRes) {
        // create a FragmentManager
        android.support.v4.app.FragmentManager fm = this.getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(layoutRes, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit(); // save the changes
        fm.executePendingTransactions();

    }





}
