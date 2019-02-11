package com.rxjavaapidemo.app.app;

import android.app.Application;
import com.rxjavaapidemo.app.DI.AppModule;
import com.rxjavaapidemo.app.DI.DaggerLoginComponent;
import com.rxjavaapidemo.app.DI.LoginComponent;
import com.rxjavaapidemo.app.login.presenter.LoginPresenter;



public class RxJavaApp extends Application {
    //Login component
    LoginComponent loginComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        loginComponent = DaggerLoginComponent.builder().appModule(new AppModule(new LoginPresenter())).build();
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }
}
