package com.mmfront.common.Retrofit;

import io.reactivex.disposables.Disposable;

/**
 * Created by My on 2018/5/1.
 */

public abstract  class Observer<T> implements io.reactivex.Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        //添加订阅
        onDispsable(d);
    }


    protected abstract void onDispsable(Disposable d);
}
