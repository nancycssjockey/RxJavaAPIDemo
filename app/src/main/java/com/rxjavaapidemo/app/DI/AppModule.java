package com.rxjavaapidemo.app.DI;

import com.rxjavaapidemo.app.login.presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private LoginPresenter loginPresenter;

    public AppModule() {
    }

    public AppModule(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }


    @Provides
    @Singleton
    public LoginPresenter getLoginPresenter() {
        return loginPresenter;
    }





}
