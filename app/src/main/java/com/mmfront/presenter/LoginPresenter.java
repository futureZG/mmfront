package com.mmfront.presenter;

import com.mmfront.common.Retrofit.Observer;
import com.mmfront.common.disposable.DisposableManager;
import com.mmfront.model.bean.User;
import com.mmfront.model.domain.LoginDomain;
import com.mmfront.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * Created by My on 2018/5/1.
 */

public class LoginPresenter extends BasePresenter<BaseView>{
    private LoginDomain loginDomain;
    public LoginPresenter(){
        loginDomain = new LoginDomain();
    }
    public void checkLogin(Long phone,String password){
        loginDomain.checkLogin(phone, password, new Observer<User>() {
            @Override
            public void onNext(User user) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            protected void onDispsable(Disposable d) {
                DisposableManager.getInstance().add(d);
            }
        });
    }
}
