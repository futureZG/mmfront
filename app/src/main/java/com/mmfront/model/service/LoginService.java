package com.mmfront.model.service;

import com.mmfront.model.bean.User;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by My on 2018/5/1.
 */

public interface LoginService {
    @GET("login/checkLogin/{phone}/{password}")
    Observable<User> login(@Path("phone") Long phone,@Path("password") String password);
}
