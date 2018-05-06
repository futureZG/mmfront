package com.mmfront.base;

import android.content.Context;

import com.mmfront.progess.ObserverOnNextListener;
import com.mmfront.progess.ProgressObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhanggang6 on 2018/5/6.
 */

public class BaseModel<T> {
    /**
     * 封装线程管理和订阅的过程
     */
    public void Subscribe(Context context, final Observable observable, ObserverOnNextListener<T> listener) {
        final Observer<T> observer = new ProgressObserver<T>( listener,context);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
