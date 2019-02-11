package com.rxjavaapidemo.app.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.rxjavaapidemo.R;
import com.rxjavaapidemo.app.BaseActivity;
import com.rxjavaapidemo.app.login.RxActivity;

public class SplashActivity extends BaseActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    Thread timer = new Thread() {
        // Thread to show the splash screen, then launch the main screen
        @Override
        public void run() {
            try {
                sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //Put login conditions here
                Intent i = new Intent(SplashActivity.this, RxActivity.class);
                startActivity(i);
                SplashActivity.this.finish();



            }

        }
    };
        timer.start();
}
}
