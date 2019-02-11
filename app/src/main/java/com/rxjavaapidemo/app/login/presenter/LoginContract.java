package com.rxjavaapidemo.app.login.presenter;

import com.rxjavaapidemo.app.login.model.LoginModel;
import com.rxjavaapidemo.app.login.model.LoginResponse;
import com.rxjavaapidemo.app.network.ApiService;

public class LoginContract {

    public interface View {
        //view methods


        void error(String msg);
        void startProgress();

        void endProgress();

        void validateCreds();

        void logSuccess(LoginResponse data);


    }

    public interface UserActionsListener {

        //login processing to be done here
        void loginProcess(String email, String password, ApiService apiService);

        // inputs validations
        void validateCredentials();



     }
}
