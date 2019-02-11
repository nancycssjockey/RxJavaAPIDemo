package com.rxjavaapidemo.app.DI;


import com.rxjavaapidemo.app.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

 @Singleton
 @Component(modules = AppModule.class)
  public interface LoginComponent {
    void inject(LoginFragment loginFragment);
  }
