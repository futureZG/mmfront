package com.mmfront.model.domain;


import com.mmfront.common.Retrofit.Observer;
import com.mmfront.common.Retrofit.RetrofitManager;
import com.mmfront.model.bean.User;
import com.mmfront.model.service.LoginService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by My on 2018/5/1.
 */

public class LoginDomain {

    public void checkLogin(Long phone, String password, Observer<User> observer){
        Observable<User> userObservable = RetrofitManager
                .getSingleton().getRetrofit()
                .create(LoginService.class)
                .login(phone,password);
        userObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
