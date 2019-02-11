package com.rxjavaapidemo.app.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rxjavaapidemo.R;
import com.rxjavaapidemo.app.app.BaseFragment;
import com.rxjavaapidemo.app.app.RxJavaApp;
import com.rxjavaapidemo.app.login.model.LoginResponse;
import com.rxjavaapidemo.app.login.presenter.LoginContract;
import com.rxjavaapidemo.app.login.presenter.LoginPresenter;
import com.rxjavaapidemo.app.network.ApiClient;
import com.rxjavaapidemo.app.network.ApiService;
import com.rxjavaapidemo.app.utils.Util;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class LoginFragment extends BaseFragment implements LoginContract.View {
    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.link_signup)
    TextView _signupLink;
    RxJavaApp mApp;
    @Inject
    LoginPresenter loginPresenter;
    ApiService apiService;
    String mEmail, mPassword;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.d("onActivityCreated Called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_main, container, false);
        mApp = ((RxJavaApp) getActivity().getApplication());
        mApp.getLoginComponent().inject(this);
        ButterKnife.bind(this, v);
        apiService = ApiClient.getClient().create(ApiService.class);
        loginPresenter.init(LoginFragment.this, getActivity().getApplicationContext());
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginPresenter.validateCredentials();
                break;
            case R.id.link_signup:

                break;

        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


    @Override
    public void error(String msg) {
        //get responser error here

    }

    @Override
    public void startProgress() {
    //show progress bar here

    }

    @Override
    public void endProgress() {
    //dismiss progress bar here
    }


    @Override
    public void validateCreds() {

        mEmail = _emailText.getText().toString();
        mPassword = _passwordText.getText().toString();
        if (mEmail.isEmpty() && mPassword.isEmpty()) {
            _emailText.setError(getResources().getString(R.string.email_empty));
            _passwordText.setError(getResources().getString(R.string.password_empty));
        } else if (mEmail.isEmpty()) {
            _emailText.setError(getResources().getString(R.string.email_empty));
        } else if (mPassword.isEmpty()) {
            _passwordText.setError(getResources().getString(R.string.password_empty));
        } else {
            _emailText.setError(null);
            _passwordText.setError(null);

            Util.dismissKeyboard(getActivity());
            if (Util.isNetworkAvailable(getActivity())) {
                //login request here
                loginPresenter.loginProcess(mEmail, mPassword, apiService);
            } else {
                Timber.d("==Error");
            }


        }

    }

    @Override
    public void logSuccess(LoginResponse data) {

        //get api response here

    }
}
