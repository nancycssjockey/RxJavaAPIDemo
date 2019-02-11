package com.rxjavaapidemo.app.network;

import com.rxjavaapidemo.app.login.model.LoginModel;
import com.rxjavaapidemo.app.login.model.LoginResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * API endpoint retrofit definition
 */
public interface ApiService {


    //replace with actual API end point

    @POST("api/login")
    Single<LoginResponse> login(@Body LoginModel req);






}
