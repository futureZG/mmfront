package com.mmfront.service;

import com.mmfront.bean.User;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by My on 2018/5/1.
 */

public interface LoginService {
    @GET("login/checkLoginGet/{phone}/{password}")
    Observable<User> login(@Path("phone") String phone,@Path("password") String password);
}
