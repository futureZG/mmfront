package com.mmfront.presenter;

import com.mmfront.api.LoginApi;
import com.mmfront.base.BaseView;
import com.mmfront.contract.LoginContract;
import com.mmfront.model.bean.User;
import com.mmfront.progess.ObserverOnNextListener;
import com.mmfront.service.LoginService;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by My on 2018/5/1.
 */

public class LoginPresenter extends LoginContract.Presenter{
    private BaseView view;

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }


    @Override
    public void login(HashMap<String, String> login) {
        mModel.Subscribe(mContext, LoginApi.getApiService().
                login(login.get("username"), login.get("password")), new ObserverOnNextListener() {
            @Override
            public void onNext(Object o) {
                getView().result((User) o);
            }
        });
    }
}
