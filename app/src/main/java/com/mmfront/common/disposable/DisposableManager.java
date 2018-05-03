package com.mmfront.common.disposable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by My on 2018/5/1.
 */

public class DisposableManager implements DisposableHelper<Object>{
    public static DisposableManager disposableManager;
    private CompositeDisposable mDisposable;

    public DisposableManager() {
        if (mDisposable == null){
            mDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void add(Disposable disposable) {
         if (disposable == null) return;
         mDisposable.add(disposable);
    }

    @Override
    public void cancel(Disposable disposable) {
       if (mDisposable != null){
           mDisposable.delete(disposable);
       }
    }

    @Override
    public void cancelAll() {
        if (mDisposable != null){
            mDisposable.clear();
        }
    }
    public static DisposableManager getInstance(){
        if (disposableManager == null){
            synchronized (DisposableManager.class){
                if (disposableManager == null){
                    disposableManager = new DisposableManager();
                }
            }
        }
        return disposableManager;
    }
}
