package com.mmfront.contract;

import com.mmfront.base.BasePresenter;
import com.mmfront.base.BaseView;
import com.mmfront.model.bean.User;

import java.util.HashMap;

/**
 * Created by zhanggang6 on 2018/5/6.
 */

public interface LoginContract {
    interface View extends BaseView {

        void result(User data);

    }

    abstract class Presenter extends BasePresenter<View> {

        public Presenter(View view) {
            super(view);
        }

        public abstract void login(HashMap<String,String> login);
    }
}
