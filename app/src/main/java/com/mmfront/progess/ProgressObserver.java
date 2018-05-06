package com.mmfront.progess;

import android.content.Context;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhanggang6 on 2018/5/6.
 */

public class ProgressObserver<T> implements Observer<T> {
    private ObserverOnNextListener listener;
    private Context context;
    private Disposable d;

    public ProgressObserver(ObserverOnNextListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
