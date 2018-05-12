package com.mmfront.presenter;

import com.mmfront.api.LoginApi;
import com.mmfront.base.BaseView;
import com.mmfront.contract.LoginContract;
import com.mmfront.bean.User;
import com.mmfront.progess.ObserverOnNextListener;

import java.util.HashMap;

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
                getView().result((String) o);
            }
        });
    }
}
