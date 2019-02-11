package com.rxjavaapidemo.app.login.presenter;


import android.content.Context;
import android.util.Log;

import com.rxjavaapidemo.app.login.model.LoginModel;
import com.rxjavaapidemo.app.login.model.LoginResponse;
import com.rxjavaapidemo.app.network.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class LoginPresenter implements LoginContract.UserActionsListener {

    LoginContract.View view;
    CompositeDisposable disposable = new CompositeDisposable();

    public void init(LoginContract.View view, Context context) {
        this.view = view;

    }

    @Override
    public void loginProcess(String email, String password, ApiService apiService) {
        //RX parse API response
        // send Parameters here
        LoginModel login = new LoginModel();
        login.setEmail(email);
        login.setPassword(password);
        try {

            // do stream work here
            disposable.add(apiService.login(login).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).  //replace with response model
                    subscribeWith(new DisposableSingleObserver<LoginResponse>() {
                        @Override
                        public void onSuccess(LoginResponse data) {
                            // store the data
                            view.endProgress();
                            view.logSuccess(data);
                            disposable.clear();

                        }
                        @Override
                        public void onError(Throwable e) {
                            Log.d("my error log", e.getMessage());
                            view.error(e.getMessage());
                        }
                    }));
        } catch (Exception e){
            e.printStackTrace();
            Timber.d(e.getMessage());
        }
    }



    @Override
    public void validateCredentials() {
        view.validateCreds();

    }
}


